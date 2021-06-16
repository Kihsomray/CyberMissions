package net.zerotoil.cybermissions.main;

import net.zerotoil.cybermissions.CyberMissions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CMSCommands implements CommandExecutor {

    public CMSCommands(CyberMissions main) {
        main.getCommand("cybermissions").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        return false;

    }

}
