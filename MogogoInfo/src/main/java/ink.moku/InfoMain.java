package ink.moku;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.events.MessageEvent;

public final class InfoMain extends JavaPlugin {
    public static final InfoMain INSTANCE = new InfoMain();

    private InfoMain() {
        super(new JvmPluginDescriptionBuilder("ink.moku.plugin.mogogoinfo", "1.0")
                .name("MogogoInfo")
                .author("Vikot106")
                .build());
    }

    @Override
    public void onEnable() {
        reloadPluginConfig(Config.INSTANCE);
        GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, this::handleMsg);
        GlobalEventChannel.INSTANCE.subscribeAlways(FriendMessageEvent.class, this::handleMsg);
        getLogger().info("MogogoInfo加载成功！");
    }

    public void handleMsg(MessageEvent msg){
        if(msg.getMessage().toString().startsWith("#")){
            String cmd = msg.getMessage().toString().substring(1);

        }
    }
}
