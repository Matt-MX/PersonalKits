package com.mattmx.playerkits.commands;

import com.mattmx.playerkits.Playerkits;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KitCommand implements CommandExecutor {
    private Playerkits pl;

    public KitCommand(Playerkits pl) {
        this.pl = pl;
        Bukkit.getPluginCommand("kit").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("player-only command");
            return false;
        }
        Player p = (Player) sender;
        if (!(p.hasPermission("pk.kit"))) p.sendMessage("perms");
        return false;
    }
}
