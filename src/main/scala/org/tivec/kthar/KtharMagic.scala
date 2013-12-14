package org.tivec.kthar

import cpw.mods.fml.common.{FMLLog, Mod}
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLPreInitializationEvent, FMLInitializationEvent}
import net.minecraft.creativetab.CreativeTabs
import org.tivec.kthar.config.Config


@Mod(name = "K'thar Magic", modid = "kthartechnomagic", version = "0.0.0", modLanguage = "scala")
object KtharMagic {

  var ASSET_DIR: String = "kthar"
  val creativeTab: CreativeTabs = new CreativeTabs("KtharTab") {}

  /**
   * Loads mod configuration details and uses this data to register blocks, items and OreDictionary values.
   *
   * @param eventArgs Event arguments passed by Forge Mod Loader.
   */
  @EventHandler
  def preInit(eventArgs: FMLPreInitializationEvent) = {
    FMLLog.info("K'thar Magic: preInit")

    // setup configuration
    Config.initConfig(eventArgs.getSuggestedConfigurationFile)

    // Register all mod blocks.
    registerBlocks()

    // Register all mod items.
    registerItems()
  }


  /**
   * Registers world generation and item/block recipes.
   *
   * @param eventArgs Event arguments passed by Forge Mod Loader.
   */
  @EventHandler
  def init(eventArgs: FMLInitializationEvent) = {
    FMLLog.info("K'thar Magic: init")
  }

  /**
   * Determines what associated mods are loaded, and initializes their individual interop modules.
   *
   * @param eventArgs Event arguments passed by Forge Mod Loader.
   */
  @EventHandler
  def postInit(eventArgs: FMLPostInitializationEvent) = {
    FMLLog.info("K'thar Magic: postInit")
  }

  /**
   * Registers all blocks and associated tile entities (if the tile entity exists).
   */
  def registerBlocks() = {}

  /**
   * Registers all items.
   */
  def registerItems() = {}

}