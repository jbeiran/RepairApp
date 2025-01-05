package org.ulpgc.is1.model;

import java.time.LocalDate;

public class Budget {
    private final LocalDate date;
    private final int amount;
    private final Employee manager;

    public Budget(LocalDate date, int amount, Employee manager) {
        if (date == null || manager == null) {
            throw new IllegalArgumentException("La fecha y el manager no pueden ser null");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }

        this.date = date;
        this.amount = amount;
        this.manager = manager;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public Employee getManager() {
        return manager;
    }
}   