package me.lozito.aiden.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class CalculateCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (event.getMessage().getContentRaw().equalsIgnoreCase("!calculate")) {
            EmbedBuilder builder = new EmbedBuilder();
            builder.setAuthor("Aiden's Calculator", null, "https://vignette.wikia.nocookie.net/beyondtwosouls/images/4/41/Aiden.png/revision/latest/top-crop/width/360/height/450?cb=20140831005218");
            builder.setColor(Color.PINK);
            builder.addField("¿Que operación querés realizar?", "WORK IN PROGRESS, USE FOR TESTING ONLY", false);
            builder.setFooter("made by juvn with ♥");
            Message message = event.getChannel().sendMessage(builder.build()).complete();
            message.addReaction("➕").queue();
            message.addReaction("➖").queue();
            message.addReaction("✖").queue();
            message.addReaction("➗").queue();

            String reaction = event.getMessage().getReactionByUnicode("").getEmoji();

            /*switch (reaction) {
                case "➕": {
                    event.getChannel().sendMessage("Escribe 2 números.").queue();
                    int num1 = Integer.parseInt(args[1]);
                    int num2 = Integer.parseInt(args[2]);
                    event.getChannel().sendMessage("El resultado es " + (num1 + num2)).queue();
                }
            }*/
        }
    }
}