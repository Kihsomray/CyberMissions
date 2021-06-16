package net.zerotoil.cybermissions.cache;

import net.zerotoil.cybermissions.objects.ConditionObject;
import net.zerotoil.cybermissions.objects.DifficultyObject;
import net.zerotoil.cybermissions.objects.MissionObject;
import net.zerotoil.cybermissions.utilities.FileUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MissionCache {

    // all missions saved from config
    public static HashMap<String, MissionObject> storedMissions = new HashMap<>();

    // all mission ids stored under their difficulty
    public static HashMap<String, DifficultyObject> storedDifficulties = new HashMap<>();

    // all mission conditions
    public static List<String> storedConditions = new ArrayList<>();

    //

    public static void initializeMissions() {

        for (String i : FileUtils.getConfigFile("missions").getConfigurationSection("missions").getKeys(false)) {
            storedMissions.put(i, new MissionObject(i, FileUtils.getMissionString(i + ".display-name"),
                    FileUtils.getMissionString(i + ".description"), FileUtils.getMissionString(i + "difficulty")));

            // stores all conditions in the Condition Object inside of the MissionObject
            for (String c : FileUtils.getConfigFile("missions").getConfigurationSection("missions." + i + ".conditions").getKeys(false)) {
                storedMissions.get(i).getConditions().put(c, new ConditionObject(c, FileUtils.getConfigFile("missions")
                        .getDouble("missions." + i + ".conditions." + c + ".amount"), FileUtils.getConfigFile("missions")
                        .getStringList("missions." + i + ".conditions." + c + ".type")));
                if (!storedConditions.contains(c))
                    storedConditions.add(c);
            }

            // is there a start message?
            if (FileUtils.getConfigFile("missions").isSet("missions." + i + ".start-message"))
                storedMissions.get(i).setStartMessage(FileUtils.getMissionString(i + ".start-message"));

            // is there a finish message?
            if (FileUtils.getConfigFile("missions").isSet("missions." + i + ".finish-message"))
                storedMissions.get(i).setFinishMessage(FileUtils.getMissionString(i + ".finish-message"));


        }
    }




}
