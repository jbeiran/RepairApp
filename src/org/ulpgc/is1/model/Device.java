package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Device {
    private String serialNumber;
    private DeviceType type;
    private Customer owner = null;
    private List<Service> services = new ArrayList<>();

    public Device(String serialNumber, DeviceType type) {
        this.serialNumber = serialNumber;
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public void addService(Service service) {
        if (!services.contains(service)) {
            services.add(service);
        }
    }

    public List<Service> getServices() {
        return new ArrayList<>(services);
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Device))
            return false;
        Device device = (Device) obj;
        return getSerialNumber().equals(device.getSerialNumber());
    }

    @Override
    public int hashCode() {
        return serialNumber.hashCode();
    }
}