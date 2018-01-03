package listeners.doc.doc_voice;

import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.channel.voice.VoiceChannelDeleteEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;


public class onVoice_channel_del extends ListenerAdapter {
    public void onVoiceChannelDelete(VoiceChannelDeleteEvent event) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        event.getGuild().getTextChannelsByName("chappie_log", true)
                .get(0).sendMessage(":x: Der Voice-Chat **"+event.getChannel().getName()+"** wurde entfernt. "+sdf.format(new Date())).queue();
    }
}
