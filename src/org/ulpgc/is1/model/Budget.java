package org.ulpgc.is1.model;

import java.time.LocalDate;

public class Budget {
    private final LocalDate date;
    private final int amount;
    private final Employee manager;

    public Budget(LocalDate date, int amount, Employee manager) {
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