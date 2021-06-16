package net.zerotoil.cybermissions.cache;

import net.zerotoil.cybermissions.objects.ConfigObject;
import net.zerotoil.cybermissions.objects.DifficultyObject;
import net.zerotoil.cybermissions.utilities.FileUtils;

public class ConfigCache {

    public static ConfigObject configOptions = new ConfigObject();

    public static void initializeConfig() {
        configOptions.setRandomMissions(FileUtils.getConfigFile("config").getBoolean("config.random-missions"));
        configOptions.setAutoStart(FileUtils.getConfigFile("config").getBoolean("config.auto-start"));
        configOptions.setDifficulty(FileUtils.getConfigFile("config").getBoolean("config.difficulty.enabled"));
        configOptions.setDuplicateMissions(FileUtils.getConfigFile("config").getBoolean("config.difficulty.duplicate-missions"));

        // sets up difficulty hashmap
        if (configOptions.isDifficulty()) {
            try {
                if (FileUtils.getConfigFile("config").isList("config.difficulty.list")) {
                    for (String i : FileUtils.getConfigFile("config").getStringList("config.difficulty.list"))
                        MissionCache.storedDifficulties.put(i, new DifficultyObject(i));

                } else {
                    FileUtils.getConfigFile("config").getString("config.difficulty.list");

                }

            } catch (Exception e) { // disables if finds no difficulties in config
                System.out.println("You do not have any difficulties set. Disabling difficulty!");
                configOptions.setDifficulty(false);

            }

        }

    }

}
