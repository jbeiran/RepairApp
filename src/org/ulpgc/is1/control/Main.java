package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;
import java.time.LocalDate;

public class Main {
    public static void init(ServiceManager manager) {
        // Crear clientes
        Customer customer1 = new Customer("Carlos", "Martínez Ruiz", new Phone("928123456"));
        Customer customer2 = new Customer("Laura", "Sánchez Díaz", new Phone("928789012"));
        manager.addCustomer(customer1);
        manager.addCustomer(customer2);

        // Crear dispositivos
        Device device1 = new Device("ABC-12345", DeviceType.Smartphone);
        Device device2 = new Device("XYZ-98765", DeviceType.Desktop);
        Device device3 = new Device("DEF-45678", DeviceType.Laptop);
        manager.addDevice(device1);
        manager.addDevice(device2);
        manager.addDevice(device3);

        // Asignar dispositivos a clientes
        customer1.addDevice(device1);
        customer1.addDevice(device2);
        customer2.addDevice(device3);

        // Crear empleados
        Employee employee1 = new Employee("Miguel", "Torres López");
        Employee employee2 = new Employee("Ana", "Ramírez Castro");
        manager.addTechnician(employee1);
        manager.addTechnician(employee2);
    }

    public static void createService(ServiceManager manager) {
        // Crear y asignar servicio
        manager.service(ServiceType.Maintenance, "Mantenimiento preventivo del equipo",
                manager.getDevice("XYZ-98765"),
                new Budget(LocalDate.of(2024, 3, 15), 150, manager.getTechnician(1)));

        // Obtener servicio y agregar trabajos
        Service service = manager.getDevice("XYZ-98765").getServices().get(0);
        service.addWork(new Work(3, "Limpieza y diagnóstico", manager.getTechnician(1)));
        service.addWork(new Work(4, "Actualización de componentes", manager.getTechnician(2)));

        // Realizar pago
        manager.payService(service, new Payment(LocalDate.of(2024, 3, 15), 150));
    }

    public static void printServiceReport(ServiceManager manager) {
        Device device = manager.getDevice("XYZ-98765");
        Customer customer = device.getOwner();

        System.out.println("║ Cliente: " + customer.getName() + " " + customer.getSurname());
        System.out.println("║ Teléfono: " + customer.getPhone());
        System.out.println("═══════════════════════════════════════════════════════\n");

        for (Service s : manager.getDeviceServiceList(device)) {
            printServiceDetails(s);
        }
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
        for (Work work : service.getWorks()) {
            System.out.println("│ * " + work.getDescription());
            System.out.println("│   Técnico: " + work.getTechnician().getName() +
                    " " + work.getTechnician().getSurname());
            System.out.println("│   Tiempo: " + work.getTimeSpent() + " horas");
            if (service.getWorks().indexOf(work) != service.getWorks().size() - 1) {
                System.out.println("│");
            }
        }
    }
}