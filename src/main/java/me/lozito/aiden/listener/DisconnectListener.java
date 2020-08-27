package me.lozito.aiden.listener;

import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DisconnectListener extends ListenerAdapter {

    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {
        String user = event.getEntity().getUser().getName();
        event.getGuild().getSystemChannel().sendMessage("Te falta calle " + user + "!").queue();

        if (user.contains("Esnowpa")) {
            event.getGuild().getSystemChannel().sendMessage("I have kicked Esnowpa because he is swearing to NEP's members.").queue();
            event.getEntity().kick("[AIDEN] This server has been hacked.").queue();
        }
    }
}
