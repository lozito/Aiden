package me.lozito.aiden.command;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PrisionCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        Role role = event.getGuild().getRoleById("772612677545492540");
        Member member;

        if (event.getMessage().getContentRaw().contains("$prision")) {
            if (event.getAuthor().getId().contains("256491425481359360")) {
                try {
                    event.getMessage().delete().queue();
                    member = event.getMessage().getMentionedMembers().get(0);
                    member.getGuild().addRoleToMember(member, role).queue();
                    member.getGuild().deafen(member, true).queue();
                    member.getGuild().kickVoiceMember(member).queue();
                    return;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Must tag an user.");
                    return;
                }
            }
        }
    }
}
