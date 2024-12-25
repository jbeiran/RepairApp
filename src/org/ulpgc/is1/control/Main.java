package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ServiceManager manager = new ServiceManager();
        Customer customer1 = new Customer("Antonio", "Garcia González", new Phone("928112233"));
        Customer customer2 = new Customer("María", "Pérez López", new Phone("928445566"));
        manager.addCustomer(customer1);
        manager.addCustomer(customer2);

        Device device1 = new Device("1234-5678", DeviceType.Tablet);
        Device device2 = new Device("8765-4321", DeviceType.Laptop);
        Device device3 = new Device("9999-8888", DeviceType.Smartphone);

        manager.addDevice(device1);
        manager.addDevice(device2);
        manager.addDevice(device3);

        customer1.addDevice(device1);
        customer1.addDevice(device2);
        customer2.addDevice(device3);

        Employee employee1 = new Employee("Antonio", "Garcia González");
        Employee employee2 = new Employee("José", "Rodriguez Pérez");
        manager.addTechnician(employee1);
        manager.addTechnician(employee2);

        Budget budget = new Budget(LocalDate.of(2024, 12, 22), 100);
        manager.service(ServiceType.Repair, "Arreglo del portatil", device2, employee2, budget);

        Service service = device2.getServices().get(0);
        Work work1 = new Work(2, "Desmontaje");
        Work work2 = new Work(5, "Repación y montaje");
        service.addWork(work1);
        service.addWork(work2);

        Payment payment = new Payment(LocalDate.of(2024, 12, 22), 100);
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
                System.out.println("Tarea { concepto='" + w.getDescription() + 
                        "', tiempo invertido=" + w.getTimeSpent() + " }");
            }
        }
    }
}