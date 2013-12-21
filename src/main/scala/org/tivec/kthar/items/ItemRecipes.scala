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
      "/ /",
      " c ",
      "/ /",
      '/':Character, "stickWood",
      'c':Character, new ItemStack(Item.coal,1,1)
      ))

    /********************************************************
     * Charcoal Rod (No experience for this!)
     ********************************************************/
    GameRegistry.addSmelting(ItemCharcoalRodAssembly.itemID, new ItemStack(ItemCharcoalRod, 4), 0.0f)

    /********************************************************
     * Redstone Infused Pieces
     ********************************************************/

    // Rod into 2 pieces
    GameRegistry.addShapelessRecipe(new ItemStack(ItemRIPiece,2), new ItemStack(ItemRIRod))
    // Joiner into 3 pieces
    GameRegistry.addShapelessRecipe(new ItemStack(ItemRIPiece,3), new ItemStack(ItemRIJoiner))
    // Cross into 4 pieces
    GameRegistry.addShapelessRecipe(new ItemStack(ItemRIPiece,4), new ItemStack(ItemRICross))

    /********************************************************
     * Redstone Infused Rods
     ********************************************************/
    // Infused rod from charcoal rods and redstone
    GameRegistry.addRecipe(new ShapedOreRecipe(
      new ItemStack(ItemRIRod),
      "r  ",
      " / ",
      "  r",
      '/':Character, ItemCharcoalRod,
      'r':Character, Item.redstone))

    // Infused rod from two pieces and redstone
    GameRegistry.addRecipe(new ShapedOreRecipe(
      new ItemStack(ItemRIRod),
      "/  ",
      " r ",
      "  /",
      '/':Character, new ItemStack(ItemRIPiece),
      'r':Character, Item.redstone))

    // Breaking apart the Infused Crosses into rods
    GameRegistry.addShapelessRecipe(new ItemStack(ItemRIRod,2), new ItemStack(ItemRICross))

    /********************************************************
     * Redstone Infused Joiner
     ********************************************************/
    // Crafting the Joiner with pieces and redstone
    GameRegistry.addRecipe(new ShapedOreRecipe(
      new ItemStack(ItemRIJoiner),
      "/ /",
      " r ",
      "  /",
      '/':Character, new ItemStack(ItemRIPiece),
      'r':Character, Item.redstone))

    /********************************************************
     * Redstone Infused Cross
     ********************************************************/
    // Crafting the Cross with pieces and redstone
    GameRegistry.addRecipe(new ShapedOreRecipe(
      new ItemStack(ItemRICross),
      "/ /",
      " r ",
      "/ /",
      '/':Character, new ItemStack(ItemRIPiece),
      'r':Character, Item.redstone))



  }

}
