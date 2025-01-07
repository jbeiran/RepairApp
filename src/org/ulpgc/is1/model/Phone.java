package org.ulpgc.is1.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {
    private String number;

    public Phone(String number) throws InvalidPhoneException {
        setNumber(number);
    }

    public boolean isValid(String number) {
        if (number == null || number.trim().isEmpty()) {
            return false;
        }
        Matcher matcher = Pattern.compile("^[6-9]\\d{8}$").matcher(number);
        return matcher.matches();
    }

    public String getNumber() {
        return number;
    }

    public Phone setNumber(String number) throws InvalidPhoneException {
        if (!isValid(number)) {
            throw new InvalidPhoneException(number);
        }
        this.number = number;
        return this;
    }

    public static class InvalidPhoneException extends RuntimeException {
        public InvalidPhoneException(String number) {
            super("El número de teléfono " + number + " es inválido.");
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        Phone otherPhone = (Phone) other;
        return this.number.equals(otherPhone.getNumber());
    }

    @Override
    public String toString() {
        return number;
    }
}
