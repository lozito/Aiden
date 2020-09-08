package me.lozito.aiden.listener;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceSelfMuteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MuteListener extends ListenerAdapter {

    public void onGuildVoiceSelfMute(GuildVoiceSelfMuteEvent event) throws NullPointerException {
        User user = event.getMember().getUser();
        Role role = event.getGuild().getRoleById("746916830584635434");
        if (event.getGuild().getMember(user).getRoles().contains(role)) return;
        event.getGuild().getMember(user).deafen(true).queue();
    }
}
