package net.zerotoil.cybermissions.utilities;

import net.zerotoil.cybermissions.cache.FileCache;
import org.bukkit.ChatColor;

public class MessageUtils {


    private static String prefix = FileUtils.getLangString( "messages.prefix", false) + " ";

    // gets color of chat message
    public static String getColor(String msg, boolean addPrefix){
        if (addPrefix) {
            return prefix + " " + ChatColor.translateAlternateColorCodes('&', msg);
        } else {
            return ChatColor.translateAlternateColorCodes('&', msg);
        }
    }

    // sends no permission message
    public static String noPermission() {
        // config: messages.no-permission
        return (FileUtils.getLangString("messages.no-permission", true));

    }

}
