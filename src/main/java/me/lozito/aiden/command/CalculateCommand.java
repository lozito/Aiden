package me.lozito.aiden.command;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CalculateCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase("!calculate")) {
            int num1 = Integer.parseInt(args[2]);
            int num2 = Integer.parseInt(args[3]);
            if (args[0].equalsIgnoreCase("!calculate") && args[1].equalsIgnoreCase("add")) {
                event.getChannel().sendMessage("El resultado es: " + (num1 + num2)).queue();
            }
            if (args[0].equalsIgnoreCase("!calculate") && args[1].equalsIgnoreCase("sub")) {
                event.getChannel().sendMessage("El resultado es " + (num1 - num2)).queue();
            }
            if (args[0].equalsIgnoreCase("!calculate") && args[1].equalsIgnoreCase("mult")) {
                event.getChannel().sendMessage("El resultado es " + (num1 * num2)).queue();
            }
        }
    }
}
