package de.muv1n.navigator;

import de.muv1n.utils.InventoryBuilder;
import de.muv1n.utils.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class NavigatorInventory implements Listener {

    @EventHandler
    public void handle(PlayerInteractEvent e){
        var player = e.getPlayer();
        var item = e.getMaterial();

        if (!(item == Material.COMPASS)) return;

        player.openInventory(new InventoryBuilder(3*9, Component.text("test")).addItem(0, new ItemBuilder(Material.ACACIA_LOG)).build());

    }

}
