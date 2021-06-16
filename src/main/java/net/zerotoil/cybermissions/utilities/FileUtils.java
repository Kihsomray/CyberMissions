package net.zerotoil.cybermissions.utilities;

import net.zerotoil.cybermissions.cache.FileCache;
import org.bukkit.configuration.Configuration;

public class FileUtils {

    public static Configuration getConfigFile(String file) {
        return FileCache.storedFiles.get(file).getConfig();
    }

    public static String getLangString(String path, boolean addPrefix) {
        return MessageUtils.getColor(getConfigFile("lang").getString(path), addPrefix);
    }

    public static String getMissionString(String missionPath) {
        return FileCache.storedFiles.get("missions").getConfig().getString("mission." + missionPath);
    }

}
