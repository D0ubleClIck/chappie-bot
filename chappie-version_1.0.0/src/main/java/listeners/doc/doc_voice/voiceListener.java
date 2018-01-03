package listeners.doc.doc_voice;

import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;


public class voiceListener extends ListenerAdapter {

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        event.getGuild().getTextChannelsByName("chappie_log",true).get(0).
                sendMessage(":loud_sound: Benutzer **" + event.getVoiceState().getMember().getUser().getName()
                        + "** betritt den voicechannel **" + event.getChannelJoined().getName()+"** um **["+sdf.format(new Date())+"]**").queue();

        System.out.println("Benutzer " + event.getVoiceState().getMember().getUser().getName() + "betritt den voicechannel" + event.getChannelJoined()+
                "** um **"+"["+sdf.format(new Date())+"]**");
    }

}
