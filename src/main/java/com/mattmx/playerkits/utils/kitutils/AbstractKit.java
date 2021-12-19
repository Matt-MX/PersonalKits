package com.mattmx.playerkits.utils.kitutils;

import com.mattmx.playerkits.utils.PKKit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class AbstractKit {
    private List<Integer> contents = new ArrayList<>();
    private UUID ownerId;
    private String owner;
    private String name;
    private int id;
    private boolean isPublic;
    List<String> tags = new ArrayList<>();

    public static PKKit toKit(AbstractKit abstr) {
        PKKit kit = new PKKit();
        kit.name = abstr.getName();
        kit.ownerID = abstr.getOwnerId();
        kit.owner = abstr.getOwner();
        kit.num = abstr.getId();
        kit.isPublic = abstr.isPublic();
        for (String s : abstr.getTags()) {
            try {
                kit.tags.add(PKKit.Tags.valueOf(s));
            } catch (Exception e) {}
        }
        // Make Inventory
        return null;
    }

    public static AbstractKit fromKit(PKKit kit) {
        AbstractKit abstr = new AbstractKit();
        abstr.setName(kit.name);
        abstr.setId(kit.num);
        abstr.setOwner(kit.owner);
        abstr.setOwnerId(kit.ownerID);
        abstr.setPublic(kit.isPublic);
        for (PKKit.Tags t : kit.tags) {
            abstr.getTags().add(t.name());
        }
        for (ItemStack i : kit.inv.getContents()) {
            abstr.getContents().add(KitUtils.getItemId(i));
        }
        return abstr;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Integer> getContents() {
        return contents;
    }

    public void setContents(List<Integer> contents) {
        this.contents = contents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
