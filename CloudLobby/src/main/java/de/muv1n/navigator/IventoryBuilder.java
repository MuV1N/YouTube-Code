package de.muv1n.navigator;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.util.Objects;

public class IventoryBuilder implements Listener {

    public void handle(PlayerInteractEvent e){
        var player = e.getPlayer();
        var item = Objects.requireNonNull(e.getItem()).displayName();

        if (!item.equals("Navigator")) return;

        //player.openInventory();

    }

}
