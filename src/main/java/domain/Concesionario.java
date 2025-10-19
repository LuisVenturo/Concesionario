package domain;

public class Concesionario {
    private String nombreConcesionario;
    private Vehiculo[] vehiculos;
    private Cliente[] clientes;
    private int contadorVehiculos = 0;
    private int contadorClientes = 0;
    final double COMISION_VENTA = 0.03;

    public Concesionario(String nombreConcesionario) {
        this.nombreConcesionario = nombreConcesionario;
        this.vehiculos = new Vehiculo[50];
        this.clientes = new Cliente[30];
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        if (contadorVehiculos < vehiculos.length) {
            vehiculos[contadorVehiculos] = vehiculo;
//            System.out.println("Vehiculo registrado");
            contadorVehiculos++;
        } else {
            System.out.println("No se pueden agregar más vehículos,límite alcanzado.");
        }
    }

    public void registrarCliente(Cliente cliente) {
        if (contadorClientes < this.clientes.length) {
            this.clientes[contadorClientes] = cliente;
            System.out.println("Cliente registrado");
            contadorClientes++;
        } else {
            System.out.println("No se pueden agregar más clientes,límite alcanzado.");
        }
    }

    public Vehiculo buscarVehiculo(String marca, String modelo) {
        for (int i = 0; i < contadorVehiculos; i++) {
            Vehiculo v = vehiculos[i];
            if (v != null && v.getMarca().equals(marca) && v.getModelo().equals(modelo)) {
                return v;
            }
        }
        return null;
    }

    public Cliente buscarCliente(String cedula) {
        for (int i = 0; i < contadorClientes; i++) {
            Cliente c = clientes[i];
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    public void mostrarInventario() {
        System.out.println("===Vehiculos (Disponibles)===");
        for (int i = 0; i < contadorVehiculos; i++) {
            Vehiculo v = vehiculos[i];
            if (v != null && !v.isVendido()) {
                System.out.println(v.obtenerDetalles());
            }
        }

        System.out.println("\n=== Inventario de Vehículos (VENDIDOS) ===");
        for (int i = 0; i < contadorVehiculos; i++) {
            Vehiculo v = vehiculos[i];
            if (v != null && v.isVendido()) {
                System.out.println(v.obtenerDetalles());
            }
        }
    }

    public void mostrarVehiculosDisponibles() {
        for (int i = 0; i < contadorVehiculos; i++) {
            Vehiculo v = vehiculos[i];
            if (v != null && !v.isVendido()) {
                System.out.println(v.obtenerDetalles());
            }
        }
    }

    public void mostrarClientesRegistrados() {
        for (int i = 0; i < contadorClientes; i++) {
            Cliente c = clientes[i];
            System.out.println(c.toString());
        }
    }

    public void realizarVenta(String cedulaCliente, String marca, String modelo) {
        Cliente cliente = buscarCliente(cedulaCliente);
        Vehiculo vehiculo = buscarVehiculo(marca, modelo);

        if (cliente == null) {
            System.out.println("Cliente no encontrado");
            return;
        }

        if (vehiculo == null) {
            System.out.println("Vehículo no encontrado");
            return;
        }

        if (vehiculo.isVendido()) {
            System.out.println("El vehículo ya fue vendido");
            return;
        }

        if (!cliente.puedePagar(vehiculo.getPrecio())) {
            System.out.println("No tiene presupuesto suficiente");
            return;
        }

        vehiculo.marcarComoVendido();
        cliente.realizarCompra(vehiculo.getPrecio());

        System.out.printf("La comisión de la venta es: %.2f\n", COMISION_VENTA * vehiculo.getPrecio());
        System.out.println("=============================");
        System.out.println("Vehículo vendido satisfactoriamente");
        System.out.println("=============================");
        System.out.println(vehiculo.obtenerDetalles());
        System.out.println("=============================");
    }


    public void aplicarDescuentoMasivo(String tipoVehiculo, double porcentaje) {
        for (int i = 0; i < contadorVehiculos; i++) {
            Vehiculo v = vehiculos[i];
            if (v != null && !v.isVendido()) {
                if (v.obtenerTipoVehiculo().equalsIgnoreCase(tipoVehiculo)) {
                    v.aplicarDescuento(porcentaje);
                }
            }
        }

    }

    public void generarReporte() {
        System.out.println("Reporte de la venta es: ");
        System.out.println("Total de vehículos: " + contadorVehiculos);

        int totalVehiculosV = 0;
        int totalVehiculosC = 0;

        double precioMasCaro = 0;
        Vehiculo vehiculoMasCaro = null;

        double precioMasBarato = Double.MAX_VALUE;
        Vehiculo vehiculoMasBarato = null;
        double totalVentas = 0;

        for (int i = 0; i < contadorVehiculos; i++) {
            Vehiculo v = vehiculos[i];

            // Vehículo más caro
            if (v.getPrecio() > precioMasCaro) {
                precioMasCaro = v.getPrecio();
                vehiculoMasCaro = v;
            }

            // Vehículo más barato
            if (v.getPrecio() < precioMasBarato) {
                precioMasBarato = v.getPrecio();
                vehiculoMasBarato = v;
            }

            // Contadores vendidos y disponibles
            if (v.isVendido()) {
                totalVehiculosV++;
                totalVentas += v.getPrecio();
            } else {
                totalVehiculosC++;
            }
        }

        System.out.println("Total de vehículos vendidos: " + totalVehiculosV);
        System.out.println("Total de vehículos disponibles: " + totalVehiculosC);

        if (vehiculoMasCaro != null) {
            System.out.println("El vehículo más caro es:");
            System.out.println(vehiculoMasCaro.obtenerDetalles());
        }

        if (vehiculoMasBarato != null) {
            System.out.println("El vehículo más barato es:");
            System.out.println(vehiculoMasBarato.obtenerDetalles());
        }
        System.out.printf("Total de ventas realizadas: $%.2f\n", totalVentas);

    }


}
