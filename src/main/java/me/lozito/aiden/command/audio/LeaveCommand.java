package me.lozito.aiden.command.audio;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class LeaveCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        Member member = event.getGuild().getMember(event.getMember().getUser());
        AudioManager manager = event.getGuild().getAudioManager();
        VoiceChannel voiceChannel = manager.getConnectedChannel();

        if (event.getMessage().getContentRaw().contains("$leave")) {
            if (!manager.isConnected()) {
                event.getChannel().sendMessage("No estoy en un canal taradito").queue();
            }
            if (!voiceChannel.getMembers().contains(member)) {
                event.getChannel().sendMessage("Tenes que estar en el mismo canal que yo").queue();
                return;
            }
            manager.closeAudioConnection();
        }
    }
}
