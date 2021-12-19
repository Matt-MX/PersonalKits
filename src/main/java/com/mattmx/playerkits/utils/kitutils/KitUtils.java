package com.mattmx.playerkits.utils.kitutils;

import com.mattmx.playerkits.utils.ConfigRegistry;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class KitUtils {
    public static int INVALID_ITEMSTACK = -1;

    public static int getItemId(ItemStack i) {
        for (int index = 0; index < ConfigRegistry.ITEMS.getKeys(false).size(); index++) {
            if (ConfigRegistry.ITEMS.getItemStack(Integer.toString(index)) == i) {
                return index;
            }
        }
        return INVALID_ITEMSTACK;
    }

    public static ItemStack getItemStack(int id) {
        return ConfigRegistry.ITEMS.getItemStack(Integer.toString(id));
    }

    public static boolean removeItem(int i) {
        if (!ConfigRegistry.ITEMS.contains(Integer.toString(i))) {
            return false;
        }
        ConfigRegistry.ITEMS.set(Integer.toString(i), "");
        return true;
    }

    public static void addItem(ItemStack item) {
        int amount = ConfigRegistry.ITEMS.getKeys(false).size();
        setItem(amount, item);
    }

    public static void setItem(int i, ItemStack item) {
        ConfigRegistry.ITEMS.set(Integer.toString(i), item);
    }
}
