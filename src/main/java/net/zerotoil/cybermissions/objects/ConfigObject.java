package net.zerotoil.cybermissions.objects;

public class ConfigObject {

    // ---- fields ----

    private boolean randomMissions;
    private boolean autoStart;
    private boolean difficulty;
    private boolean duplicateMissions;


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
}
