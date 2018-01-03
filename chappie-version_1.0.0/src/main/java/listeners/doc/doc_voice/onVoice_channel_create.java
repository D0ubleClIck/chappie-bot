package listeners.doc.doc_voice;

import net.dv8tion.jda.core.events.channel.voice.VoiceChannelCreateEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class onVoice_channel_create extends ListenerAdapter {
    public void onVoiceChannelCreate(VoiceChannelCreateEvent event) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        event.getChannel().getName();
        event.getGuild().getTextChannelsByName("chappie_log", true)
                .get(0).sendMessage(":new: ein neuer Voice-Channel namens **"
                +event.getChannel().getName()+ "** wurde erstellt! "+sdf.format(new Date())).queue();
    }
}
