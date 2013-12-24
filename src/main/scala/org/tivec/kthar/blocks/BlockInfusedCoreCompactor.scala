package org.tivec.kthar.blocks

import net.minecraft.block.Block
import org.tivec.kthar.KtharMagic
import net.minecraft.block.material.Material
import net.minecraft.item.ItemBlock

/**
 * @author Henrik 'Tivec' Bergvin
 */
object BlockInfusedCoreCompactor extends KtharMachineBlock(BlockInfo.InfusedCoreCompactorID, Material.iron, BlockInfo.InfusedCoreCompactorKey) {
  setCreativeTab(KtharMagic.creativeTab)
  setHardness(2F)
  setStepSound(Block.soundMetalFootstep)
  setUnlocalizedName(BlockInfo.InfusedCoreCompactorKey)
  isRotationSensitive = true

}

class ItemBlockInfusedCoreCompactor(id: Int) extends ItemBlock(id) {}

