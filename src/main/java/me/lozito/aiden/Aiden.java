package me.lozito.aiden;

import me.lozito.aiden.command.*;
import me.lozito.aiden.command.audio.JoinCommand;
import me.lozito.aiden.command.audio.LeaveCommand;
import me.lozito.aiden.command.audio.PlayCommand;
import me.lozito.aiden.listener.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;
import java.util.Random;

public class Aiden {

    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA aiden = JDABuilder.createDefault("NzQ1NjQzMDM0NDE0MTUzODkz.Xz0wMA.syPSPNr2Cc83Us_il-o-Yh8ZxQY")
                //disabling cache to avoid nullpointerexceptions.
                .disableCache(EnumSet.of(
                        CacheFlag.VOICE_STATE,
                        CacheFlag.CLIENT_STATUS,
                        CacheFlag.EMOTE,
                        CacheFlag.ACTIVITY
                ))
                .enableCache(CacheFlag.VOICE_STATE)
                .build();
        //awaiting until discord confirms it's online.
        aiden.awaitReady();
        aiden.getPresence().setActivity(Activity.streaming("sentimientos", "https://twitch.tv/EasterEggs"));

        //commands
        aiden.addEventListener(new UserInfoCommand());
        aiden.addEventListener(new LeaveCommand());
        aiden.addEventListener(new PlayCommand());
        aiden.addEventListener(new CalculateCommand());
        aiden.addEventListener(new ImperatorCommand());
        aiden.addEventListener(new PrisionCommand());
        aiden.addEventListener(new RandomCommand());
        //listeners
        aiden.addEventListener(new MuteListener());
        aiden.addEventListener(new BanListener());
        aiden.addEventListener(new ReactionListener());
        aiden.addEventListener(new JoinCommand());
        aiden.addEventListener(new DisconnectListener());
        aiden.addEventListener(new MessageListener());
        aiden.addEventListener(new ReadyListener());
        aiden.addEventListener(new TextToSpeechListener());
    }
}
