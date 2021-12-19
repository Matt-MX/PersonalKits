package com.mattmx.playerkits.commands;

import com.mattmx.playerkits.Playerkits;
import com.mattmx.playerkits.guis.KitCreator;
import com.mattmx.playerkits.guis.KitMenu;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
/*
Command structure as follows
/pk [pk.main]
 exec - Open GUI:
 - Public Kits [pk.viewpublic]
 - Kit {num} [pk.kit.{num}]
 - Kit Creator [pk.kit.creator]
 */

public class PKCommand implements CommandExecutor {
    private Playerkits pl;
    public PKCommand(Playerkits pl) {
        this.pl = pl;
        Bukkit.getPluginCommand("pk").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("player-only command");
            return false;
        }
        Player p = (Player) sender;
        // TODO open KIT_MENU gui
        KitMenu menu = new KitMenu(p.getUniqueId());
        menu.open(p.getUniqueId());
        return false;
    }
}
