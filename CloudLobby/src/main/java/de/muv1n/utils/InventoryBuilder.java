package de.muv1n.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryBuilder {

    private final Inventory inv;

    public InventoryBuilder(int size, Component title){
        this.inv = Bukkit.createInventory(null, size, title);
    }
    public InventoryBuilder addItem(int slot, ItemBuilder itemBuilder){

        inv.setItem(slot, itemBuilder.build());

        return this;
    }
    public Inventory build(){
        return inv;
    }

}
