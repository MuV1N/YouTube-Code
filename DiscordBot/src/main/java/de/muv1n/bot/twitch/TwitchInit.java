package de.muv1n.bot.twitch;

import com.github.philippheuer.events4j.core.EventManager;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.TwitchClientHelper;
import com.github.twitch4j.events.ChannelGoLiveEvent;
import de.muv1n.bot.BotMain;
import de.muv1n.bot.Main;
import de.muv1n.bot.translation.CommonTranslation;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import java.awt.*;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class TwitchInit {

    private final TwitchClientBuilder builder;
    private final TwitchClient client;
    private final TwitchClientHelper helper;
    private final EventManager manager;

    private static TwitchInit instance;
    private static int i = 0;

    public TwitchInit(BotMain main) {
        Dotenv dotenv = Main.getDotenv();

        this.builder = TwitchClientBuilder.builder();
        this.client = this.builder.withClientId(dotenv.get("CLIENTID")).withClientSecret(dotenv.get("CLIENTSECRET")).withEnableHelix(true).build();
        this.helper = this.client.getClientHelper();
        this.manager = this.client.getEventManager();

        if (helper.enableStreamEventListener("muv1n") == null) System.out.println("Stream Event Listener didn't load!");
        CommonTranslation c = main.getCommon();

        manager.onEvent(ChannelGoLiveEvent.class, event -> {
            TextChannel channel = main.getBot().getTextChannelById(993819350471561277L);
            if (channel == null) return;
            channel.sendMessageEmbeds(new EmbedBuilder()
                    .setTitle(c.get("social.embed.twitch.title"))
                    .setDescription(c.get("social.embed.twitch.description", event.getStream().getTitle(), event.getStream().getGameName()))
                    .setColor(new Color(0,0,0))
                    .build()).queue();
            channel.sendMessage(Objects.requireNonNull(Objects.requireNonNull(main.getBot().getGuildById(993815287784804373L)).getRoleById(995776478845350009L)).getAsMention()).queue(q ->{
                q.delete().queueAfter(1000, TimeUnit.MILLISECONDS);
            });
        });

    }

    public TwitchInit getInstance() {
        return instance;
    }
    public EventManager getManager() {
        return manager;
    }
    public TwitchClientBuilder getBuilder() {
        return builder;
    }
    public TwitchClient getClient() {
        return client;
    }
    public TwitchClientHelper getHelper() {
        return helper;
    }
  }
