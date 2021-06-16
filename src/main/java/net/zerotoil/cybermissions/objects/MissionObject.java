package net.zerotoil.cybermissions.objects;

import net.zerotoil.cybermissions.utilities.FileUtils;

import java.util.HashMap;

public class MissionObject {

    // ---- fields ----

    private String id;
    private String displayName;
    private String description;
    private String difficulty;
    private HashMap<String, ConditionObject> conditions;
    private HashMap<String, String> rewards;
    private String startMessage;
    private String finishMessage;


    // ---- constructors ----

    // default constructor
    public MissionObject(String id, String displayName, String description, String difficulty) {
        this.id = id;
        this.displayName = displayName;
        this.description = description;
        this.difficulty = difficulty;
        this.conditions = new HashMap<>();
        this.rewards = new HashMap<>();
        this.startMessage = FileUtils.getMissionString(this.id + ".start-message");
        this.finishMessage = FileUtils.getMissionString(this.id + ".finish-message");
    }

    public MissionObject(String id, String displayName, String description, HashMap<String, ConditionObject> conditions, HashMap<String, String> rewards) {
        this.id = id;
        this.displayName = displayName;
        this.description = description;
        this.conditions = conditions;
        this.rewards = rewards;
    }


    // ---- accessors ----

    public String getId() {
        return this.id;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public HashMap<String, ConditionObject> getConditions() {
        return this.conditions;
    }

    public HashMap<String, String> getRewards() {
        return this.rewards;
    }


    // ---- mutators ----

    public void setId(String id) {
        this.id = id;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setConditions(HashMap<String, ConditionObject> conditions) {
        this.conditions = conditions;
    }

    public void setRewards(HashMap<String, String> rewards) {
        this.rewards = rewards;
    }

    public void setStartMessage(String startMessage) {
        this.startMessage = startMessage;
    }

    public void setFinishMessage(String finishMessage) {
        this.finishMessage = finishMessage;
    }


}
