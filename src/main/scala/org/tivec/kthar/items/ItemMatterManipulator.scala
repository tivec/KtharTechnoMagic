package org.tivec.kthar.items

import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraft.entity.player.EntityPlayer
import org.tivec.kthar.blocks.BlockInfusedCoreCompactor
import net.minecraftforge.common.ForgeDirection
import net.minecraft.client.Minecraft

/**
 * @author Henrik 'Tivec' Bergvin
 */
object ItemMatterManipulator extends KtharItem(ItemInfo.MatterManipulatorID, ItemInfo.MatterManipulatorKey) {

  override def onItemUseFirst(stack: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, side: Int, hitX: Float, hitY: Float, hitZ: Float): Boolean = {

    if (!world.isRemote && world.getBlockId(x,y,z) == BlockInfusedCoreCompactor.blockID) {

      val meta: Int = world.getBlockMetadata(x,y,z)

      if (!BlockInfusedCoreCompactor.isActiveSide(side, meta)) {
        BlockInfusedCoreCompactor.rotateBlock(world, x,y,z, ForgeDirection.getOrientation(side))
        return true
      } else {

        val enabled: Boolean = BlockInfusedCoreCompactor.isEnabled(meta)
        if (enabled) {
          world.setBlockMetadataWithNotify(x,y,z,BlockInfusedCoreCompactor.setActiveState(meta,state = false),3)
        } else {
          world.setBlockMetadataWithNotify(x,y,z,BlockInfusedCoreCompactor.setActiveState(meta,state = true),3)
        }
        return true
      }
    }

    false
  }

}
