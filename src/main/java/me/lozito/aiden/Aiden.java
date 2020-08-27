package me.lozito.aiden;

import me.lozito.aiden.command.CalculateCommand;
import me.lozito.aiden.listener.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Aiden {

    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA aiden = JDABuilder.createDefault("NzQ1NjQzMDM0NDE0MTUzODkz.Xz0wMA.syPSPNr2Cc83Us_il-o-Yh8ZxQY").build();
        aiden.awaitReady();
        aiden.getPresence().setActivity(Activity.streaming("sentimientos", "https://twitch.tv/EasterEggs"));

        aiden.addEventListener(new CalculateCommand());
        aiden.addEventListener(new MuteListener());
        aiden.addEventListener(new BanListener());
        aiden.addEventListener(new ReactionListener());
        aiden.addEventListener(new ChannelListener());
        aiden.addEventListener(new JoinChannelListener());
        aiden.addEventListener(new DisconnectListener());
        aiden.addEventListener(new MessageListener());
        aiden.addEventListener(new ReadyListener());
        aiden.addEventListener(new TextToSpeechListener());
    }
}
