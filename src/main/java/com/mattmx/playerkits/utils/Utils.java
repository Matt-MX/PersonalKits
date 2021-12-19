package com.mattmx.playerkits.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static void wait(int milli) {
        try {
            Thread.sleep(milli*1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
        };
    }
    private static final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
    public static String chat (String s) {
        if (Bukkit.getVersion().contains("1.16")) {
            Matcher match = pattern.matcher(s);
            while (match.find()) {
                String color = s.substring(match.start(), match.end());
                s = s.replace(color, ChatColor.of(color) + "");
                match = pattern.matcher(s);
            }
        }
        return ChatColor.translateAlternateColorCodes('&', s);

    }
    public static ItemStack createItem(Inventory inv, String materialString, int amount, int invSlot, String displayName, String... loreString) {
        ItemStack item;
        List<String> lore=new ArrayList();
        item=new ItemStack(Material.matchMaterial(materialString),amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat(displayName));
        for (String s : loreString) {
            lore.add(Utils.chat(s));

        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(invSlot-1, item);
        return item;

    }
    public static ItemStack createItemByte(Inventory inv, String materialString, int byteId, int amount, int invSlot, String displayName, String... loreString) {
        ItemStack item;
        List<String> lore=new ArrayList();
        item = new ItemStack(Material.matchMaterial(materialString),amount,(short) byteId);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat(displayName));
        for (String s : loreString) {
            lore.add(Utils.chat(s));

        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(invSlot-1, item);
        return item;

    }

    public static boolean isItemName(ItemStack clicked, String match) {
        return clicked.getItemMeta().getDisplayName().equalsIgnoreCase(chat(match));
    }
}
