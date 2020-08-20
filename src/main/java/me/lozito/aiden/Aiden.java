package me.lozito.aiden;

import me.lozito.aiden.listener.MessageListener;
import me.lozito.aiden.listener.ReadyListener;
import me.lozito.aiden.listener.TextToSpeechListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Aiden {

    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA aiden = JDABuilder.createDefault("NzQ1NjQzMDM0NDE0MTUzODkz.Xz0wMA.syPSPNr2Cc83Us_il-o-Yh8ZxQY").build();
        aiden.awaitReady();
        aiden.getPresence().setActivity(Activity.streaming("sentimientos", "https://twitch.tv/EasterEggs"));

        aiden.addEventListener(new MessageListener());
        aiden.addEventListener(new ReadyListener());
        aiden.addEventListener(new TextToSpeechListener());
    }
}
