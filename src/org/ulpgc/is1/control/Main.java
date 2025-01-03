package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ServiceManager manager = new ServiceManager();

        Customer customer1 = new Customer("Carlos", "Martínez Ruiz", new Phone("928123456"));
        Customer customer2 = new Customer("Laura", "Sánchez Díaz", new Phone("928789012"));
        manager.addCustomer(customer1);
        manager.addCustomer(customer2);

        Device device1 = new Device("ABC-12345", DeviceType.Smartphone);
        Device device2 = new Device("XYZ-98765", DeviceType.Desktop);
        Device device3 = new Device("DEF-45678", DeviceType.Laptop);

        manager.addDevice(device1);
        manager.addDevice(device2);
        manager.addDevice(device3);

        customer1.addDevice(device1);
        customer1.addDevice(device2);
        customer2.addDevice(device3);

        Employee employee1 = new Employee("Miguel", "Torres López");
        Employee employee2 = new Employee("Ana", "Ramírez Castro");
        manager.addTechnician(employee1);
        manager.addTechnician(employee2);

        Budget budget = new Budget(LocalDate.of(2024, 3, 15), 150);
        manager.service(ServiceType.Maintenance, "Mantenimiento preventivo del equipo", device2, employee1, budget);

        Service service = device2.getServices().get(0);
        Work work1 = new Work(3, "Limpieza y diagnóstico", employee1);
        Work work2 = new Work(4, "Actualización de componentes", employee2);
        service.addWork(work1);
        service.addWork(work2);

        Payment payment = new Payment(LocalDate.of(2024, 3, 15), 150);
        manager.payService(service, payment);

        System.out.println("********************************************************");
        System.out.println("Cliente " + customer1.getName() + " " + customer1.getSurname() +
                " (tlf.: " + customer1.getPhone() + ")");
        System.out.println("********************************************************\n");

        for (Service s : manager.getDeviceServiceList(device2)) {
            System.out.println("----------------------------------------");
            System.out.println("Servicio (ref. " + s.getId() + ")");
            System.out.println("----------------------------------------");

            System.out.println("*) Datos del servicio:");
            System.out.println("|- Ref.: " + s.getId());
            System.out.println("|- Descripción: " + s.getDescription());
            System.out.println("|- Tipo: " + s.getType());
            System.out.println("|- Información del pago: Pago { fecha del pago= " +
                    s.getPayment().getDate() + ", cantidad= " +
                    s.getPayment().getAmount() + " euros }");

            System.out.println("\n*) Datos del dispositivo:");
            System.out.println("|- Serial Number: " + s.getDevice().getSerialNumber());
            System.out.println("|- Tipo: " + s.getDevice().getType());

            System.out.println("\n*) Datos del presupuesto:");
            System.out.println("|- Gestionado por: " + s.getManager().getName() + " " +
                    s.getManager().getSurname());
            System.out.println("|- Fecha: " + s.getBudget().getDate());
            System.out.println("|- Total: " + s.getBudget().getAmount());

            System.out.println("\n----------------------------------------");
            System.out.println("Tareas realizadas en el servicio");
            System.out.println("----------------------------------------");

            for (Work w : s.getWorks()) {
                System.out.println("Tarea { técnico=" + w.getTechnician().getName() +
                        " " + w.getTechnician().getSurname() +
                        ", concepto='" + w.getDescription() +
                        "', tiempo invertido=" + w.getTimeSpent() + " }");
            }
        }
    }
}