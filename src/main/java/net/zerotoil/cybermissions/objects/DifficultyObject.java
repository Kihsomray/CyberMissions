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

    public String getDifficulty() {
        return difficulty;
    }
    public ArrayList<String> getMissions() {
        return missions;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public void setMissions(ArrayList<String> missions) {
        this.missions = missions;
    }

    public void addMission(String missionID) {
        missions.add(missionID);
    }
}
