package me.lozito.aiden.command;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class RandomCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        Random random = new Random();
        int percentage = random.nextInt((2 - 1)) + 10;

        if(event.getMessage().getContentRaw().contains("$random")) {
            event.getMessage().getChannel().sendMessage("Random: " + percentage).queue();
        }
    }
}
