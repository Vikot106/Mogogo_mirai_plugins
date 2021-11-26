package ink.moku;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.*;
import net.mamoe.mirai.message.action.Nudge;

public final class CoreMain extends JavaPlugin {
    public static final CoreMain INSTANCE = new CoreMain();

    private CoreMain() {
        super(new JvmPluginDescriptionBuilder("ink.moku.plugin", "1.0")
                .name("MogogoCore")
                .author("Vikot106")
                .build());
    }

    @Override
    public void onEnable() {
        getLogger().info("MogogoCore加载成功！");
        GlobalEventChannel.INSTANCE.subscribeAlways(NudgeEvent.class, this::handleNudge);
        GlobalEventChannel.INSTANCE.subscribeAlways(NewFriendRequestEvent.class, this::handleFR);
        GlobalEventChannel.INSTANCE.subscribeAlways(FriendAddEvent.class, this::handleFA);
        GlobalEventChannel.INSTANCE.subscribeAlways(BotInvitedJoinGroupRequestEvent.class, this::handleGR);
        GlobalEventChannel.INSTANCE.subscribeAlways(BotJoinGroupEvent.class, this::handleGA);

    }

    public void handleNudge(NudgeEvent e){
        Contact contact = e.getSubject();
        Nudge nudge = contact.getBot().nudge();
        nudge.sendTo(contact);
    }

    public void handleFR(NewFriendRequestEvent e){
        e.accept();
    }

    public void handleFA(FriendAddEvent e){
        e.getFriend().sendMessage("( •̀ ω •́ )~✧");
    }

    public void handleGR(BotInvitedJoinGroupRequestEvent e){
        e.accept();
    }

    public void handleGA(BotJoinGroupEvent e){
        e.getGroup().sendMessage("( •̀ ω •́ )~✧");
    }
}
