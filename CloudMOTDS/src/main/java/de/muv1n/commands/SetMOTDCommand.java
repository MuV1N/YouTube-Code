package de.muv1n.commands;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.ext.syncproxy.configuration.SyncProxyConfiguration;
import de.dytanic.cloudnet.ext.syncproxy.configuration.SyncProxyMotd;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class SetMOTDCommand extends Command {

    public SetMOTDCommand() {
        super("motd", "owner.manage", "m", "m2");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 3) sender.sendMessage(new TextComponent("§7Usage: §b</motd set h/f>"));
        if (!args[1].equals("set")) sender.sendMessage(new TextComponent("§7Ussage: §b</motd set h/f>"));
        if (args[2].equals("h")){

            if (args.length > 13) sender.sendMessage(new TextComponent("Bitte nutze nur 15 Wörter für die erste/zweite Linie"));

            for (int i = 2; i < 13; i++) {
                    new SyncProxyMotd().setFirstLine(args[i]);
            }
        }

        
    }
}
