package net.zerotoil.cybermissions;

import net.zerotoil.cybermissions.cache.*;
import net.zerotoil.cybermissions.main.CMSCommands;
import net.zerotoil.cybermissions.main.ReloadData;
import net.zerotoil.cybermissions.utilities.FileUtils;
import net.zerotoil.cybermissions.utilities.MessageUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class CyberMissions extends JavaPlugin {

    private FileCache fileCache;
    private MissionCache missionCache;
    private ConfigCache configCache;
    private GUICache guiCache;

    private FileUtils fileUtils;
    private MessageUtils messageUtils;

    public FileCache getFileCache() {
        return this.fileCache;
    }
    public MissionCache getMissionCache() {
        return this.missionCache;
    }
    public ConfigCache getConfigCache() {
        return this.configCache;
    }
    public GUICache getGuiCache() {
        return this.guiCache;
    }

    public FileUtils getFileUtils() {
        return this.fileUtils;
    }
    public MessageUtils getMessageUtils() {
        return this.messageUtils;
    }

    @Override
    public void onEnable() {

        // reload data
        new ReloadData(this);

        // registers commands
        new CMSCommands(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void reloadCache() {

        // loads up the files into cache
        fileCache = new FileCache(this);

        fileUtils = new FileUtils(this);
        messageUtils = new MessageUtils(this);

        // loads up all the missions into cache
        missionCache = new MissionCache(this);

        // loads up all the config options into cache
        configCache = new ConfigCache(this);

        // loads up all gui/active mission info
        guiCache = new GUICache(this);

    }

}
