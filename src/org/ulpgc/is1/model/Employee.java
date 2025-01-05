package org.ulpgc.is1.model;

public class Employee {
    private final int number;
    private String name;
    private String surname;

    public Employee(String name, String surname, int number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
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