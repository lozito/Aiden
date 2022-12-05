package me.lozito.aiden.listener;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Random;

public class MessageListener extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) throws NullPointerException {
        if (event.getAuthor().isBot()) return;

        Random random = new Random();
        int percentage = random.nextInt((100 - 1)) + 10;

        if (event.getMessage().getAuthor().getId().contains("371773780072202241")) {
            event.getMessage().delete().queue();
        }

        String[] message = event.getMessage().getContentRaw().split(" ");
        if (event.getMessage().getContentRaw().equalsIgnoreCase("react me")) {
            event.getMessage().addReaction("\uD83E\uDD2A").queue();
        }
        if (message[0].equalsIgnoreCase("$love")) {
            if (message[1] == null || message[2] == null)
                event.getChannel().sendMessage("Tenes que colocar como maximo 2 personas!").queue();
            EmbedBuilder builder = new EmbedBuilder();
            builder.setColor(Color.RED);
            builder.setAuthor("Aiden's Love Calculator", null, "https://vignette.wikia.nocookie.net/beyondtwosouls/images/4/41/Aiden.png/revision/latest/top-crop/width/360/height/450?cb=20140831005218");
            builder.addField("Dejame pensar...", "Hay un " + percentage + "% de amor entre " + message[1] + " y " + message[2], false);
            builder.setFooter("made by juvn with ♥");
            event.getChannel().sendMessage(builder.build()).complete();
        }
        if (event.getMessage().getContentRaw().contains("dice aiden") && event.getMessage().getAuthor().getName().equalsIgnoreCase("la concha de tu prima")) {
            String[] messages = {"soy admin y confirmo lo de arriba", "confirmo", "desconfirmo", "le pifiaste mi rey"};
            int randomId = random.nextInt(messages.length);
            event.getChannel().sendMessage(messages[randomId]).queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$xd")) {
            event.getMessage().delete().queue();
            event.getChannel().sendMessage("<@176425702097289226> <@176425702097289226>").queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$online") && event.getAuthor().getName().contains("la concha de tu prima")) {
            System.out.println(event.getGuild().getMembers());
        }
    }

    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        String[] messages = {"just testing", "2nd message", "seen 13:37", "el tiempo nada en las aguas del cosmo", "supuestamente estoy vivo, pero solo soy un bot"};
        Random random = new Random();
        int randomId = random.nextInt(messages.length);

        if (event.getMessage().getContentRaw().contains("$user")) return;
        if (event.getAuthor().isBot()) return;
        event.getAuthor().openPrivateChannel().queue();
        event.getChannel().sendMessage(messages[randomId]).queue();
    }
}