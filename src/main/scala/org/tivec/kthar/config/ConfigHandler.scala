package org.tivec.kthar.config
/**
 * @author Henrik 'Tivec' Bergvin
 */
import java.io.File
import net.minecraftforge.common.Configuration
import org.tivec.kthar.items.ItemInfo


object ConfigHandler {

  def initConfig(confFile: File) {
    val config: Configuration = new Configuration(confFile)
    config.load()

    ItemInfo.CharcoalRodAssemblyID    = config.getItem(ItemInfo.CharcoalRodAssemblyKey, ItemInfo.CharcoalRodAssemblyID).getInt - 256
    ItemInfo.CharcoalRodID            = config.getItem(ItemInfo.CharcoalRodKey, ItemInfo.CharcoalRodID).getInt - 256
    ItemInfo.RedstoneInfusedRodID     = config.getItem(ItemInfo.RedstoneInfusedRodKey, ItemInfo.RedstoneInfusedRodID).getInt - 256
    ItemInfo.RedstoneInfusedPieceID   = config.getItem(ItemInfo.RedstoneInfusedPieceKey, ItemInfo.RedstoneInfusedPieceID ).getInt - 256
    ItemInfo.RedstoneInfusedCrossID   = config.getItem(ItemInfo.RedstoneInfusedCrossKey, ItemInfo.RedstoneInfusedCrossID).getInt - 256
    ItemInfo.RedstoneInfusedJoinID    = config.getItem(ItemInfo.RedstoneInfusedJoinKey, ItemInfo.RedstoneInfusedJoinID).getInt - 256

    config.save()
  }

}