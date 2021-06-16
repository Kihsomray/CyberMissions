package net.zerotoil.cybermissions.cache;

import net.zerotoil.cybermissions.CyberMissions;
import net.zerotoil.cybermissions.objects.ConfigObject;

import java.util.HashMap;

public class FileCache {

    // easy access hashmap of stored files
    public static HashMap<String, ConfigObject> storedFiles = new HashMap<>();

    public static void initializeFiles() {

        // clears stored files
        if(!storedFiles.isEmpty()) storedFiles.clear();

        // front-end files
        storedFiles.put("config", new ConfigObject(CyberMissions.getInstance(), "config.yml"));
        storedFiles.put("lang", new ConfigObject(CyberMissions.getInstance(), "lang.yml"));
        storedFiles.put("missions", new ConfigObject(CyberMissions.getInstance(), "missions.yml"));
        storedFiles.put("gui", new ConfigObject(CyberMissions.getInstance(), "gui.yml"));

        // back-end files
        storedFiles.put("playerData", new ConfigObject(CyberMissions.getInstance(), "data/player-data.yml"));
        storedFiles.put("missionData", new ConfigObject(CyberMissions.getInstance(), "data/mission-data.yml"));

    }

}
