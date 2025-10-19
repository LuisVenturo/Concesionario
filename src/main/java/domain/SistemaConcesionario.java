package domain;

public class SistemaConcesionario {
    public static void main(String[] args) {
        // Creamos el concesionario
        Concesionario concesionario = new Concesionario("AutoExpress Premium");

        // Creamos algunos autos, motos y camionetas
        Auto auto1 = new Auto("Toyota", "Corolla", 2023, 25000.0, 15000, 4, "Automática", true);
        Auto auto2 = new Auto("Honda", "Civic", 2022, 22000.0, 20000, 2, "Manual", false);
        Auto auto3 = new Auto("Ford", "Focus", 2021, 21000.0, 30000, 4, "Automática", true);

        Motocicleta moto1 = new Motocicleta("Yamaha", "R3", 2023, 8000.0, 5000, 321, "Deportiva", false);
        Motocicleta moto2 = new Motocicleta("Kawasaki", "Z650", 2022, 9500.0, 7000, 650, "Urbana", true);

        Camioneta camioneta1 = new Camioneta("Chevrolet", "D-Max", 2020, 32000.0, 40000, 1.2, "4x4", 5);
        Camioneta camioneta2 = new Camioneta("Toyota", "Hilux", 2021, 35000.0, 35000, 1.5, "4x2", 5);

        // Agregamos todos los vehículos al concesionario
        concesionario.agregarVehiculo(auto1);
        concesionario.agregarVehiculo(auto2);
        concesionario.agregarVehiculo(auto3);
        concesionario.agregarVehiculo(moto1);
        concesionario.agregarVehiculo(moto2);
        concesionario.agregarVehiculo(camioneta1);
        concesionario.agregarVehiculo(camioneta2);

        // Ahora creamos unos clientes
        Cliente cliente1 = new Cliente("Carlos Pérez", "12345678", "0991234567", 30000.0);
        Cliente cliente2 = new Cliente("Lucía Gómez", "87654321", "0987654321", 15000.0);
        Cliente cliente3 = new Cliente("María Rodríguez", "11223344", "0911223344", 40000.0);

        // Registramos los clientes en el sistema
        concesionario.registrarCliente(cliente1);
        concesionario.registrarCliente(cliente2);
        concesionario.registrarCliente(cliente3);

        // Mostramos lo que hay en el inventario al inicio
        System.out.println("\n--- Inventario Inicial ---");
        concesionario.mostrarInventario();

        // Probamos algunas operaciones

        // Aplicamos un descuento solo al Toyota Corolla
        System.out.println("\n--- Aplicando descuento individual al Toyota Corolla (10%) ---");
        auto1.aplicarDescuento(10); // Descuento válido

        // Aplicamos un descuento del 5% a todos los autos
        System.out.println("\n--- Aplicando descuento masivo del 5% a todos los AUTOMÓVIL ---");
        concesionario.aplicarDescuentoMasivo("AUTOMÓVIL", 5);

        // Realizamos dos ventas que deberían funcionar
        System.out.println("\n--- Realizando ventas exitosas ---");
        concesionario.realizarVenta("12345678", "Toyota", "Corolla"); // Carlos compra el Corolla
        concesionario.realizarVenta("11223344", "Chevrolet", "D-Max"); // María compra la D-Max

        // Intentamos una venta que debe fallar porque el vehículo ya fue vendido
        System.out.println("\n--- Intentando venta fallida (vehículo ya vendido) ---");
        concesionario.realizarVenta("87654321", "Toyota", "Corolla"); // Lucía intenta comprar algo que ya no está

        // Otra venta fallida, pero ahora porque el cliente no tiene suficiente presupuesto
        System.out.println("\n--- Intentando venta fallida (cliente sin presupuesto) ---");
        concesionario.realizarVenta("87654321", "Toyota", "Hilux"); // Lucía no alcanza a pagar la Hilux

        // Mostramos los vehículos que todavía están disponibles
        System.out.println("\n--- Vehículos disponibles ---");
        concesionario.mostrarVehiculosDisponibles();

        // Mostramos la lista de clientes registrados
        System.out.println("\n--- Clientes registrados ---");
        concesionario.mostrarClientesRegistrados();

        // Generamos un reporte final
        System.out.println("\n--- Generando reporte final ---");
        concesionario.generarReporte();

        // Verificamos algunos métodos específicos de cada tipo de vehículo
        System.out.println("\n--- Verificando métodos específicos ---");

        System.out.printf("¿El %s %s es compacto? %b\n", auto2.getMarca(), auto2.getModelo(), auto2.esCompacto());
        System.out.printf("¿La %s %s es de alta cilindrada? %b\n", moto2.getMarca(), moto2.getModelo(), moto2.esAltaCilindrada());
        System.out.printf("¿La %s %s es doble tracción? %b\n", camioneta1.getMarca(), camioneta1.getModelo(), camioneta1.esDobleTraccion());

        System.out.printf("Antigüedad del %s %s: %d años\n", auto3.getMarca(), auto3.getModelo(), auto3.calcularAntiguedad());
    }
}