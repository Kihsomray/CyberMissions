package net.zerotoil.cybermissions.objects;

import java.util.ArrayList;
import java.util.List;

public class ConditionObject {

    private String condition;
    private double amount;
    private List<String> type;

    public ConditionObject(String condition, double amount, List<String> type) {
        this.condition = condition;
        this.amount = amount;
        this.type = type;
    }

    public void setType(ArrayList<String> type) {
        this.type = type;
    }
}
