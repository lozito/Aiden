package me.lozito.aiden.listener;

import net.dv8tion.jda.api.events.guild.update.GuildUpdateNameEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        String name = event.getMember().getUser().getName();
        if (event.getAuthor().isBot()) return;
        if (message.toLowerCase().contains("hola")) {
            event.getChannel().sendMessage("Hola " + name + "!").queue();
        }
    }

    public void onGuildUpdateName(GuildUpdateNameEvent event, GuildMessageReceivedEvent message) {
        String oldName = event.getOldName();
        String newName = event.getNewName();


        message.getChannel().sendMessage("The server name was" + oldName + ", now it's" + newName).queue();
    }
}
