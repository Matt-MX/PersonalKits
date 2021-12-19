package com.mattmx.playerkits.utils;

import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;

public class ConfigRegistry {

    public static YamlConfiguration KITS;
    public static YamlConfiguration ITEMS;
    public static String KITS_NAME = "kits.yml";
    public static String ITEMS_NAME = "items.yml";

    public static void init() {
        KITS = get(KITS_NAME);
        ITEMS = get(ITEMS_NAME);
    }

    public static YamlConfiguration get(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
        return yml;
    }
}
