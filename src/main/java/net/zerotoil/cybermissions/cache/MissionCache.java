package net.zerotoil.cybermissions.cache;

import net.zerotoil.cybermissions.CyberMissions;
import net.zerotoil.cybermissions.objects.ConditionObject;
import net.zerotoil.cybermissions.objects.DifficultyObject;
import net.zerotoil.cybermissions.objects.MissionObject;
import net.zerotoil.cybermissions.utilities.FileUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MissionCache {

    // all missions saved from config
    private HashMap<String, MissionObject> storedMissions = new HashMap<>();

    // all mission ids stored under their difficulty
    private HashMap<String, DifficultyObject> storedDifficulties = new HashMap<>();

    // all mission conditions
    private List<String> storedConditions = new ArrayList<>();

    private CyberMissions main;

    public HashMap<String, MissionObject> getStoredMissions() {
        return this.storedMissions;
    }
    public HashMap<String, DifficultyObject> getStoredDifficulties() {
        return this.storedDifficulties;
    }
    public List<String> getStoredConditions() {
        return this.storedConditions;
    }


    public MissionCache(CyberMissions main) {
        this.main = main;

        if (!storedMissions.isEmpty()) storedMissions.clear();
        if (!storedConditions.isEmpty()) storedConditions.clear();

        // loops through all mission IDs
        for (String i : main.getFileUtils().getConfigFile("missions").getConfigurationSection("missions").getKeys(false)) {

            // stores a new mission object
            storedMissions.put(i, new MissionObject(main, i, main.getFileUtils().getMissionString(i + ".display-name"),
                    main.getFileUtils().getMissionString(i + ".description"), main.getFileUtils().getMissionString(i + "difficulty")));

            // stores all conditions in the Condition Object inside of the MissionObject
            for (String a : main.getFileUtils().getConfigFile("missions").getConfigurationSection("missions." + i + ".conditions").getKeys(false)) {

                storedMissions.get(i).getConditions().put(a, new ConditionObject(a, main.getFileUtils().getConfigFile("missions")
                        .getDouble("missions." + i + ".conditions." + a + ".amount"), main.getFileUtils().getConfigFile("missions")
                        .getStringList("missions." + i + ".conditions." + a + ".type")));

                if (!storedConditions.contains(a)) storedConditions.add(a);
            }

            // is there a start message?
            if (main.getFileUtils().getConfigFile("missions").isSet("missions." + i + ".start-message"))
                storedMissions.get(i).setStartMessage(main.getFileUtils().getMissionString(i + ".start-message"));

            // is there a finish message?
            if (main.getFileUtils().getConfigFile("missions").isSet("missions." + i + ".finish-message"))
                storedMissions.get(i).setFinishMessage(main.getFileUtils().getMissionString(i + ".finish-message"));


        }
    }

}
