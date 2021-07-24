package net.zerotoil.cybermissions.cache;

import net.zerotoil.cybermissions.CyberMissions;
import net.zerotoil.cybermissions.objects.ConfigObject;
import net.zerotoil.cybermissions.objects.DifficultyObject;
import net.zerotoil.cybermissions.utilities.FileUtils;
import org.bukkit.configuration.Configuration;

import java.util.HashMap;

public class ConfigCache {

    public ConfigObject getConfigOptions() {
        return this.configOptions;
    }

    private ConfigObject configOptions = new ConfigObject();

    private CyberMissions main;

    public ConfigCache(CyberMissions main) {
        this.main = main;

        configOptions.setRandomMissions(getConfigBoolean("config.random-missions.enabled"));
        configOptions.setPerPlayer(getConfigBoolean("config.random-missions.per-player"));
        configOptions.setDifficulty(getConfigBoolean("config.random-missions.difficulty.enabled"));
        configOptions.setDuplicateMissions(getConfigBoolean("config.random-missions.difficulty.duplicate-missions"));
        configOptions.setAutoStart(getConfigBoolean("config.auto-start"));
        configOptions.setMaxMissions(getConfigInt("config.max-missions-enabled"));

        // sets up difficulty hashmap
        if (configOptions.isDifficulty()) {
            try {

                Configuration config = main.getFileUtils().getConfigFile("config");

                for (String i : config.getConfigurationSection("config.random-missions.difficulty.difficulties").getKeys( false)) {
                    this.main.getMissionCache().getStoredDifficulties().put(i, new DifficultyObject(i));

                    for (String a : config.getConfigurationSection("config.random-missions.difficulty.difficulties." + i + ".missions").getKeys(false)) {
                        this.main.getMissionCache().getStoredDifficulties().get(i).addMission(a);
                    }

                }
            } catch (Exception e) { // disables if finds no difficulties in config
                System.out.println("You do not have any difficulties set. Disabling difficulty!");
                configOptions.setDifficulty(false);

            }

        }

    }

    public boolean getConfigBoolean(String path) {
        return main.getFileUtils().getConfigFile("config").getBoolean(path);
    }

    public int getConfigInt(String path) {
        return main.getFileUtils().getConfigFile("config").getInt(path);
    }

}
