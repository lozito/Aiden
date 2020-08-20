package me.lozito.aiden.listener;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TextToSpeechListener extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getMessage().isTTS()) {
            event.getChannel().sendMessage("El último mensaje fue de tipo TTS.").queue();
        }
    }
}
