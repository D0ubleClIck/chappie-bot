package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import sun.security.rsa.RSASignature;

import java.io.IOException;
import java.text.ParseException;

public interface command {
    boolean called(String[] args, MessageReceivedEvent event);
    void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException;
    void executed(boolean success, MessageReceivedEvent event);
    String help();
}
