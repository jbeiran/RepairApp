package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private static int NEXT_ID = 0;
    private final int id;
    private final ServiceType type;
    private final String description;
    private final Device device;
    private final Employee manager;
    private Payment payment;
    private final Budget budget;
    private final List<Work> works;

    public Service(ServiceType type, String description, Device device, Employee manager, Budget budget) {
        this.id = NEXT_ID++;
        this.type = type;
        this.description = description;
        this.device = device;
        this.manager = manager;
        this.budget = budget;
        this.works = new ArrayList<>();

        device.addService(this);
        manager.addManagedService(this);
    }

    public void pay(Payment payment) {
        if (this.payment == null) {
            this.payment = payment;
        }
    }

    public void addWork(Work work) {
        if (!works.contains(work)) {
            works.add(work);
        }
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
        return manager;
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