package commands.get;
import commands.command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class cmd_get implements command {
    public static int whichArg;
    SimpleDateFormat sdf;
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event)  {

        sdf = new SimpleDateFormat("HH:mm:ss");

        if (args.length < 1) {
            event.getTextChannel().sendMessage(new EmbedBuilder().setColor(ColorUIResource.RED).setDescription(help()).build()).queue();
        }else {
            switch (args[0]) {
                case "info":
                    event.getTextChannel().sendMessage(new EmbedBuilder().setColor(Color.blue).setDescription(
                            ":information_source:**INFO**\n\n :one: Ich bin ein (chat)Verwaltungsbot\n\n" +
                                    ":two: Mit dem command **get inst** bekommst du eine Liste aller Befehle die ich erkennen kann.\n\n" +
                                    " :three: mit dem befehl **get abilities** erfährst du ganz genau, zu was ich in der Lage bin!\n\n" +
                                    " :four: ich benötige den Text-Channel **chappie_log**, erstelle sie falls du es noch nicht gemacht hast. " +
                                    "Ich benötige ihn, um dort meine Beobachtungen zu dokumentieren!"
                    ).build()).queue();
                    whichArg = 1;
                    break;
                case "inst":
                    Message message = new MessageBuilder().append(":ledger:**Command Liste**:ledger:").build();
                    event.getTextChannel().sendFile(new File("/home/pi/DCB/chappie/res/inst/instruction.pdf"), message).queue();
                    whichArg = 2;
                    break;
                default:
                    event.getTextChannel().sendMessage(new EmbedBuilder().setColor(Color.RED).setDescription(":warning:**Argument nicht erkannt**").build()).queue();
                    whichArg = 3;
                    break;
            }
        }

        }
    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        switch (whichArg){
            case 1:
                System.out.println(event.getGuild()+ " [INFO] command <get info> wurde erfolgreich ausgeführt!" +
                        " von user ["+event.getAuthor().getName()+"][Uhrzeit"+sdf.format(new Date()));
                break;
            case 2:
                System.out.println(event.getGuild()+ " [INFO] command <get inst> wurde erfolgreich ausgeführt!" +
                        " von user ["+event.getAuthor().getName()+"][Uhrzeit"+sdf.format(new Date()));
                break;
            case 3:
                System.out.println("error");
                break;
        }

    }

    @Override
    public String help() {
        return "**:warning:der befehl -get- benötigt ein argument**\n\n -get <argument>";
    }
}
