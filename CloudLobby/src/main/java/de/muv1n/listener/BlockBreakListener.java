package de.muv1n.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void handle(BlockBreakEvent e){
        var player = e.getPlayer();
        e.setCancelled(!player.hasPermission("lobby.break"));


    }
}
