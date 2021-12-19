package com.mattmx.playerkits;

import com.mattmx.playerkits.commands.KitCommand;
import com.mattmx.playerkits.commands.PKCommand;
import com.mattmx.playerkits.utils.ConfigRegistry;
import com.mattmx.playerkits.utils.GUIUtils;
import com.mattmx.playerkits.utils.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Playerkits extends JavaPlugin {

    static Playerkits instance;
    public static String PREFIX = "&6&lPK&f&l> &7&o";

    @Override
    public void onEnable() {
        saveDefaultConfig();
        instance = this;
        ConfigRegistry.init();
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        new PKCommand(this);
        new KitCommand(this);
        registerRepeating();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerRepeating() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> GUIUtils.doSecond(), 0L, 20L);
    }

    public static Playerkits getInstance() {
        return instance;
    }
}
