package me.lozito.aiden.listener;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReactionListener extends ListenerAdapter {

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
        if (!event.getUser().isBot()) {
            event.getReaction().removeReaction(event.getUser()).queue();
            Role role = event.getGuild().getRoleById("746916830584635434");
            if (event.getGuild().getMember(event.getUser()).getRoles().contains(role)) return;
            event.getGuild().getMember(event.getUser()).deafen(true).queue();
            event.getGuild().getSystemChannel().sendMessage("que reaccionas gordo tarado").queue();
        }
    }
}
