import listener.MessageListener;
import listener.OnlineListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;

import javax.security.auth.login.LoginException;

public class Aiden {

    public static void main(String[] args) throws LoginException, InterruptedException {

        JDA aiden = JDABuilder.createDefault("NzQ1NjQzMDM0NDE0MTUzODkz.Xz0wMA.syPSPNr2Cc83Us_il-o-Yh8ZxQY").build();
        aiden.awaitReady();
        aiden.addEventListener(new MessageListener());
        aiden.addEventListener(new OnlineListener());
        aiden.getPresence().setActivity(Activity.streaming("sentimientos", "https://twitch.tv/EasterEggs"));
    }

    public void onReady(GenericEvent event) {
        if (event instanceof ReadyEvent) {
            System.out.println("API is ready!");
        }
    }

}
