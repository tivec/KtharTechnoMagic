package org.tivec.kthar.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import org.tivec.kthar.KtharMagic
import net.minecraft.client.renderer.texture.IconRegister

/**
 * @author Henrik 'Tivec' Bergvin
 */
object BlockAlmanditeOre extends Block(BlockInfo.AlmanditeOreID, Material.rock) {
  setCreativeTab(KtharMagic.creativeTab)
  setHardness(3f)
  setResistance(5f)
  setUnlocalizedName(BlockInfo.AlmanditeOreKey)

  /**
   * Registers the block's texture based on ModularForcefieldSystem#ASSET_DIR and its unlocalized name.
   *
   * @param iconRegister  Icon register that Minecraft will use when stitching the texture atlas.
   */
  override def registerIcons(iconRegister: IconRegister) = {
    blockIcon = iconRegister.registerIcon(s"${KtharMagic.ASSET_DIR}:${getUnlocalizedName}")
  }
}
