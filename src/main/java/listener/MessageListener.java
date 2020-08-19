package listener;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        String name = event.getMember().getUser().getName();
        if (event.getAuthor().isBot()) return;
        if (message.contains("hola")) {
            event.getChannel().sendMessage("Hola " + name + "!").queue();
        }
    }


}
