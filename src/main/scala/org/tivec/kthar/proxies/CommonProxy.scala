package org.tivec.kthar.proxies

/**
 * @author Henrik 'Tivec' Bergvin
 */
class CommonProxy {
  /**
   * @return Whether or not the proxy is on the server-side
   */
  def isServer: Boolean = true

  /**
   * Initializes the sounds
   */
  def initSounds() {

  }

  /**
   * Registers custom renders
   */
  def initRenderers() {}
}
