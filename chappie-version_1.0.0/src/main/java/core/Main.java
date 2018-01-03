package core;

import commands.chat.cmd_caps;
import commands.chat.cmd_clear;
import commands.chat.cmd_gif;
import commands.chat.cmd_nudge;
import commands.get.cmd_get;
import commands.interact.cmd_ping;
import listeners.commandListener;
import listeners.doc.doc_voice.onVoiceLeave;
import listeners.doc.doc_voice.onVoice_channel_create;
import listeners.doc.doc_voice.onVoice_channel_del;
import listeners.doc.doc_voice.voiceListener;
import listeners.onReady;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import utils.SECRETS;

import javax.security.auth.login.LoginException;

public class Main {
   public static JDABuilder bot_create;
    public static void main(String args[])
    {
        bot_create = new JDABuilder(AccountType.BOT);
        bot_create.setToken(SECRETS.TOKEN);
        bot_create.setAutoReconnect(true);
        bot_create.setStatus(OnlineStatus.ONLINE);
        bot_create.setGame(Game.playing("chat-center"));

        addListeners();
        addCommands();

        try{
            JDA jda = bot_create.buildBlocking();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RateLimitedException e) {
            e.printStackTrace();
        } catch (LoginException e) {
            e.printStackTrace();
        }

    }
    public static void addListeners() {
        bot_create.addEventListener(new onReady());
        bot_create.addEventListener(new commandListener());
       // bot_create.addEventListener(new onPrivateMSG());
        //voice log
        bot_create.addEventListener(new voiceListener());
        bot_create.addEventListener(new onVoiceLeave());
        bot_create.addEventListener(new onVoice_channel_del());
        bot_create.addEventListener(new onVoice_channel_create());

    }
    public static void addCommands(){
        commandHandler.commands.put("ping", new cmd_ping());
        commandHandler.commands.put("get", new cmd_get());
        commandHandler.commands.put("stups", new cmd_nudge());
        commandHandler.commands.put("cl", new cmd_clear());
        commandHandler.commands.put("gif", new cmd_gif());




    }
}
