package net.zerotoil.cybermissions.objects;

import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class GUIObject {

    private String id;
    private String type;
    private MissionObject mission;
    private ItemStack inactiveItem;
    private ItemStack inProgressItem;
    private ItemStack completedItem;
    private int slot;
    private String difficulty;

    public GUIObject(String id, ItemStack item) {
        this.id = id;
        this.type = "FILLER";
        this.completedItem = item;
        this.slot = -1;
    }

    public GUIObject(String id, ItemStack inProgressItem, ItemStack completedItem, int slot) {
        this.id = id;
        this.type = "MISSION";
        this.inProgressItem = inProgressItem;
        this.completedItem = completedItem;
        this.slot = slot;

    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public MissionObject getMission() {
        return mission;
    }

    public ItemStack getInactiveItem() {
        return inactiveItem;
    }

    public ItemStack getInProgressItem() {
        return inProgressItem;
    }

    public ItemStack getCompletedItem() {
        return completedItem;
    }

    public int getSlot() {
        return slot;
    }

    public String getDifficulty() {
        return difficulty;
    }



    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMission(MissionObject mission) {
        this.mission = mission;
    }

    public void setInactiveItem(ItemStack inactiveItem) {
        this.inactiveItem = inactiveItem;
    }

    public void setInProgressItem(ItemStack inProgressItem) {
        this.inProgressItem = inProgressItem;
    }

    public void setCompletedItem(ItemStack completedItem) {
        this.completedItem = completedItem;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

}
