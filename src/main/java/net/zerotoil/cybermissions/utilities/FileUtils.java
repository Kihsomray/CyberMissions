package net.zerotoil.cybermissions.utilities;

import net.zerotoil.cybermissions.CyberMissions;
import net.zerotoil.cybermissions.cache.FileCache;
import org.bukkit.configuration.Configuration;

public class FileUtils {

    private CyberMissions main;
    public FileUtils(CyberMissions main) {
        this.main = main;
    }

    public Configuration getConfigFile(String file) {
        return main.getFileCache().getStoredFiles().get(file).getConfig();
    }

    public String getLangString(String path, boolean addPrefix) {
        return main.getMessageUtils().getColor(getConfigFile("lang").getString(path), addPrefix);
    }

    public String getMissionString(String missionPath) {
        return main.getFileCache().getStoredFiles().get("missions").getConfig().getString("mission." + missionPath);
    }

}
