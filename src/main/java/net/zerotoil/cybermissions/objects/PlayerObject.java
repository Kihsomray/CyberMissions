package net.zerotoil.cybermissions.objects;

public class PlayerObject {

    // ---- Fields ----

    private double amount;         // progress of the mission
    private boolean completed;  // whether or not the mission is completed

    // ---- Constructors ----

    public PlayerObject() {
        this.amount = 0;
        this.completed = false;
    }

    public PlayerObject(int amount, boolean completed) {
        this.amount = amount;
        this.completed = completed;
    }


    // ---- Accessors ----

    public double getAmount() {
        return this.amount;
    }

    public boolean isCompleted() {
        return this.completed;
    }


    // ---- Mutators ----

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void addAmount(int amount) {
        this.amount = this.amount + amount;
    }

}
