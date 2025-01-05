package org.ulpgc.is1.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Work))
            return false;
        Work work = (Work) obj;
        return timeSpent == work.timeSpent &&
                description.equals(work.description) &&
                technician.equals(work.technician);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeSpent, description, technician);
    }
}