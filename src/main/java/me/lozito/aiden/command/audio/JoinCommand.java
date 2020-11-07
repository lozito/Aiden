package me.lozito.aiden.command.audio;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class JoinCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) throws NullPointerException {
        Member member = event.getGuild().getMember(event.getMember().getUser());
        VoiceChannel channel;
        AudioManager manager = event.getGuild().getAudioManager();

        if (event.getMessage().getContentRaw().contains("$aiden")) {
            if (manager.isConnected()) {
                event.getChannel().sendMessage("Ya estoy en el canal idiota").queue();
                return;
            }
            if (event.getAuthor().isBot()) return;
            try {
                channel = member.getVoiceState().getChannel();
                manager.openAudioConnection(channel);
                event.getChannel().sendMessage("Conectandome a `\uD83D\uDD0A " + channel.getName() + "`").queue();
            } catch (NullPointerException ex) {
                event.getChannel().sendMessage("No estás en ningún canal").queue();
            }
        }
        if (event.getMessage().getContentRaw().contains("$say")) {
            event.getChannel().sendMessage("u have to tell <@256491425481359360> to do it. sorry :(").queue();
        }
    }
}
