package org.tivec.kthar.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import org.tivec.kthar.KtharMagic
import net.minecraft.client.renderer.texture.IconRegister
import java.util.Random
import org.tivec.kthar.items.ItemInfo

/**
 * @author Henrik 'Tivec' Bergvin
 */
object BlockTharditeOre extends Block(BlockInfo.TharditeOreID, Material.rock) {
  setCreativeTab(KtharMagic.creativeTab)
  setHardness(3f)
  setResistance(3f)
  setUnlocalizedName(BlockInfo.TharditeOreKey)

  /**
   * Registers the block's texture based on ModularForcefieldSystem#ASSET_DIR and its unlocalized name.
   *
   * @param iconRegister  Icon register that Minecraft will use when stitching the texture atlas.
   */
  override def registerIcons(iconRegister: IconRegister) = {
    blockIcon = iconRegister.registerIcon(s"${KtharMagic.ASSET_DIR}:$getUnlocalizedName")
  }

  override def idDropped(par1: Int, random: Random, par3: Int): Int = {
    ItemInfo.TharditeShardID +256
  }

  /**
   * Returns the amount dropped when broken
   * @param random    The random number generator
   * @return          A number between 1 and 3
   */
  override def quantityDropped(random: Random): Int = {
    1 + random.nextInt(2)
  }

  /**
   * Returns the amount dropped when broken, with fortune pickaxe modifiers applied
   * @param i         The level of the fortune pick
   * @param random    The random number generator
   * @return          A number between 1 and i+1
   */
  override def quantityDroppedWithBonus(i: Int, random: Random): Int = {
    this.quantityDropped(random) + random.nextInt(i+1)
  }
}
