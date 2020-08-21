package me.lozito.aiden.listener;

import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReactionListener extends ListenerAdapter {

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
        /*String user = event.getUser().getName();
        if (!event.getUser().isBot()) {
            event.getChannel().sendMessage(user).queue();
        }*/
        if (!event.getUser().isBot()) {
            event.getReaction().removeReaction().queue();
            event.getGuild().getMember(event.getUser()).deafen(true).queue();
        }
    }
}
