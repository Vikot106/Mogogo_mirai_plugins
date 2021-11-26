package ink.moku

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value

object Config : AutoSavePluginConfig("InfoConfig"){
    @ValueDescription("机器人所有者")
    val owner: Long by value(905908099L)

    @ValueDescription("触发关键字")
    val keyWord: MutableMap<Int,String> = emptyMap<Int,String>() as MutableMap<Int, String>

    @ValueDescription("回复")
    val reply: MutableMap<Int,String> = emptyMap<Int,String>() as MutableMap<Int, String>
}
