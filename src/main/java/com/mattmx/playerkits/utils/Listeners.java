package com.mattmx.playerkits.utils;

import com.mattmx.playerkits.guis.GUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Listeners implements Listener {
    public static final Map<UUID, GUI> INVS = new HashMap<>();

    public static GUI path(UUID id) {
        return INVS.get(id);
    }

    @EventHandler
    public void onGUIClick(InventoryClickEvent e) {
        UUID id = e.getWhoClicked().getUniqueId();
        if (INVS.containsKey(id)) {
            if (e.getClickedInventory() instanceof PlayerInventory) return;
            if (e.getCurrentItem() == null) return;
            path(id).click(id, e);
        }
    }

    @EventHandler
    public void onGUIClose(InventoryCloseEvent e) {
        UUID id = e.getPlayer().getUniqueId();

        if (INVS.containsKey(id)) {
            path(id).close(id);
        }
    }
}
