package me.lozito.aiden.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.format.DateTimeFormatter;

public class UserInfoCommand extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        Member member;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (event.getMessage().getContentRaw().contains("$user")) {
            try {
                member = event.getMessage().getMentionedMembers().get(0);
                EmbedBuilder builder = new EmbedBuilder()
                        .setColor(Color.WHITE)
                        .setThumbnail(member.getUser().getAvatarUrl())
                        .setAuthor("Information on " + member.getUser().getName(), null, "https://vignette.wikia.nocookie.net/beyondtwosouls/images/4/41/Aiden.png/revision/latest/top-crop/width/360/height/450?cb=20140831005218")
                        .addField("Created on:", member.getTimeCreated().format(dtf), true)
                        .addField("Joined:", member.getTimeJoined().format(dtf), true)
                        .addField("Game:", member.getActivities().toString(), true)
                        .addField("Status:", member.getOnlineStatus().name(), true);
                event.getChannel().sendMessage(builder.build()).complete();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("An exception ocurred!");
                event.getChannel().sendMessage("Tenes que proporcionar el user como mención").queue();
            }
        }
    }
}
