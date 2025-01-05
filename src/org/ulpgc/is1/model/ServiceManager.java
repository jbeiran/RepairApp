package org.ulpgc.is1.model;

import java.time.LocalDate;
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
        for (Customer customer : customers) {
            if (customer.getPhone().getNumber().equals(phone)) {
                return customer;
            }
        }
        return null;
    }

    public void addDevice(Device device) {
        if (!devices.contains(device)) {
            devices.add(device);
        }
    }

    public Device getDevice(String serialNumber) {
        for (Device device : devices) {
            if (device.getSerialNumber().equals(serialNumber)) {
                return device;
            }
        }
        return null;
    }

    public void addTechnician(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }

    public Employee getTechnician(int number) {
        for (Employee employee : employees) {
            if (employee.getNumber() == number) {
                return employee;
            }
        }
        return null;
    }

    public void service(ServiceType type, String description, Device device,
            Budget budget) {
        new Service(type, description, device, budget);
    }

    public void payService(Service service, int amount, LocalDate date) {
        service.pay(amount, date);
    }

    public List<Service> getDeviceServiceList(Device device) {
        return device.getServices();
    }
}
