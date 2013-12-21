package org.tivec.kthar.blocks

import net.minecraft.block.material.Material
import net.minecraft.block.{Block, BlockContainer}
import org.tivec.kthar.KtharMagic
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.Icon

/**
 * @author Henrik 'Tivec' Bergvin
 */
abstract class KtharMachineBlock(blockId : Int, blockMaterial: Material, unlocalizedName: String) extends BlockContainer(blockId, blockMaterial) {
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
   * Stores the icons used for the non-face sides of the machine when it is active (1) or inactive (0)
   */
  var sideIcons: Array[Icon] = new Array(2)

  /**
   * Stores whether or not the machine is rotation-sensitive (has an explicit face).
   */
  var isRotationSensitive: Boolean = false

}
