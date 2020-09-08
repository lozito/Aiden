package me.lozito.aiden.listener;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class JoinChannelListener extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) throws NullPointerException {
        Member member = event.getGuild().getMember(event.getMember().getUser());
        VoiceChannel channel = member.getVoiceState().getChannel();
        AudioManager manager = event.getGuild().getAudioManager();

        if (event.getMessage().getContentRaw().contains("!aiden")) {
            if (!event.getAuthor().isBot()) {
                manager.openAudioConnection(channel);
            }
        }
    }
}
