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

    public Service(ServiceType type, String description, LocalDate date, int amount, Device device, Employee manager) {
        if (type == null || description == null || device == null || manager == null) {
            throw new IllegalArgumentException("Ningún parámetro puede ser nulo");
        }
        if (description.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }

        this.id = NEXT_ID++;
        this.type = type;
        this.description = description;
        this.device = device;
        this.payment = null;
        this.budget = new Budget(date, amount, manager);
        this.works = new ArrayList<>();
        device.addService(this);
    }

    public void pay(int amount, LocalDate date) {
        if (this.payment == null) {
            this.payment = new Payment(date, amount);
        }
    }

    public void addWork(int timeSpent, String description, Employee technician) {
        if (description == null || technician == null) {
            throw new IllegalArgumentException("La descripción y el técnico no pueden ser nulos");
        }
        if (timeSpent <= 0) {
            throw new IllegalArgumentException("El tiempo debe ser positivo");
        }
        Work work = new Work(timeSpent, description, technician);
        works.add(work);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Employee getManager() {
        return budget.getManager();
    }

    public void setManager(Employee manager) {
        this.budget.setManager(manager);
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public List<Work> getWorks() {
        return new ArrayList<>(works);
    }
}