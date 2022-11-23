package de.muv1n;

import de.muv1n.commands.SetMOTDCommand;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.logging.Level;

public class MOTDS extends Plugin {

    @Override
    public void onEnable() {
        getLogger().log(Level.WARNING, "LADEN");
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new SetMOTDCommand());
    }
}