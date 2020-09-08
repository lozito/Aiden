package me.lozito.aiden.listener;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent event) throws NullPointerException {
        System.out.println("Aiden - JDA is ready! Bot should be online.");
    }
}
