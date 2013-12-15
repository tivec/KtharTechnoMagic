package org.tivec.kthar.network.client

import cpw.mods.fml.common.network.{Player, IPacketHandler}
import net.minecraft.network.INetworkManager
import net.minecraft.network.packet.Packet250CustomPayload

/**
 * @author Henrik 'Tivec' Bergvin
 */
class ClientPacketHandler extends IPacketHandler {
  override def onPacketData(manager: INetworkManager, packet: Packet250CustomPayload, player: Player) {

  }
}
