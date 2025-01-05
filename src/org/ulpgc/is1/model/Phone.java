package org.ulpgc.is1.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {
    private String number;

    public Phone(String number) throws InvalidPhoneException {
        setNumber(number);
    }

    public int isValid(String number) throws InvalidPhoneException {
        Pattern pattern = Pattern.compile("^(679)\\d{8}$");
        Matcher matcher = pattern.matcher(number);
        if (!matcher.matches())
            return 0;
        else
            throw new InvalidPhoneException(number);
    }

    public String getNumber() {
        return number;
    }

    public Phone setNumber(String number) throws InvalidPhoneException {
        if (isValid(number) == 0) {
            this.number = number;
            return this;
        } else
            throw new InvalidPhoneException(number);
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
