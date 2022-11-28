package de.muv1n.bot.translation;

import net.dv8tion.jda.api.entities.Guild;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CommonTranslation extends Translation{
    public CommonTranslation() {
        super("common", CommonTranslation.class.getClassLoader());
    }

    public String get(String key, Guild guild, Object... format) {
        return super.get(key, guild.getLocale(), format);
    }
    @NotNull
    public String get(String key, Object... format) {
        return super.get(key, format);
    }
}
