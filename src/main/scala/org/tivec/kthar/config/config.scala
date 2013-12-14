package org.tivec.kthar.config
import java.io.File

import net.minecraftforge.common.Configuration

object Config {

  def initConfig(confFile: File) {
    val config: Configuration = new Configuration(confFile)
    config.load()



    config.save()
  }



}