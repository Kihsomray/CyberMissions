package net.zerotoil.cybermissions.utilities;

import net.zerotoil.cybermissions.CyberMissions;
import net.zerotoil.cybermissions.cache.FileCache;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class MessageUtils {

    private CyberMissions main;
    private String prefix;

    public MessageUtils(CyberMissions main) {
        this.main = main;

        prefix = getColor(main.getFileCache().getStoredFiles().get("lang").getConfig().getString("messages.prefix"), false);

    }

    // gets color of chat message
    public String getColor(String msg, boolean addPrefix){
        if (addPrefix) {
            return prefix + " " + ChatColor.translateAlternateColorCodes('&', msg);
        } else {
            return ChatColor.translateAlternateColorCodes('&', msg);
        }
    }

    // gets color of chat message
    public List getListColor(List<String> msg, boolean addPrefix){
        List newMsg = new ArrayList();
        if (addPrefix) {
            for (String i : msg) {
                newMsg.add(prefix + " " + ChatColor.translateAlternateColorCodes('&', i));
            }
        } else {
            for (String i : msg) {
                newMsg.add(ChatColor.translateAlternateColorCodes('&', i));
            }
        }
        return newMsg;
    }

    // sends no permission message
    public String noPermission() {
        // config: messages.no-permission
        return (main.getFileUtils().getLangString("messages.no-permission", true));

    }

}
