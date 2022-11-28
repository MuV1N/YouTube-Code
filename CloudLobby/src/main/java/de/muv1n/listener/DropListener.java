package de.muv1n.listener;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropListener implements Listener {
    @EventHandler
    public void handle(PlayerDropItemEvent e){
        var player = e.getPlayer();
        Item item = e.getItemDrop();
        System.out.println(item.name());

        if (!item.name().equals(Component.text("Navigator"))) e.setCancelled(true);

    }
}
