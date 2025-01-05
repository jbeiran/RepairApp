package org.ulpgc.is1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private static int NEXT_ID = 0;
    private int id;
    private ServiceType type;
    private String description;
    private Device device;
    private Payment payment;
    private Budget budget;
    private final List<Work> works;

    public Service(ServiceType type, String description, Device device, Budget budget) {
        this.id = NEXT_ID++;
        this.type = type;
        this.description = description;
        this.device = device;
        this.budget = budget;
        this.works = new ArrayList<>();
        device.addService(this);
    }

    public void pay(int amount, LocalDate date) {
        if (this.payment == null) {
            this.payment = new Payment(date, amount);
        }
    }

    public void addWork(Work work) {
        if (work == null) {
            throw new IllegalArgumentException("El trabajo no puede ser nulo");
        }
        works.add(work);
    }

    public int getId() {
        return id;
    }

    public ServiceType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Device getDevice() {
        return device;
    }

    public Employee getManager() {
        return budget.getManager();
    }

    public Payment getPayment() {
        return payment;
    }

    public Budget getBudget() {
        return budget;
    }

    public List<Work> getWorks() {
        return new ArrayList<>(works);
    }
}