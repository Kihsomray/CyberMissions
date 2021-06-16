package net.zerotoil.cybermissions.cache;

import net.zerotoil.cybermissions.CyberMissions;
import net.zerotoil.cybermissions.objects.ConfigObject;
import net.zerotoil.cybermissions.objects.FileObject;

import java.util.HashMap;

public class FileCache {

    // easy access hashmap of stored files
    public static HashMap<String, FileObject> storedFiles = new HashMap<>();

    public static void initializeFiles() {

        // clears stored files
        if(!storedFiles.isEmpty()) storedFiles.clear();

        // front-end files
        storedFiles.put("config", new FileObject(CyberMissions.getInstance(), "config.yml"));
        storedFiles.put("lang", new FileObject(CyberMissions.getInstance(), "lang.yml"));
        storedFiles.put("missions", new FileObject(CyberMissions.getInstance(), "missions.yml"));
        storedFiles.put("gui", new FileObject(CyberMissions.getInstance(), "gui.yml"));

        // back-end files
        storedFiles.put("playerData", new FileObject(CyberMissions.getInstance(), "data/player-data.yml"));
        storedFiles.put("missionData", new FileObject(CyberMissions.getInstance(), "data/mission-data.yml"));

    }

}
