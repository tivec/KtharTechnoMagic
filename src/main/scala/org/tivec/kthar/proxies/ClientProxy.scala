package org.tivec.kthar.proxies

/**
 * @author Henrik 'Tivec' Bergvin
 */
class ClientProxy extends CommonProxy {
  /**
   * @return Whether or not the proxy is on the server-side
   */
  override def isServer: Boolean = true

  /**
   * Initializes the sounds
   */
  override def initSounds() {

  }

  /**
   * Registers custom renders
   */
  override def initRenderers() {}
}
