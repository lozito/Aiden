package me.lozito.aiden.listener;

import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ChannelListener extends ListenerAdapter {

    public void onGuildVoiceMove(GuildVoiceMoveEvent event) throws NullPointerException {
        String channel = event.getChannelJoined().getId();
        String user = event.getMember().getUser().getName();
        if (channel.contains("747589594911998085")) {
            if (user.equalsIgnoreCase("Aiden")) return;
            if (user.contains("la concha de tu prima")) return;
            event.getMember().ban(1).queue();
            event.getGuild().getSystemChannel().sendMessage(user + " fue baneado porque se cayó a la papelera de reciclaje!").queue();
        }
    }
}

