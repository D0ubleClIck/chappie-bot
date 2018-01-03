package commands.chat;
import commands.command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class cmd_gif implements command{
    File datapath;
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {
        datapath = new File("src\\main\\java\\commands\\chat\\GIF\\");

        Message message = new MessageBuilder().append("here a gif").build();
        if (args.length < 1) {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setColor(Color.RED)
                    .setDescription(help()).build()).queue();
        } else {

            switch (args[0]) {
                case "bird":
                    datapath = new File("your datapath");
                    event.getTextChannel().sendFile(datapath,message).queue();
                    break;
                case "birthday":
                    datapath = new File("your datapath");
                    event.getTextChannel().sendFile(datapath,message).queue();
                    break;
                case "dug":
                    datapath = new File("your datapath");
                    event.getTextChannel().sendFile(datapath,message).queue();
                    break;
                case "fox":
                    datapath = new File("your datapath");
                    event.getTextChannel().sendFile(datapath,message).queue();
                    break;
                case "hide":
                    datapath = new File("your datapath");
                    event.getTextChannel().sendFile(datapath,message).queue();
                    break;
                case "octopus":
                    datapath = new File("your datapath");
                    event.getTextChannel().sendFile(datapath,message).queue();
                    break;
                case "pizza_man":
                    datapath = new File("your datapath");
                    event.getTextChannel().sendFile(datapath,message).queue();
                    break;
                case "facepalm1":
                    datapath = new File("your datapath");
                    event.getTextChannel().sendFile(datapath,message).queue();
                    break;
                case "facepalm2":
                    datapath = new File("your datapath");
                    event.getTextChannel().sendFile(datapath,message).queue();
                    break;
                case "facepalm3":
                    datapath = new File("your datapath");
                    event.getTextChannel().sendFile(datapath,message).queue();
                    break;
                    default:
                        event.getTextChannel().sendMessage(new EmbedBuilder().setColor(Color.RED).setDescription(":warning: **Falsches argument!**").build()).queue();
                        break;

            }
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return ":warning: **Der Command -gif benötigt ein Argument**\n\n-gif <gifname>";
    }
}
