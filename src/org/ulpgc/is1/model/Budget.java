package org.ulpgc.is1.model;

import java.time.LocalDate;

public class Budget {
    private final LocalDate date;
    private final int amount;
    private final Employee manager;
    private Service service;

    public Budget(LocalDate date, int amount, Employee manager, Service service) {
        this.date = date;
        this.amount = amount;
        this.manager = manager;
        this.service = service;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}