package me.lozito.aiden.listener;

import net.dv8tion.jda.api.events.guild.GuildBanEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BanListener extends ListenerAdapter {

    public void onGuildBan(GuildBanEvent event) throws NullPointerException {
        String user = event.getUser().getName();
        event.getGuild().getSystemChannel().sendMessage("A casa puta " + user).queue();
    }
}
