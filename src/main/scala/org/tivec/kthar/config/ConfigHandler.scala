package org.tivec.kthar.config
/**
 * @author Henrik 'Tivec' Bergvin
 */
import java.io.File
import net.minecraftforge.common.Configuration


object ConfigHandler {

  def initConfig(confFile: File) {
    val config: Configuration = new Configuration(confFile)
    config.load()

    

    config.save()
  }

}