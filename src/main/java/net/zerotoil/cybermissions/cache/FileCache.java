package net.zerotoil.cybermissions.cache;

import net.zerotoil.cybermissions.CyberMissions;
import net.zerotoil.cybermissions.objects.ConfigObject;
import net.zerotoil.cybermissions.objects.FileObject;

import java.util.HashMap;

public class FileCache {

    // easy access hashmap of stored files
    private HashMap<String, FileObject> storedFiles = new HashMap<>();
    private CyberMissions main;

    public HashMap<String, FileObject> getStoredFiles() {
        return this.storedFiles;
    }

    public FileCache(CyberMissions main) {

        this.main = main;

        // clears stored files
        if(!storedFiles.isEmpty()) storedFiles.clear();

        // front-end files
        storedFiles.put("config", new FileObject(this.main, "config.yml"));
        storedFiles.put("lang", new FileObject(this.main, "lang.yml"));
        storedFiles.put("missions", new FileObject(this.main, "missions.yml"));
        storedFiles.put("gui", new FileObject(this.main, "gui.yml"));

        // back-end files
        storedFiles.put("playerData", new FileObject(this.main, "data/player-data.yml"));
        storedFiles.put("missionData", new FileObject(this.main, "data/mission-data.yml"));

    }

}
