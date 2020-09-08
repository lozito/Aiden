package me.lozito.aiden.listener;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TextToSpeechListener extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) throws NullPointerException {
        if (event.getMessage().isTTS()) {
            event.getMessage().delete().queue();
            event.getChannel().sendMessage("El último mensaje fue de tipo TTS, pero me encargué de borrarlo.").queue();
        }
    }
}
