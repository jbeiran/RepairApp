package org.ulpgc.is1.model;

public class Phone {
    private final String number;

    public Phone(String number) {
        this.number = number;
    }

    public boolean isValid() {
        return number != null && number.matches("\\d{9}");
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number;
    }
}
