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

    public boolean addCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        if (!customers.contains(customer)) {
            customers.add(customer);
            return true;
        }
        return false;
    }

    public Customer getCustomer(String phone) {
        for (Customer customer : customers) {
            if (customer.getPhone().getNumber().equals(phone)) {
                return customer;
            }
        }
        return null;
    }

    public boolean addDevice(Device device) {
        if (device == null) {
            throw new IllegalArgumentException("El dispositivo no puede ser nulo");
        }
        if (!devices.contains(device)) {
            devices.add(device);
            return true;
        }
        return false;
    }

    public Device getDevice(String serialNumber) {
        for (Device device : devices) {
            if (device.getSerialNumber().equals(serialNumber)) {
                return device;
            }
        }
        return null;
    }

    public boolean addTechnician(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        if (!employees.contains(employee)) {
            employees.add(employee);
            return true;
        }
        return false;
    }

    public Employee getTechnician(int number) {
        for (Employee employee : employees) {
            if (employee.getNumber() == number) {
                return employee;
            }
        }
        return null;
    }

    public Service service(ServiceType type, String description, Device device,
            Employee manager, int amount, LocalDate date) {
        if (type == null || description == null || device == null || manager == null) {
            throw new IllegalArgumentException("Ningún parámetro puede ser nulo");
        }

        Budget budget = new Budget(date, amount, manager);
        Service service = new Service(type, description, device, budget);
        return service;
    }

    public boolean payService(Service service, int amount, LocalDate date) {
        if (service == null || date == null) {
            throw new IllegalArgumentException("El servicio y la fecha no pueden ser nulos");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }

        try {
            service.pay(amount, date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Service> getDeviceServiceList(String serialNumber) {
        Device device = getDevice(serialNumber);
        if (device == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(device.getServices());
    }
}
