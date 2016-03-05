package me.eetee.Core.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemBuilder {

    private ItemStack item;
    private ItemMeta meta;
    private Material material = Material.STONE;
    private int amount = 1;
    private MaterialData data;
    private short damage = 0;
    private Map<Enchantment, Integer> enchantments = new HashMap<>();
    private String displayname;
    private List<String> lore = new ArrayList<>();
    private List<ItemFlag> flags = new ArrayList<>();

 
    public ItemBuilder(Material material) {
        this.material = material;
    }

    public ItemBuilder(ItemStack item) {
        this.item = item;
        this.meta = item.getItemMeta();
        this.material = item.getType();
        this.amount = item.getAmount();
        this.data = item.getData();
        this.damage = item.getDurability();
        this.enchantments = item.getEnchantments();
        this.displayname = item.getItemMeta().getDisplayName();
        this.lore = item.getItemMeta().getLore();
        for(ItemFlag f : item.getItemMeta().getItemFlags()) {
            flags.add(f);
        }
    }

    public ItemBuilder amount(int amount) {
        this.amount = amount;
        return this;
    }

   
    public ItemBuilder data(MaterialData data) {
        this.data = data;
        return this;
    }

 
    @Deprecated
    public ItemBuilder damage(short damage) {
        this.damage = damage;
        return this;
    }

    public ItemBuilder durability(short damage) {
        this.damage = damage;
        return this;
    }

    public ItemBuilder material(Material material) {
        this.material = material;
        return this;
    }

    public ItemBuilder meta(ItemMeta meta) {
        this.meta = meta;
        return this;
    }

  
    public ItemBuilder enchant(Enchantment enchant, int level) {
        enchantments.put(enchant, level);
        return this;
    }

    

    public ItemBuilder enchant(Map<Enchantment, Integer> enchantments) {
        this.enchantments = enchantments;
        return this;
    }

    
    public ItemBuilder displayname(String displayname) {
        this.displayname = displayname;
        return this;
    }

    
    public ItemBuilder lore(String line) {
        lore.add(line);
        return this;
    }

  
    public ItemBuilder lore(List<String> lore) {
        this.lore = lore;
        return this;
    }

   
    public ItemBuilder lore(String line, int count) {
        lore.set(count, line);
        return this;
    }

    public ItemBuilder flag(ItemFlag flag) {
        flags.add(flag);
        return this;
    }

    public ItemBuilder flag(List<ItemFlag> flags) {
        this.flags = flags;
        return this;
    }

  
    public ItemBuilder unbreakable(boolean unbreakable) {
        meta.spigot().setUnbreakable(unbreakable);
        return this;
    }

    public ItemBuilder owner(String user) {
        if((material == Material.SKULL_ITEM) || (material == Material.SKULL)) {
            SkullMeta smeta = (SkullMeta) meta;
            smeta.setOwner(user);
            meta = smeta;
        }
        return this;
    }

    public ItemStack build() {
        item = new ItemStack(material, amount, damage);
        meta = item.getItemMeta();
        if(data != null) {
            item.setData(data);
        }
        if(enchantments.size() > 0) {
            item.addUnsafeEnchantments(enchantments);
        }
        if(displayname != null) {
            meta.setDisplayName(displayname);
        }
        if(lore.size() > 0) {
            meta.setLore(lore);
        }
        if(flags.size() > 0) {
            for(ItemFlag f : flags) {
                meta.addItemFlags(f);
            }
        }
        item.setItemMeta(meta);
        return item;
    }
    
}

