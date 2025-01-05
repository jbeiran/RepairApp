package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
    private String name;
    private String surname;
    private Phone phone;
    private List<Device> devices;

    public Customer(String name, String surname, Phone phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.devices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public List<Device> getDevices() {
        return new ArrayList<>(devices);
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public void addDevice(Device device) {
        if (!devices.contains(device)) {
            devices.add(device);
            device.setOwner(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Customer))
            return false;
        Customer customer = (Customer) obj;
        return phone.equals(customer.phone) &&
                name.equals(customer.name) &&
                surname.equals(customer.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phone);
    }
}