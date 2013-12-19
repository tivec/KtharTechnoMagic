package org.tivec.kthar.items

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraftforge.oredict.ShapedOreRecipe
import net.minecraft.item.{Item, ItemStack}

/**
 * @author Henrik 'Tivec' Bergvin
 */
object ItemRecipes {

  def init() {
    /********************************************************
     * Charcoal Rod Assembly
     ********************************************************/
    GameRegistry.addRecipe(new ShapedOreRecipe(
      new ItemStack(ItemCharcoalRodAssembly),
      "//",
      "//",
      '/':Character, "stickWood"
      ))

    /********************************************************
     * Charcoal Rod (No experience for this!)
     ********************************************************/
    GameRegistry.addSmelting(ItemCharcoalRodAssembly.itemID, new ItemStack(ItemCharcoalRod, 4), 0.0f)

    /********************************************************
     * Redstone Infused Pieces
     ********************************************************/

    // Rod into 2 pieces
    GameRegistry.addShapelessRecipe(new ItemStack(ItemRedstoneInfusedPiece, 2), new ItemStack(ItemRedstoneInfusedRod))
    // Joiner into 3 pieces
    GameRegistry.addShapelessRecipe(new ItemStack(ItemRedstoneInfusedPiece, 3), new ItemStack(ItemRedstoneInfusedJoin))
    // Cross into 4 pieces
    GameRegistry.addShapelessRecipe(new ItemStack(ItemRedstoneInfusedPiece, 4), new ItemStack(ItemRedstoneInfusedCross))

    /********************************************************
     * Redstone Infused Rods
     ********************************************************/
    // Infused rod from charcoal rods and redstone
    GameRegistry.addRecipe(new ShapedOreRecipe(
      new ItemStack(ItemRedstoneInfusedRod),
      "r  ",
      " / ",
      "  r",
      '/':Character, ItemCharcoalRod,
      'r':Character, Item.redstone))

    // Infused rod from two pieces and redstone
    GameRegistry.addRecipe(new ShapedOreRecipe(
      new ItemStack(ItemRedstoneInfusedRod),
      "/  ",
      " r ",
      "  /",
      '/':Character, ItemRedstoneInfusedPiece,
      'r':Character, Item.redstone))

    // Breaking apart the Infused Crosses into rods
    GameRegistry.addShapelessRecipe(new ItemStack(ItemRedstoneInfusedRod, 2), new ItemStack(ItemRedstoneInfusedCross))

    /********************************************************
     * Redstone Infused Joiner
     ********************************************************/
    // Crafting the Joiner with pieces and redstone
    GameRegistry.addRecipe(new ShapedOreRecipe(
      new ItemStack(ItemRedstoneInfusedJoin),
      "/ /",
      " r ",
      "  /",
      '/':Character, ItemRedstoneInfusedPiece,
      'r':Character, Item.redstone))

    /********************************************************
     * Redstone Infused Cross
     ********************************************************/
    // Crafting the Cross with pieces and redstone
    GameRegistry.addRecipe(new ShapedOreRecipe(
      new ItemStack(ItemRedstoneInfusedCross),
      "/ /",
      " r ",
      "/ /",
      '/':Character, ItemRedstoneInfusedPiece,
      'r':Character, Item.redstone))



  }

}
