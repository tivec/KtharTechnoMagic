package org.tivec.kthar.items

import net.minecraft.item.Item
import org.tivec.kthar.KtharMagic
import net.minecraft.client.renderer.texture.IconRegister
import cpw.mods.fml.relauncher.{SideOnly, Side}

/**
 * @author Henrik 'Tivec' Bergvin
 */
class KtharItem(itemID: Int, unlocalizedName: String) extends Item(itemID) {
  setCreativeTab(KtharMagic.creativeTab)
  setUnlocalizedName(unlocalizedName)

  /**
   * Registers the item's texture based on ModularForcefieldSystem#ASSET_DIR and its unlocalized name.
   *
   * @param iconRegister  Icon register that Minecraft will use when stitching the texture atlas.
   */
  @SideOnly(Side.CLIENT)
  override def registerIcons(iconRegister: IconRegister) = {
    itemIcon = iconRegister.registerIcon(s"${KtharMagic.ASSET_DIR}:${getUnlocalizedName}")
  }
}
