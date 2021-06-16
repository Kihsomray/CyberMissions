package net.zerotoil.cybermissions.objects;

import java.util.ArrayList;

public class DifficultyObject {

    private String difficulty;
    private ArrayList<String> missions;

    public DifficultyObject(String difficulty) {
        this.difficulty = difficulty;
    }

    public DifficultyObject(String difficulty, ArrayList<String> missions) {
        this.difficulty = difficulty;
        this.missions = missions;
    }

}
