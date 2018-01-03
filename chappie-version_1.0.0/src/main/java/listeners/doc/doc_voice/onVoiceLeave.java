package listeners.doc.doc_voice;

import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class onVoiceLeave extends ListenerAdapter {
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        event.getGuild().getTextChannelsByName("chappie_log", true).get(0).
                sendMessage(":mute: Benutzer **"+event.getVoiceState().getMember().getUser().getName() +
                        "** verlässt den voicechannel **"+event.getChannelLeft().getName()+"** um **["+sdf.format(new Date())+"]**").queue();

        System.out.println("Benutzer " + event.getVoiceState().getMember().getUser().getName() + "verlässt den voicechannel" + event.getChannelLeft()+
                "** um **"+"["+sdf.format(new Date())+"]**");

    }
}
