package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private static int NEXT_ID = 1;
    private final int number;
    private final String name;
    private final String surname;
    private final List<Service> managedServices;
    private final List<Work> works;

    public Employee(String name, String surname) {
        this.number = NEXT_ID++;
        this.name = name;
        this.surname = surname;
        this.managedServices = new ArrayList<>();
        this.works = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void addManagedService(Service service) {
        if (!managedServices.contains(service)) {
            managedServices.add(service);
        }
    }

    public void addWork(Work work) {
        if (!works.contains(work)) {
            works.add(work);
        }
    }

    public List<Service> getManagedServices() {
        return new ArrayList<>(managedServices);
    }

    public List<Work> getWorks() {
        return new ArrayList<>(works);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee employee = (Employee) obj;
        return number == employee.number;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number);
    }
}