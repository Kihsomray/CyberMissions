package net.zerotoil.cybermissions.cache;

import net.zerotoil.cybermissions.CyberMissions;
import net.zerotoil.cybermissions.objects.PlayerObject;

import java.util.HashMap;

public class PlayerCache {

    private HashMap<String, HashMap<String, PlayerObject>> playerData = new HashMap<>();
    private CyberMissions main;

    public PlayerCache(CyberMissions main) {
        this.main = main;



    }

}
