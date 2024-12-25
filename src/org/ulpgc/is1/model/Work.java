package org.ulpgc.is1.model;

public class Work {
    private final int timeSpent;
    private final String description;

    public Work(int timeSpent, String description) {
        this.timeSpent = timeSpent;
        this.description = description;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public String getDescription() {
        return description;
    }
}