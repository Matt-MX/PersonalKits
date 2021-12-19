package com.mattmx.playerkits.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class GUIUtils {
    public static void bottomBar(Inventory INV) {
        int m = INV.getSize();
        ItemBuilder i = new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
                .name(" ")
                .enchantment(Enchantment.MENDING)
                .amount(1);
        for (int c = (m - 9); c < m; c++) {
            INV.setItem(c, i.make());
        }
    }

    private static Map<Player, Integer> CLICK_COOLDOWN = new HashMap<Player, Integer>();
    public static void doSecond() {
        for (Player p : CLICK_COOLDOWN.keySet()) {
            int i = CLICK_COOLDOWN.get(p);
            i--;
            if (i == 0) {
                CLICK_COOLDOWN.remove(p);
            }
        }
    }
    private static void addToCooldown(Player p, int c) {
        CLICK_COOLDOWN.put(p, c);
    }
    private static Integer getCooldown(Player p) {
        if (CLICK_COOLDOWN.containsKey(p)) {
            return CLICK_COOLDOWN.get(p);
        }
        return null;
    }
}
