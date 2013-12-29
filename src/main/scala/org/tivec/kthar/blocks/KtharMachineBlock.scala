package org.tivec.kthar.blocks

import net.minecraft.block.material.Material
import net.minecraft.block.{Block, BlockContainer}
import org.tivec.kthar.KtharMagic
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.{ResourceLocation, MathHelper, Icon}
import net.minecraft.client.renderer.texture.IconRegister
import net.minecraft.world.{IBlockAccess, World}
import net.minecraftforge.common.ForgeDirection
import net.minecraft.entity.{Entity, EntityLivingBase}
import net.minecraft.item.ItemStack

/**
 * @author Henrik 'Tivec' Bergvin
 */

object KtharMachineBlock {
  // bitmask for the current rotation
  final val ROTATION_MASK = 0x00000007
  final val ACTIVE_MASK = 0x00000008
}

abstract class KtharMachineBlock(blockId : Int, blockMaterial: Material, unlocalizedName: String) extends Block(blockId, blockMaterial) {
  setCreativeTab(KtharMagic.creativeTab)
  setHardness(2F)
  setResistance(5F)
  setStepSound(Block.soundMetalFootstep)
  setUnlocalizedName(BlockInfo.InfusedCoreCompactorKey)

  /**
   * @return Class representing the tile entity associated with this block.
   */
  def tileEntityClass: Class[_ <: TileEntity] = null

  /**
   * Face icon to use when the machine is active.
   */
  var activeIcon: Icon = null

  /**
   * Stores the icons used for the non-face sides of the machine
   */
  var sideIcon: Icon = null

  /**
   * Stores whether or not the machine is rotation-sensitive (has an explicit face).
   */
  var isRotationSensitive: Boolean = false

  /**
   * Registers the block's texture based on the ASSET_DIR, the particular side, and its unlocalized name.
   *
   * @param iconRegister  Icon register that Minecraft will use when stitching the texture atlas.
   */
  override def registerIcons(iconRegister: IconRegister) = {

    blockIcon = iconRegister.registerIcon(s"${KtharMagic.ASSET_DIR}:machine/${getUnlocalizedName}_Front")
    activeIcon = iconRegister.registerIcon(s"${KtharMagic.ASSET_DIR}:machine/${getUnlocalizedName}_Active")

    if(isRotationSensitive)
      sideIcon = iconRegister.registerIcon(s"${KtharMagic.ASSET_DIR}:machine/${getUnlocalizedName}_Side")

  }

  /**
   * Retrieves the icon for the block, but doesn't care about the metadata. This is only
   * used in the inventory
   * @param side      Side of the block the icon is being retrieved for.
   * @param metadata  Metadata for the current block.
   */
  override def getIcon(side: Int, metadata: Int): Icon = {
    ForgeDirection.getOrientation(side) match {
      case ForgeDirection.WEST => blockIcon
      case _ => sideIcon
    }
  }

  def isEnabled(metadata: Int): Boolean = {
    (metadata & KtharMachineBlock.ACTIVE_MASK) == KtharMachineBlock.ACTIVE_MASK
  }

  def enable(metadata: Int): Int = {
    metadata | KtharMachineBlock.ACTIVE_MASK
  }

  def disable(metadata: Int): Int = {
    if (isEnabled(metadata)) {
      return metadata ^ KtharMachineBlock.ACTIVE_MASK
    }
    metadata
  }

  def getRotation(metadata: Int): Int = {
    metadata & KtharMachineBlock.ROTATION_MASK
  }

  def isActiveSide(side: Int, metadata: Int): Boolean = {
    if(isRotationSensitive && side == (metadata & KtharMachineBlock.ROTATION_MASK))
      return true

    false
  }

  /**
   * Returns the icon for the given side, based on the metadata of the block, rotation and active state.
   * @param block     the BlockAccess we're looking at
   * @param x         x coordinate
   * @param y         y coordinate
   * @param z         z coordinate
   * @param side      the side we want to show
   * @return          an icon
   */
  override def getBlockTexture(block: IBlockAccess, x: Int, y: Int, z: Int, side: Int): Icon = {
    val metadata = block.getBlockMetadata(x,y,z)
    if(isRotationSensitive && side != (metadata & KtharMachineBlock.ROTATION_MASK))
      return sideIcon

    if(isEnabled(metadata))
      return activeIcon

    blockIcon
  }

  /**
   * Rotates the block to face the specified ForgeDirection.
   *
   * @param world         World in which the block resides.
   * @param x             X coordinate for the block.
   * @param y             Y coordinate for the block.
   * @param z             Z coordinate for the block.
   * @param newDirection  New ForgeDirection that the block should face.
   */
  override def rotateBlock(world: World, x: Int, y: Int, z: Int, newDirection: ForgeDirection): Boolean = {
    if(!isRotationSensitive)
      return false

    var metadata: Int = world.getBlockMetadata(x, y, z)
    val isActive = metadata & KtharMachineBlock.ACTIVE_MASK
    val dir = newDirection.ordinal()

    metadata = isActive | dir

    world.setBlockMetadataWithNotify(x, y, z, metadata, 2)

    true
  }

  /**
   * Fired when you place the block in the world
   * @param world       World in which the block is placed
   * @param x           X coordinate
   * @param y           Y coordinate
   * @param z           Z coordinate
   * @param player      Player that places it
   * @param itemstack   The itemstack
   */
  override def onBlockPlacedBy(world: World, x: Int, y: Int, z: Int, player: EntityLivingBase, itemstack: ItemStack) {
    if(!isRotationSensitive)
      return

    super.onBlockPlacedBy(world, x, y, z, player, itemstack)
    val l: Int = MathHelper.floor_double((player.rotationYaw * 4.0f /360.0f) +0.5f) & 3

    var metadata: Int = world.getBlockMetadata(x, y, z)
    val isActive = metadata & KtharMachineBlock.ACTIVE_MASK
    val dir = l match {
      case 0 => 2
      case 1 => 5
      case 2 => 3
      case 3 => 4
    }

    metadata = isActive | (dir & KtharMachineBlock.ROTATION_MASK)
    world.setBlockMetadataWithNotify(x, y, z, metadata, 2)

  }
}
