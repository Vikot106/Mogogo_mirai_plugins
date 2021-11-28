package ink.moku;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.events.MessageEvent;
import net.mamoe.mirai.message.data.Image;
import net.mamoe.mirai.message.data.Message;
import net.mamoe.mirai.message.data.MessageUtils;
import net.mamoe.mirai.utils.ExternalResource;

import java.io.File;
import java.io.IOException;

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
        GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, this::handleMsg);
        GlobalEventChannel.INSTANCE.subscribeAlways(FriendMessageEvent.class, this::handleMsg);
        getLogger().info("MogogoInfo加载成功！");
    }

    public void handleMsg(MessageEvent msg) {
        if (msg.getMessage().serializeToMiraiCode().startsWith("#")) {
            String cmd = msg.getMessage().serializeToMiraiCode().substring(1);
            if (cmd.equals("状态")) {
                getLogger().info("状态显示");
                msg.getSubject().sendMessage(new Status().Status());
            }
            if (cmd.equals("功能")) {
                getLogger().info("功能显示");
                msg.getSubject().sendMessage(new Help().Help());
            }
            if (cmd.equals("新功能")) {
                getLogger().info("新功能显示");
                msg.getSubject().sendMessage(new News().News());
            }
            if (cmd.contains("说个数")) {
                try {
                    msg.getSubject().sendMessage("虽然不知道能不能帮到你，但我觉得是"
                            + new RandomNumber().RandomNumber(msg.getMessage().serializeToMiraiCode().split("最多")[1].trim()));
                } catch (Exception e) {
                    msg.getSubject().sendMessage("你要不要看看你在讲什么");
                }
            }
            if (cmd.contains("反馈")) {
                getLogger().info("新反馈信息");
                try {
                    if (new Feedback().Feedback(msg.getSender().getId() + "\t" + msg.getSender().getNick() + "\t"
                            + msg.getMessage().serializeToMiraiCode().split("反馈")[1].trim())) {
                        msg.getSubject().sendMessage("我已经偷偷告诉泯默了！");
                    } else {
                        msg.getSubject().sendMessage("好像出了什么问题 反馈失败了qwq");
                    }
                } catch (Exception e) {
                    msg.getSubject().sendMessage("你要不要看看你在讲什么");
                }
            }
            if (cmd.contains("整点")) {
                if (cmd.equals("整点猫猫")) {
                    getLogger().info("猫猫图");
                    if (sendImg(msg, new GetPic().getCat())) {
                        getLogger().info("猫猫图发送成功");
                    } else {
                        sendImg(msg, new GetPic().getException());
                    }
                }else if (cmd.equals("整点狗勾")) {
                    getLogger().info("狗狗图");
                    if (sendImg(msg, new GetPic().getDog())) {
                        getLogger().info("狗狗图发送成功");
                    } else {
                        sendImg(msg, new GetPic().getException());
                    }
                }else if (cmd.equals("整点狐狸")) {
                    getLogger().info("狐狸图");
                    if (sendImg(msg, new GetPic().getFox())) {
                        getLogger().info("狐狸图发送成功");
                    } else {
                        sendImg(msg, new GetPic().getException());
                    }
                }else if(cmd.equals("整点黄狗")){
                    if (sendImg(msg, new Moku().getPic())) {
                        getLogger().info("黄狗图发送成功");
                    } else {
                        sendImg(msg, new GetPic().getException());
                    }
                }else{
                    msg.getSubject().sendMessage("？");
                }
            }
        }
    }

    public Boolean sendImg(MessageEvent msg, File file) {
        System.out.println(file.getPath());
        ExternalResource er = ExternalResource.create(file);
        Image image = msg.getSender().uploadImage(er);
        Message message = MessageUtils.newChain();
        message = message.plus(image);
        msg.getSubject().sendMessage(message);
        try {
            er.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
