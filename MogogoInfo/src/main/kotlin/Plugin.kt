package ink.moku

import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.console.plugin.jvm.reloadPluginConfig
import net.mamoe.mirai.utils.info

object Plugin : KotlinPlugin(
    JvmPluginDescription(
        id = "ink.moku.plugin",
        name = "MogogoInfo",
        version = "1.0",
    ) {
        author("Vikot106")
    }
) {
    override fun onEnable() {
        reloadPluginConfig(Config)
        logger.info { "MogogoInfo加载成功！" }
    }

    fun handleMsg(){

    }
}
