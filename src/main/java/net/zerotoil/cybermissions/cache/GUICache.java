package net.zerotoil.cybermissions.cache;

import net.zerotoil.cybermissions.CyberMissions;
import net.zerotoil.cybermissions.objects.ConfigObject;
import net.zerotoil.cybermissions.objects.DifficultyObject;
import net.zerotoil.cybermissions.objects.GUIObject;
import net.zerotoil.cybermissions.objects.MissionObject;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


// must be initiated after config cache
public class GUICache {

    private CyberMissions main;

    private String menuName;
    private int rows;
    private HashMap<String, GUIObject> storedGUIs = new HashMap<>();
    private HashMap<String, DifficultyObject> disabledDifficultyMissions = new HashMap<>();
    private HashMap<String, MissionObject> disabledMissions = new HashMap<>();
    private Configuration guiConfig;
    private ConfigObject config;


    public GUICache(CyberMissions main) {
        this.main = main;

        // clears hashmaps
        if (!storedGUIs.isEmpty()) storedGUIs.clear();
        if (!disabledDifficultyMissions.isEmpty()) disabledDifficultyMissions.clear();
        if (!disabledMissions.isEmpty()) disabledMissions.clear();

        guiConfig = main.getFileUtils().getConfigFile("gui");
        config = main.getConfigCache().getConfigOptions();

        // adds new info back into hashmaps
        disabledDifficultyMissions = main.getMissionCache().getStoredDifficulties();
        disabledMissions = main.getMissionCache().getStoredMissions();

        // basic variables
        menuName = guiConfig.getString("gui.options.name");
        rows = guiConfig.getInt("gui.options.rows");

        for (String guiID : guiConfig.getConfigurationSection("gui.gui-items").getKeys(false)) {
            String locationPrefix = "gui.gui-items." + guiID + ".";

            // filler items
            if (guiConfig.getString(locationPrefix + "type").equalsIgnoreCase("FILLER")) {

                // stores the filler item
                storedGUIs.put(guiID, new GUIObject(guiID, createItem(locationPrefix + "item")));

                continue;
            }

            // mission item
            if (guiConfig.getString(locationPrefix + "type").equalsIgnoreCase("MISSION")) {

                // basic GUI item structure
                storedGUIs.put(guiID, new GUIObject(guiID, createItem(locationPrefix + "in-progress"),
                        createItem(locationPrefix + "completed"), guiConfig.getInt(locationPrefix + "slot")));

                // is difficulty enabled?
                if (main.getConfigCache().getConfigOptions().isDifficulty()) {
                    storedGUIs.get(guiID).setDifficulty(guiConfig.getString(locationPrefix + "difficulty"));
                }

                // is auto start NOT enabled?
                if (!main.getConfigCache().getConfigOptions().isAutoStart()) {
                    storedGUIs.get(guiID).setInactiveItem(createItem(locationPrefix + "inactive"));
                }

                // random missions enabled
                if (config.isRandomMissions()) {

                    // mission(s) not per player
                    if (!config.isPerPlayer()) {

                        MissionObject missionObject = generateMission(locationPrefix, guiID);
                        if (missionObject == null) {

                            storedGUIs.remove(guiID);
                            continue;

                        } else {

                            storedGUIs.get(guiID).setMission(missionObject);

                        }

                    } else {

                        storedGUIs.get(guiID).setMission(null);

                    }

                // if random missions are disabled
                } else {

                    try {

                        storedGUIs.get(guiID).setMission(main.getMissionCache().getStoredMissions().get(guiConfig.getString(locationPrefix + "mission")));

                    } catch (Exception e) {

                        System.out.println("GUI item #" + guiID + " does not have a valid ID. Disabling this GUI item.");
                        storedGUIs.remove(guiID);
                        continue;

                    }

                }

                continue;

            }

            System.out.println("GUI item #" + guiID + " does not have a proper type. Disabling this GUI item.");
            storedGUIs.remove(guiID);
            continue;

        }

    }

    // generates an item
    public ItemStack createItem(String parentLocation) {

        Material material = Material.getMaterial(guiConfig.getString(parentLocation + ".material"));
        int amount = guiConfig.getInt(parentLocation + ".amount");
        String name = guiConfig.getString(parentLocation + ".name");
        List lore = makeLoreList(parentLocation + ".lore");

        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(main.getMessageUtils().getColor(name, false));
        if (!lore.isEmpty()) meta.setLore(main.getMessageUtils().getListColor(lore, false));

        item.setItemMeta(meta);

        return item;
    }

