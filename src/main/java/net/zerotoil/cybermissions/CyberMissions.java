package net.zerotoil.cybermissions;

import net.zerotoil.cybermissions.cache.FileCache;
import net.zerotoil.cybermissions.main.CMSCommands;
import org.bukkit.plugin.java.JavaPlugin;

public final class CyberMissions extends JavaPlugin {

    private static CyberMissions instance;

    // lets other classes access this plugin instance
    public static CyberMissions getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        // init this plugin instance
        instance = this;

        // loads up the files into cache
        FileCache.initializeFiles();

        // registers commands
        new CMSCommands(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
