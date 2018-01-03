package commands.interact;

import commands.command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class cmd_ping implements command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        event.getTextChannel().sendMessage("Pong!").queue();

        }


    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.print(event.getGuild()+"[INFO] command <ping> wurde erfolgreich ausgeführt! von user ["+event.getAuthor().getName()+"]");
        System.out.println("[Uhrzeit : "+sdf.format(new Date())+"]");

    }

    @Override
    public String help() {
        return null;
    }
}
