package me.lozito.aiden.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CalculateCommand extends ListenerAdapter {

    Map<Long, Long> prompts = new HashMap<>();

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$calculate")) {
            if (!event.getAuthor().getId().contains("256491425481359360")) {
                event.getMessage().delete().queue();
                event.getChannel().sendMessage("It doesn't work with you! :).").queue();
                return;
            }
            EmbedBuilder builder = new EmbedBuilder();
            builder.setAuthor("Aiden's Calculator", null, "https://vignette.wikia.nocookie.net/beyondtwosouls/images/4/41/Aiden.png/revision/latest/top-crop/width/360/height/450?cb=20140831005218");
            builder.setColor(Color.PINK);
            builder.addField("¿Qué operación querés realizar?", "WORK IN PROGRESS, USE FOR TESTING ONLY", false);
            builder.setFooter("made by juvn with ♥");
            Message message = event.getChannel().sendMessage(builder.build()).complete();
            message.addReaction("U+2795").queue();
            message.addReaction("U+2796").queue();
            message.addReaction("U+2716").queue();
            message.addReaction("U+2797").queue();
        }
    }

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
        String reaction = event.getReactionEmote().getName();
        switch (reaction) {
            case "➕": {
                prompts.put(event.getUser().getIdLong(), System.currentTimeMillis());
                event.getChannel().sendMessage("A").queue();
            }
            case "➖": {
                event.getChannel().sendMessage("B").queue();
            }
            case "✖": {
                event.getChannel().sendMessage("C").queue();
            }
            case "➗": {
                event.getChannel().sendMessage("D").queue();
            }
        }
    }
}