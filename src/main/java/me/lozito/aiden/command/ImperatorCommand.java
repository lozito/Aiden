package me.lozito.aiden.command;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ImperatorCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        Member member;
        Role role = event.getGuild().getRoleById("607690410403430407");
        if (event.getMessage().getContentRaw().contains("$imperator")) {
            if (event.getAuthor().getId().contains("256491425481359360")) {
                try {
                    member = event.getMessage().getMentionedMembers().get(0);
                    if (member.getRoles().contains(role)) {
                        event.getGuild().removeRoleFromMember(member, role).queue();
                        event.getMessage().delete().queue();
                        return;
                    }
                    event.getGuild().addRoleToMember(member, role).queue();
                    event.getMessage().delete().queue();
                    return;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Must tag an user.");
                    return;
                }
            }
            event.getChannel().sendMessage("It doesn't work with you! :).").queue();
        }
    }
}

