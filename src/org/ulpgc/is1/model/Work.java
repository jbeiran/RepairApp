package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Work {
    private int timeSpent;
    private String description;
    private List<Employee> technicians;

    public Work(int timeSpent, String description, Employee technician) {
        this.timeSpent = timeSpent;
        this.description = description;
        this.technicians = new ArrayList<>();
        if (technician != null) {
            this.technicians.add(technician);
        }
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getTechnicians() {
        return technicians;
    }

    public void setTechnicians(List<Employee> technicians) {
        this.technicians = technicians;
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
                technicians.equals(work.technicians);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeSpent, description, technicians);
    }
}