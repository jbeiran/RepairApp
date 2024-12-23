package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class ServiceManager {
    private final List<Customer> customers;
    private final List<Device> devices;
    private final List<Employee> employees;

    public ServiceManager() {
        this.customers = new ArrayList<>();
        this.devices = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
    }

    public Customer getCustomer(String phone) {
        return customers.stream()
                .filter(c -> c.getPhone().getNumber().equals(phone))
                .findFirst()
                .orElse(null);
    }

    public void addDevice(Device device) {
        if (!devices.contains(device)) {
            devices.add(device);
        }
    }

    public Device getDevice(String serialNumber) {
        return devices.stream()
                .filter(d -> d.getSerialNumber().equals(serialNumber))
                .findFirst()
                .orElse(null);
    }

    public void addTechnician(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }

    public Employee getTechnician(int number) {
        return employees.stream()
                .filter(e -> e.getNumber() == number)
                .findFirst()
                .orElse(null);
    }

    public void service(ServiceType type, String description, Device device,
                        Employee manager, Budget budget) {
        new Service(type, description, device, manager, budget);
    }

    public void payService(Service service, Payment payment) {
        service.pay(payment);
    }

    public List<Service> getDeviceServiceList(Device device) {
        return device.getServices();
    }
}
