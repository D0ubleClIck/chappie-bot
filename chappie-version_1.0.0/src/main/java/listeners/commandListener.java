package listeners;
import core.*;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import utils.SECRETS;

import java.io.IOException;
import java.text.ParseException;

public class commandListener extends ListenerAdapter{

    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getContent().startsWith(SECRETS.PREFIX)
                && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId())
        {
            try {
                commandHandler.HandleCommand(commandHandler.parse.parser(event.getMessage().getContent(), event));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }
}
