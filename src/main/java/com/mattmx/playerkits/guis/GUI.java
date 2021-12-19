package com.mattmx.playerkits.guis;

import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.UUID;

public abstract class GUI {

    public enum Type {
        KIT,
        PUBLIC_KIT,
        PUBLIC_KIT_MENU,
        KIT_CREATOR,
        MENU
    }

    protected Type type;

    public abstract void setPage(int page);
    public abstract void open(UUID id);
    public abstract void click(UUID clickerID, InventoryClickEvent e);
    public abstract void close(UUID closerID);

    public Type getType() {
        return type;
    }
}
