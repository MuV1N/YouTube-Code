package de.muv1n;

import de.muv1n.listener.JoinListener;
import de.muv1n.navigator.NavigatorInventory;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CloudLobby extends JavaPlugin {

    @Override
    public void onEnable() {

        PluginManager m = Bukkit.getPluginManager();
        m.registerEvents(new JoinListener(), this);
        m.registerEvents(new NavigatorInventory(), this);

    }

    @Override
    public void onDisable() {

    }
}