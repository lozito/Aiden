package me.lozito.aiden.listener;

import net.dv8tion.jda.api.events.guild.voice.GuildVoiceSelfMuteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class OnlineListener extends ListenerAdapter {

    public void onGuildVoiceSelfMute(GuildVoiceSelfMuteEvent event) {
        event.getGuild().getMember(event.getMember().getUser()).deafen(true).queue();
    }
}
