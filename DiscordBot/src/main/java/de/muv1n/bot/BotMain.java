package de.muv1n.bot;

import de.muv1n.bot.translation.CommonTranslation;
import de.muv1n.bot.twitch.TwitchInit;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BotMain {
    private final JDA bot;
    private final CommonTranslation common;

    public BotMain(String key) throws InterruptedException, IOException {
        JDA bot;
        JDABuilder builder = JDABuilder.createDefault(key);

        this.common = new CommonTranslation();

        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        builder.setActivity(Activity.streaming(common.get("activity", "Entwicklung!"), "https://twitch.tv/muv1n"));

        bot = builder.build();
        bot.awaitReady();
        this.bot = bot;
        bot.getGuildById(993815287784804373L).getTextChannelById(1047939728659447830L).sendMessage("BOT Online").queue();

        new TwitchInit(this);
        stop(builder);

    }

    public JDA getBot() {
        return bot;
    }

    public CommonTranslation getCommon() {
        return common;
    }

    private void stop(JDABuilder builder) throws IOException {

        while (true){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            if (reader.readLine().equals("stop")){
                bot.getGuildById(993815287784804373L).getTextChannelById(1047939728659447830L).sendMessage("BOT Offline").queue();
                reader.close();
                builder.setStatus(OnlineStatus.OFFLINE);
                bot.shutdownNow();
                System.exit(0);
            }
        }

    }
}
