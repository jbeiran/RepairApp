package org.ulpgc.is1.model;

public class Employee {
    private static int NEXT_ID = 1;
    private final int number;
    private final String name;
    private final String surname;

    public Employee(String name, String surname) {
        this.number = NEXT_ID++;
        this.name = name;
        this.surname = surname;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Employee))
            return false;
        Employee employee = (Employee) obj;
        return number == employee.number;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number);
    }
}