package org.tivec.kthar

/**
 * @author Henrik 'Tivec' Bergvin
 */
import cpw.mods.fml.common.{SidedProxy, FMLLog, Mod}
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLPreInitializationEvent, FMLInitializationEvent}
import net.minecraft.creativetab.CreativeTabs
import org.tivec.kthar.config.ConfigHandler
import cpw.mods.fml.common.network.NetworkMod
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler
import org.tivec.kthar.network.client.ClientPacketHandler
import org.tivec.kthar.network.server.ServerPacketHandler
import org.tivec.kthar.proxies.CommonProxy
import org.tivec.kthar.network.packets.KtharPacket
import cpw.mods.fml.common.registry.GameRegistry
import org.tivec.kthar.items._
import net.minecraft.item.{Item, ItemStack}
import net.minecraftforge.oredict.{ShapedOreRecipe, OreDictionary}
import net.minecraft.item.crafting.{CraftingManager, IRecipe}
import java.util.{List => JList}
import java.util


@Mod(name = "K'thar Techno-Magic", modid = "kthartechnomagic", version = "dev", modLanguage = "scala")
@NetworkMod(
  clientSideRequired = true, serverSideRequired = true,
  clientPacketHandlerSpec = new SidedPacketHandler(
    channels = Array(KtharPacket.CHANNEL),
    packetHandler = classOf[ClientPacketHandler]

  ),
  serverPacketHandlerSpec = new SidedPacketHandler(
    channels = Array(KtharPacket.CHANNEL),
    packetHandler = classOf[ServerPacketHandler]
  )
)
object KtharMagic {

  val ASSET_DIR: String = "kthar"
  val creativeTab: CreativeTabs = new CreativeTabs("KtharTab") {}

  @SidedProxy(clientSide = "org.tivec.kthar.proxies.ClientProxy", serverSide = "org.tivec.kthar.proxies.CommonProxy")
  var proxy: CommonProxy = null

  /**
   * Loads mod configuration details and uses this data to register blocks, items and OreDictionary values.
   *
   * @param eventArgs Event arguments passed by Forge Mod Loader.
   */
  @EventHandler
  def preInit(eventArgs: FMLPreInitializationEvent) = {
    FMLLog.info("K'thar Magic: preInit")

    // setup configuration
    ConfigHandler.initConfig(eventArgs.getSuggestedConfigurationFile)

    // set up sounds and renderes
    proxy.initSounds()
    proxy.initRenderers()

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

    registerRecipes()
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
  def registerItems() = {
    def registerItem(item: KtharItem) = GameRegistry.registerItem(item, item.getUnlocalizedName)

    registerItem(ItemCharcoalRodAssembly)
    registerItem(ItemCharcoalRod)
    registerItem(ItemRedstoneInfusedRod)
    registerItem(ItemRedstoneInfusedPiece)
    registerItem(ItemRedstoneInfusedCross)
    registerItem(ItemRedstoneInfusedJoin)
  }

  /**
   * Register recipes
   */

  def registerRecipes() = {

    // All the items
    ItemRecipes.init()

 }

}