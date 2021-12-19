package com.mattmx.playerkits.utils;

import org.bukkit.inventory.Inventory;

import java.util.UUID;
import java.util.*;

public class PKKit {
    public String name;
    public String owner;
    public UUID ownerID;
    public Inventory inv;
    public boolean isPublic;
    public int num;
    public List<Tags> tags = new ArrayList<>();

    public PKKit() {

    }

    public PKKit(UUID ownerID, Inventory inv) {
        new PKKit("", "", ownerID, inv, null);
    }

    public PKKit(String owner, UUID ownerID, Inventory inv) {
        new PKKit("", owner, ownerID, inv, null);
    }

    public PKKit(String name, String owner, UUID ownerID, Inventory inv, List<Tags> tags) {
        this.name = name;
        this.owner = owner;
        this.ownerID = ownerID;
        this.inv = inv;
        this.tags = tags;
    }

    public enum Tags {
        CRYSTAL,
        SWORD,
        BOW,
        UHC,
        ANCHOR,
        FFA,
        NETHERITE,
        DIAMOND,
        AXE,
        FUN,
    }
}
