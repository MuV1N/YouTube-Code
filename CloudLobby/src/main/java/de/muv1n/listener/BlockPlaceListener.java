package de.muv1n.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {
    @EventHandler
    public void handle(BlockPlaceEvent e){
        var player = e.getPlayer();
        e.setCancelled(!player.hasPermission("lobby.break"));

    }
}