    // creates a lore list from gui config
    public List makeLoreList(String path) {
        List list = new ArrayList();

        // if lore is a list
        if (guiConfig.isList(path)) {
            list = guiConfig.getList(path);

        // if lore is single line
        } else if (guiConfig.isSet(path)) {
            list.add(guiConfig.getString(path));

        // if lore does not exist
        } else {
            list = null;
        }

        return list;
    }

    // creates a mission for the gui item
    public MissionObject generateMission (String locationPrefix, String guiID) {

        // is duplicate; difficulty enabled
        if (config.isDuplicateMissions() && config.isDifficulty()) {

            String difficultyString = guiConfig.getString(locationPrefix + "difficulty");
            try {

                // generates a random mission of the ones already enabled
                int missionNumber = new Random().nextInt(main.getMissionCache().getStoredDifficulties().get(difficultyString).getMissions().size());

                // adds the mission to the stored GUI item
                return main.getMissionCache().getStoredMissions().get(disabledDifficultyMissions.get(difficultyString).getMissions().get(missionNumber));

            } catch (Exception e) {

                System.out.println("GUI item ID " + guiID + " does not have a valid difficulty set! Disabling this GUI item.");
                return null;

            }

        }

        // not duplicate; difficulty enabled
        if (!config.isDuplicateMissions() && config.isDifficulty()) {

            String difficultyString = guiConfig.getString(locationPrefix + "difficulty");

            try {

                // make sure there is at least one mission in the difficulty available
                if (disabledDifficultyMissions.get(difficultyString).getMissions().size() > 0) {

                    // generates a random mission of the ones disabled
                    int missionNumber = new Random().nextInt(disabledDifficultyMissions.get(difficultyString).getMissions().size());

                    // retrieves mission from stored missions after getting mission number
                    MissionObject mission = main.getMissionCache().getStoredMissions().get(disabledDifficultyMissions.get(difficultyString).getMissions().get(missionNumber));

                    // removes it from the disabled missions
                    disabledDifficultyMissions.get(difficultyString).getMissions().remove(missionNumber);

                    return mission;

                } else {

                    System.out.println("All the mission are already enabled in " + difficultyString + " difficulty. Disabling GUI item ID " + guiID + ".");
                    return null;

                }

            } catch (Exception e) {
                System.out.println("GUI item ID " + guiID + " does not have a valid difficulty set! Disabling this GUI item.");
                return null;
            }

        }

        // is duplicate; difficulty disabled
        if (config.isDuplicateMissions() && !config.isDifficulty()) {

            try {

                // generates a random mission (amount of missions)
                int missionNumber = new Random().nextInt(main.getMissionCache().getStoredMissions().size());

                // loops through all mission IDs
                for (String a : main.getMissionCache().getStoredMissions().keySet()) {

                    // decreases the index
                    missionNumber--;

                    // when random number is same as index, return
                    if (missionNumber == 0) {

                        // return random mission
                        return main.getMissionCache().getStoredMissions().get(a);

                    }

                }

            } catch (Exception e) {
                System.out.println("GUI item ID " + guiID + " does not have a valid difficulty set! Disabling this GUI item.");
                return null;
            }

        }

        // not duplicate; difficulty disabled
        if (!config.isDuplicateMissions() && !config.isDifficulty()) {

            // if there is at least one disabled mission
            if (disabledMissions.size() > 0) {

                // generates a random mission of the ones disabled
                int missionNumber = new Random().nextInt(disabledMissions.size());

                // loops through all mission IDs
                for (String a : disabledMissions.keySet()) {

                    // changes index
                    missionNumber--;

                    // when random mission is chosen, set it to that.
                    if (missionNumber == 0) {

                        // gets the mission object
                        MissionObject mission = disabledMissions.get(a);

                        // removes it from the disabled missions
                        disabledMissions.remove(a);

                        return mission;
                    }

                }

            } else {

                System.out.println("All the mission are already enabled. Disabling GUI item ID " + guiID + ".");
                return null;

            }

        }

        System.out.println("Something went wrong with GUI item #" + guiID);
        return null;
    }

}
