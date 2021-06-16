package net.zerotoil.cybermissions.objects;

import net.zerotoil.cybermissions.CyberMissions;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigObject {

    // ---- Fields ----
    private CyberMissions plugin;
    private File configFile;
    private FileConfiguration dataConfig;
    private String location;
    private String name;

    // ---- Constructors ----
    // loads a new file
    public ConfigObject(CyberMissions plugin, String location) {
        this.plugin = plugin;
        this.location = location;
        this.name = location.replace(".yml", "");
        saveDefaultConfig();
        dataConfig = YamlConfiguration.loadConfiguration(getFile());

    }
    private File getFile(){
        return new File(CyberMissions.getInstance().getDataFolder(), location);
    }


    // ---- Accessors ----
    public FileConfiguration getConfig() {
        return dataConfig;
    }


    // ---- Mutators ----
    // saves all data
    public void saveConfig() throws IOException {
        if (!((this.dataConfig == null) || (this.configFile == null))) {
            this.getConfig().save(this.configFile);
        }
    }

    // saves the stock config
    public void saveDefaultConfig(){
        if (configFile == null) {
            configFile = getFile();
        }

        if (configFile.exists()) {
            return;
        }
        CyberMissions.getInstance().saveResource(location, false);
    }

}
