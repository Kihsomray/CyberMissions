package net.zerotoil.cybermissions.objects;

public class ConfigObject {

    // ---- fields ----

    private boolean randomMissions;
    private boolean autoStart;
    private boolean difficulty;
    private boolean duplicateMissions;
    private boolean perPlayer;
    private int maxMissions;



    // ---- constructors ----

    public ConfigObject() {

    }


    // ---- accessors -----

    public boolean isRandomMissions() {
        return this.randomMissions;
    }

    public boolean isAutoStart() {
        return this.autoStart;
    }

    public boolean isDifficulty() {
        return this.difficulty;
    }

    public boolean isDuplicateMissions() {
        return this.duplicateMissions;
    }

    public boolean isPerPlayer() {
        return this.perPlayer;
    }

    public int getMaxMissions() {
        return this.maxMissions;
    }

    // ---- mutators ----

    public void setRandomMissions(boolean randomMissions) {
        this.randomMissions = randomMissions;
    }

    public void setAutoStart(boolean autoStart) {
        this.autoStart = autoStart;
    }

    public void setDifficulty(boolean difficulty) {
        this.difficulty = difficulty;
    }

    public void setDuplicateMissions(boolean duplicateMissions) {
        this.duplicateMissions = duplicateMissions;
    }

    public void setPerPlayer(boolean perPlayer) {
        this.perPlayer = perPlayer;
    }

    public void setMaxMissions (int maxMissions) {
        this.maxMissions = maxMissions;
    }
}
