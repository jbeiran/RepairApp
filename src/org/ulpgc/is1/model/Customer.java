package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final String surname;
    private final Phone phone;
    private final List<Device> devices;

    public Customer(String name, String surname, Phone phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.devices = new ArrayList<>();
    }

    public void addDevice(Device device) {
        if (!devices.contains(device)) {
            devices.add(device);
            device.setOwner(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Phone getPhone() {
        return phone;
    }

    public List<Device> getDevices() {
        return new ArrayList<>(devices);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Customer)) return false;
        Customer customer = (Customer) obj;
        return phone.getNumber().equals(customer.phone.getNumber());
    }
}