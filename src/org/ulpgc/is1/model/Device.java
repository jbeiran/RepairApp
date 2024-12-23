package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Device {
    private final String serialNumber;
    private final DeviceType type;
    private Customer owner;
    private final List<Service> services;

    public Device(String serialNumber, DeviceType type) {
        this.serialNumber = serialNumber;
        this.type = type;
        this.services = new ArrayList<>();
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public DeviceType getType() {
        return type;
    }

    public Customer getOwner() {
        return owner;
    }

    public void addService(Service service) {
        if (!services.contains(service)) {
            services.add(service);
        }
    }

    public List<Service> getServices() {
        return new ArrayList<>(services);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Device)) return false;
        Device device = (Device) obj;
        return serialNumber.equals(device.serialNumber);
    }

    @Override
    public int hashCode() {
        return serialNumber.hashCode();
    }
}