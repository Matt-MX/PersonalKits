package com.mattmx.playerkits.guis;

import com.mattmx.playerkits.Playerkits;
import com.mattmx.playerkits.utils.GUIUtils;
import com.mattmx.playerkits.utils.ItemBuilder;
import com.mattmx.playerkits.utils.Listeners;
import com.mattmx.playerkits.utils.Utils;
import com.mattmx.playerkits.utils.kitutils.KitUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class KitCreator extends GUI{

    UUID ownerID;
    Inventory INV;
    int page = 1;

    public KitCreator(UUID id) {
        super.type =  Type.KIT_CREATOR;
        ownerID = id;
        init();
    }

    public void init() {
        INV = Bukkit.createInventory(null, 54, Utils.chat("&c&oKit Creator"));
        GUIUtils.bottomBar(INV);
        ItemBuilder backButton = new ItemBuilder(Material.BARRIER)
                .name("&c&lBack")
                .lore(new String[] {
                        Utils.chat("&cClick to go &fback"),
                });
        INV.setItem(53, backButton.make());
        int var = 54 - 9;
        for (int i = (page - 1) * var; i < page * var; i++) {
            ItemStack item = KitUtils.getItemStack(i);
            if (item == null) {
                break;
            }
            INV.setItem(i, item);
        }
        if (Bukkit.getPlayer(ownerID).hasPermission("pk.kit.creator.save")) {
            ItemBuilder saveItem = new ItemBuilder(Material.SCUTE)
                    .name("&a&lSave")
                    .lore(new String[] {
                            Utils.chat("&aClick to save Kit Creator menu"),
                    });
            INV.setItem(52, saveItem.make());
        }
    }

    @Override
    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public void open(UUID id) {
        FileConfiguration config = Playerkits.getInstance().getConfig();
        if (config.getBoolean("broadcast-kit-creator-open")) {
            Bukkit.broadcastMessage(Utils.chat(Playerkits.PREFIX + config.getString("broadcast-kit-creator-open-message")
                    .replace("%player%", Bukkit.getPlayer(id).getDisplayName())));
        }
        Bukkit.getPlayer(id).openInventory(INV);
        Listeners.INVS.put(id, this);
    }

    @Override
    public void click(UUID clickerID, InventoryClickEvent e) {
        Player p = Bukkit.getPlayer(clickerID);
        Material mat = e.getCurrentItem().getType();
        p.sendMessage(Utils.chat(Playerkits.PREFIX + "&cClicked"));
        if (mat == Material.GRAY_STAINED_GLASS_PANE) {
            e.setCancelled(true);
            p.sendMessage(Utils.chat(Playerkits.PREFIX + "&bClicked"));
        } else if (mat == Material.BARRIER) {
            e.setCancelled(true);
            KitMenu menu = new KitMenu(p.getUniqueId());
            menu.open(p.getUniqueId());
            this.close(ownerID);
        }
    }

    @Override
    public void close(UUID closerID) {
        Listeners.INVS.remove(closerID);
    }
}
