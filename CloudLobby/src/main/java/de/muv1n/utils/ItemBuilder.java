package de.muv1n.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ItemBuilder {
    private ItemMeta itemMeta;
    private ItemStack itemStack;

    public ItemBuilder(Material mat){
        if (mat == null) mat = Material.AIR;
        itemStack = new ItemStack(mat);
        this.itemMeta = itemStack.getItemMeta();
    }
    public ItemBuilder setName(String s){
        itemMeta.displayName(Component.text(s));
        return this;
    }
    public ItemBuilder setAmount(int s){
        itemStack.setAmount(s);
        return this;
    }
    public ItemBuilder setLore(String... s){
        itemMeta.setLore(Arrays.asList(s));
        return this;
    }
    public ItemBuilder setUnbreakable(boolean s){
        itemMeta.setUnbreakable(s);
        return this;
    }
    public ItemBuilder setLocalizedName(String s){
        itemMeta.setLocalizedName(s);
        return this;
    }

    @Override
    public String toString() {
        return "ItemBuilder{" +
                "itemMeta=" + itemMeta +
                ", itemStack=" + itemStack +
                '}';
    }
    public ItemStack build(){
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
