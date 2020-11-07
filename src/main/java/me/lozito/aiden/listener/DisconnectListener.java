package me.lozito.aiden.listener;

import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DisconnectListener extends ListenerAdapter {

    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) throws NullPointerException {
        String user = event.getEntity().getUser().getName();
        if (user.contains("Aiden")) {
            event.getGuild().getSystemChannel().sendMessage("Me falta calle").queue();
            return;
        }
        event.getGuild().getSystemChannel().sendMessage("Te falta calle " + user + "!").queue();
    }
}
