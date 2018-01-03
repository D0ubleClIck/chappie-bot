package listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class onReady extends ListenerAdapter {

    public void onReady(ReadyEvent event)
    {
        int delay = 1000*60*5;
        System.out.println("\nbot runs on following servers:\n");
        for(Guild server: event.getJDA().getGuilds())
        {
            System.out.print(server);
            System.out.println("    [INFO] chappie says hello");
            Message message = server.getTextChannels().get(0).sendMessage(new EmbedBuilder()
                    .setColor(Color.GREEN)
                    .setDescription(":wave: chappie ist wieder online! :wave:")
                    .build()).complete();

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    message.delete().queue();
                }
            },delay);
        }
    }
}
