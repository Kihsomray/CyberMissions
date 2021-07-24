package net.zerotoil.cybermissions.main;

import net.zerotoil.cybermissions.CyberMissions;

public class ReloadData {

    private CyberMissions main;

    public ReloadData(CyberMissions main) {
        this.main = main;

        main.reloadCache();



    }

}
