package org.tivec.kthar.items

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraftforge.oredict.ShapedOreRecipe
import net.minecraft.item.{Item, ItemStack}

/**
  * @author Henrik 'Tivec' Bergvin
  */
object ItemRedstoneInfusedJoin extends KtharItem(ItemInfo.RedstoneInfusedJoinID, ItemInfo.RedstoneInfusedJoinKey) {
   setMaxStackSize(16)
}
