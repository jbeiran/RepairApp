package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;
import java.time.LocalDate;

public class Main {
    public static void init(ServiceManager manager) {
        // Crear clientes (pt. 1)
        Customer customer1 = new Customer("Carlos", "Martínez Ruiz", "928123456");
        Customer customer2 = new Customer("Laura", "Sánchez Díaz", "928789012");
        manager.addCustomer(customer1);
        manager.addCustomer(customer2);

        // Crear dispositivos (pt. 2)
        Device device1 = new Device("ABC-12345", DeviceType.Smartphone);
        Device device2 = new Device("XYZ-98765", DeviceType.Desktop);
        Device device3 = new Device("DEF-45678", DeviceType.Laptop);
        manager.addDevice(device1);
        manager.addDevice(device2);
        manager.addDevice(device3);

        // Asignar dispositivos a clientes (pt. 2)
        customer1.addDevice(device1);
        customer1.addDevice(device2);
        customer2.addDevice(device3);

        // Crear empleados (pt. 3)
        Employee employee1 = new Employee("Miguel", "Torres López", 1);
        Employee employee2 = new Employee("Ana", "Ramírez Castro", 2);
        manager.addTechnician(employee1);
        manager.addTechnician(employee2);
    }

    public static void createService(ServiceManager manager) {
        // Crear y asignar servicio (pt. 4)
        manager.service(
                ServiceType.Repair,
                "Mantenimiento preventivo del equipo",
                manager.getDevice("XYZ-98765"),
                manager.getTechnician(2),
                150,
                LocalDate.of(2024, 3, 15));

        // Obtener servicio y agregar trabajos
        manager.getDevice("XYZ-98765").getServices().get(0)
                .addWork(3, "Limpieza y diagnóstico", manager.getTechnician(1));
        manager.getDevice("XYZ-98765").getServices().get(0)
                .addWork(4, "Actualización de componentes", manager.getTechnician(2));

        // Realizar pago
        manager.getDevice("XYZ-98765").getServices().get(0).pay(150, LocalDate.of(2024, 3, 15));
    }

    public static void printServiceReport(ServiceManager manager) {
        Device device = manager.getDevice("XYZ-98765");
        Customer customer = device.getOwner();

        System.out.println("║ Cliente: " + customer.getName() + " " + customer.getSurname());
        System.out.println("║ Teléfono: " + customer.getPhone());
        System.out.println("═══════════════════════════════════════════════════════\n");

        manager.getDeviceServiceList(device.getSerialNumber()).forEach(s -> printServiceDetails(s));
    }

    private static void printServiceDetails(Service service) {
        System.out.println("┌──────────────────────────────────────────────────");
        System.out.println("│ SERVICIO #" + service.getId());
        System.out.println("├──────────────────────────────────────────────────");

        // Información del servicio
        printServiceInfo(service);

        // Información del dispositivo
        printDeviceInfo(service.getDevice());

        // Información del presupuesto
        printBudgetInfo(service);

        // Tareas realizadas
        printWorkInfo(service);

        System.out.println("└──────────────────────────────────────────────────\n");
    }

    public static void main(String[] args) {
        ServiceManager manager = new ServiceManager();

        init(manager);
        createService(manager);
        printServiceReport(manager);
    }

    // Métodos auxiliares para imprimir información
    private static void printServiceInfo(Service service) {
        System.out.println("│ INFORMACIÓN DEL SERVICIO");
        System.out.println("│ - Referencia: " + service.getId());
        System.out.println("│ - Descripción: " + service.getDescription());
        System.out.println("│ - Tipo: " + service.getType());
        System.out.println("│ - Pago: " + service.getPayment().getAmount() +
                " (" + service.getPayment().getDate() + ")");
        System.out.println("│");
    }

    private static void printDeviceInfo(Device device) {
        System.out.println("│ INFORMACIÓN DEL DISPOSITIVO");
        System.out.println("│ - S/N: " + device.getSerialNumber());
        System.out.println("│ - Tipo: " + device.getType());
        System.out.println("│");
    }

    private static void printBudgetInfo(Service service) {
        System.out.println("│ INFORMACIÓN DEL PRESUPUESTO");
        System.out.println("│ - Técnico: " + service.getManager().getName() +
                " " + service.getManager().getSurname());
        System.out.println("│ - Fecha: " + service.getBudget().getDate());
        System.out.println("│ - Importe: " + service.getBudget().getAmount());
        System.out.println("│");
    }

    private static void printWorkInfo(Service service) {
        System.out.println("│ TAREAS REALIZADAS");
        if (service.getWorks().isEmpty()) {
            System.out.println("│ No hay tareas registradas");
            return;
        }

        service.getWorks().forEach(work -> {
            System.out.println("│ * " + work.getDescription());
            work.getTechnicians().forEach(technician -> {
                System.out.printf("│   Técnico: %s %s%n",
                        technician.getName(),
                        technician.getSurname());
            });
            System.out.printf("│   Tiempo: %d horas%n", work.getTimeSpent());
            System.out.println("│");
        });
    }
}