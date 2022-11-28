package de.muv1n.bot;

import de.muv1n.bot.translation.CommonTranslation;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class BotMain {
    private final JDA bot;
    private final CommonTranslation common;

    public BotMain(String key) throws InterruptedException {
        JDA bot;
        JDABuilder builder = JDABuilder.createDefault(key);

        this.common = new CommonTranslation();

        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        builder.setActivity(Activity.streaming(common.get("activity", "Entwicklung!"), "https://twitch.tv/muv1n"));

        bot = builder.build();
        bot.awaitReady();
        this.bot = bot;


    }

    public JDA getBot() {
        return bot;
    }
}
