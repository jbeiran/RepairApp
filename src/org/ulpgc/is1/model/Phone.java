package org.ulpgc.is1.model;

public class Phone {
    private final String number;

    public Phone(String number) {
        if (!isValid(number)) {
            throw new IllegalArgumentException("El número de teléfono no es válido");
        }
        this.number = number;
    }

    private boolean isValid(String number) {
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
