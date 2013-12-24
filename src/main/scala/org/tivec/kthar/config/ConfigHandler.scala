package org.tivec.kthar.config
/**
 * @author Henrik 'Tivec' Bergvin
 */
import java.io.File
import net.minecraftforge.common.Configuration
import org.tivec.kthar.items.ItemInfo
import org.tivec.kthar.blocks.BlockInfo


object ConfigHandler {

  def initConfig(confFile: File) {
    val config: Configuration = new Configuration(confFile)
    config.load()

    ItemInfo.CharcoalRodAssemblyID    = config.getItem(ItemInfo.CATEGORY, ItemInfo.CharcoalRodAssemblyKey, ItemInfo.CharcoalRodAssemblyID).getInt - 256
    ItemInfo.CharcoalRodID            = config.getItem(ItemInfo.CATEGORY, ItemInfo.CharcoalRodKey, ItemInfo.CharcoalRodID).getInt - 256

    ItemInfo.RedstoneInfusedRodID     = config.getItem(ItemInfo.CATEGORY, ItemInfo.RedstoneInfusedRodKey, ItemInfo.RedstoneInfusedRodID).getInt - 256
    ItemInfo.RedstoneInfusedPieceID   = config.getItem(ItemInfo.CATEGORY, ItemInfo.RedstoneInfusedPieceKey, ItemInfo.RedstoneInfusedPieceID).getInt - 256
    ItemInfo.RedstoneInfusedJoinID    = config.getItem(ItemInfo.CATEGORY, ItemInfo.RedstoneInfusedJoinKey, ItemInfo.RedstoneInfusedJoinID).getInt - 256
    ItemInfo.RedstoneInfusedCrossID   = config.getItem(ItemInfo.CATEGORY, ItemInfo.RedstoneInfusedCrossKey, ItemInfo.RedstoneInfusedCrossID).getInt - 256

    ItemInfo.IronCoreID               = config.getItem(ItemInfo.CATEGORY, ItemInfo.IronCoreKey, ItemInfo.IronCoreID).getInt - 256
    ItemInfo.GoldCoreID               = config.getItem(ItemInfo.CATEGORY, ItemInfo.GoldCoreKey, ItemInfo.GoldCoreID).getInt - 256
    ItemInfo.DiamondCoreID            = config.getItem(ItemInfo.CATEGORY, ItemInfo.DiamondCoreKey, ItemInfo.DiamondCoreID).getInt - 256

    BlockInfo.InfusedCoreCompactorID  = config.getBlock(BlockInfo.CATEGORY, BlockInfo.InfusedCoreCompactorKey, BlockInfo.InfusedCoreCompactorID).getInt
    BlockInfo.TharditeOreID          = config.getBlock(BlockInfo.CATEGORY, BlockInfo.TharditeOreKey, BlockInfo.TharditeOreID).getInt

    config.save()
  }

}