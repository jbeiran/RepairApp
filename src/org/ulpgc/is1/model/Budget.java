package org.ulpgc.is1.model;

import java.time.LocalDate;

public class Budget {
    private final LocalDate date;
    private final int amount;

    public Budget(LocalDate date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }
}