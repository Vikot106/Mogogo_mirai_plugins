package ink.moku;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.*;

import java.util.Random;

public final class SayMain extends JavaPlugin {
    public static final SayMain INSTANCE = new SayMain();

    private SayMain() {
        super(new JvmPluginDescriptionBuilder("ink.moku.plugin", "1.0")
                .name("MogogoSay")
                .author("Vikot106")
                .build());
    }

    @Override
    public void onEnable() {
        GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, this::handleMsg);
        GlobalEventChannel.INSTANCE.subscribeAlways(FriendMessageEvent.class, this::handleMsg);
        getLogger().info("MogogoSay加载成功！");
    }

    //说xxx，叫xxx
    public void handleMsg(MessageEvent msg) {
        if (msg.getMessage().serializeToMiraiCode().startsWith("[mirai:at:" + msg.getBot().getId() + "]")) {
            //是否at机器人开头
            String msgContent = msg.getMessage().serializeToMiraiCode();
            if (msgContent.contains("叫")) {
                String[] parts = msgContent.split("叫", 2);
                msg.getSubject().sendMessage(parts[1]);
            } else if (msgContent.contains("说")) {
                String[] parts = msgContent.split("说", 2);
                msg.getSubject().sendMessage(reverse(parts[1], '我', '你'));
            } else {
                String reply = "?";
                Random r = new Random();
                int i = r.nextInt(6);
                switch (i) {
                    case 0:
                        reply = "？";
                        break;
                    case 1:
                        reply = "干啥玩意";
                        break;
                    case 2:
                        reply = "喵喵喵？";
                        break;
                    case 3:
                        reply = "啥？";
                        break;
                    case 4:
                        reply = "汪";
                        break;
                    case 5:
                        reply = "owo";
                        break;
                    case 6:
                        reply = "uwu";
                        break;
                    default:
                        break;
                }
                msg.getSubject().sendMessage(reply);
            }
        }
    }

    private String reverse(String str, char a, char b) {
        char list[] = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == a) {
                list[i] = b;
                continue;
            }
            if (list[i] == b)
                list[i] = a;
        }
        for (int i = 0; i < list.length; i++) {
            sb.append(list[i]);
        }
        return sb.toString();
    }
}
