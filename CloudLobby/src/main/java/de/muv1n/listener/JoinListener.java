package de.muv1n.listener;

import de.muv1n.utils.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void handle(PlayerJoinEvent e){
        var player = e.getPlayer();
        player.getInventory().setItem(1, new ItemBuilder(Material.COMPASS).setName("Navigator").build());
    }
}
