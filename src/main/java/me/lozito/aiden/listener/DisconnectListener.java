package me.lozito.aiden.listener;

import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DisconnectListener extends ListenerAdapter {

    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {
        String user = event.getEntity().getUser().getName();
        event.getGuild().getSystemChannel().sendMessage("Te falta calle " + user + "!").queue();
    }

}
