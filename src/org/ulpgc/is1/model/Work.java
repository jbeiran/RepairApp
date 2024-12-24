package org.ulpgc.is1.model;

public class Work {
    private final int timeSpent;
    private final String description;
    private final Employee technician;

    public Work(int timeSpent, String description, Employee technician) {
        this.timeSpent = timeSpent;
        this.description = description;
        this.technician = technician;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public String getDescription() {
        return description;
    }

    public Employee getTechnician() {
        return technician;
    }
}