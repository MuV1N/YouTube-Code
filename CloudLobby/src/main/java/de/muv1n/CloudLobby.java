package de.muv1n;

import de.muv1n.listener.BlockBreakListener;
import de.muv1n.listener.BlockPlaceListener;
import de.muv1n.listener.JoinListener;
import de.muv1n.messages.RandomMessage;
import de.muv1n.navigator.NavigatorInventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CloudLobby extends JavaPlugin {
    private static CloudLobby instance;
    private Player player;
    @Override
    public void onEnable() {
        instance = this;

        new RandomMessage();

        PluginManager m = Bukkit.getPluginManager();
        m.registerEvents(new JoinListener(), this);
        m.registerEvents(new NavigatorInventory(), this);
        m.registerEvents(new BlockBreakListener(), this);
        m.registerEvents(new BlockPlaceListener(), this);
        //m.registerEvents(new DropListener(), this);

    }

    @Override
    public void onDisable() {



    }
    public static CloudLobby getInstance() {
        return instance;
    }
}