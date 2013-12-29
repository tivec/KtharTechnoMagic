package org.tivec.kthar.blocks

import net.minecraft.block.Block
import org.tivec.kthar.KtharMagic
import net.minecraft.block.material.Material
import net.minecraft.item.ItemBlock
import net.minecraft.client.renderer.texture.IconRegister
import net.minecraft.util.Icon
import net.minecraft.world.World
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer

/**
 * @author Henrik 'Tivec' Bergvin
 */
object BlockInfusedCoreCompactor extends KtharMachineBlock(BlockInfo.InfusedCoreCompactorID, Material.iron, BlockInfo.InfusedCoreCompactorKey) {
  setCreativeTab(KtharMagic.creativeTab)
  setHardness(2F)
  setStepSound(Block.soundMetalFootstep)
  setUnlocalizedName(BlockInfo.InfusedCoreCompactorKey)
  isRotationSensitive = true

  override def onEntityWalking(world: World, x: Int, y: Int, z: Int, entity: Entity) {
    if (!world.isRemote) {
      spawnAnvil(world, x, y + 20, z)
    }
  }

  override def onNeighborBlockChange(world: World, x: Int, y: Int, z: Int, id: Int) {
    if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x,y,z) && isEnabled(world.getBlockMetadata(x,y,z))) {
      for (i <- -2 to 2; j <- -2 to 2) {
        spawnAnvil(world, x+i, y+20, z+j)
      }
    }
  }

  private def spawnAnvil(world: World, x: Int, y: Int, z: Int) {
    if (world.isAirBlock(x,y,z))
      world.setBlock(x,y,z, Block.anvil.blockID)
  }
}

class ItemBlockInfusedCoreCompactor(id: Int) extends ItemBlock(id) {}

