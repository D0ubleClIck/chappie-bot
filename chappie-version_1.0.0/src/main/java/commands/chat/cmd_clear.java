package commands.chat;
import commands.command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import utils.STATICS;

import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class cmd_clear implements command {

    private int convertToInteger(String string){
        try{ 
            return Integer.parseInt(string);
        }catch (Exception exc){
            System.out.println("missing argument");
            return 0;
        }

    }
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {
        if (STATICS.ignorecmd==true) {
            return;
        } else {
            if (args.length < 1) {
                event.getTextChannel().sendMessage(
                        new EmbedBuilder()
                                .setColor(ColorUIResource.RED)
                                .setDescription(help()).build())
                        .queue();
            } else {
                int numb = convertToInteger(args[0]); 
                if (numb > 1 && numb <= 100) { 
                    try {
                        MessageHistory history = new MessageHistory(event.getTextChannel());
                        List<Message> msg;

                        event.getMessage().delete().queue();
                        msg = history.retrievePast(numb).complete();
                        event.getTextChannel().deleteMessages(msg).queue();

                        Message message = event.getTextChannel().sendMessage(new EmbedBuilder()
                                .setColor(Color.GREEN)
                                .setDescription(":recycle:**Es wurden " + args[0] + " Nachrichten gelöscht!**:recycle:")
                                .build()).complete();

                        new Timer().schedule(new TimerTask() { //nach 3 sekunden wird der Embed gelöscht
                            @Override
                            public void run() {
                                message.delete().queue();
                            }
                        }, 3000);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    event.getTextChannel().sendMessage(new EmbedBuilder()
                            .setColor(Color.RED)
                            .setDescription(":warning: **Es können nur mindestens 2 und maximal 100 nachrichten gelöscht werden!**").build())
                            .queue();
                }
            }

        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        System.out.println("[INFO] command <del> executed");
    }
    @Override
    public String help() {
        return ":warning:der befehl **-cl** benötigt ein argument\n\n -cl <anzahl>";
    }
}
