package domain;

import java.time.LocalDate;

public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    private double precio;
    private boolean vendido = false;
    private int kilometraje;

    public Vehiculo(String marca, String modelo, int anio, double precio, int kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
        this.kilometraje = kilometraje;
    }

    public void marcarComoVendido() {
        this.vendido = true;
        System.out.println("✓ Vehículo vendido de la marca " + this.marca + " del año " + this.anio);
    }

    public void aplicarDescuento(double porcentaje) {
        if (porcentaje >= 0 && porcentaje <= 50) {
            this.precio = this.precio - (this.precio * (porcentaje / 100.0));
            System.out.printf("Descuento aplicado: %.2f%% - Nuevo precio: $%.2f\n", porcentaje, this.precio);
        } else {
            System.out.println("Porcentaje inválido. Debe estar entre 0% y 50%.");
        }
    }


    public abstract String obtenerTipoVehiculo();
    public abstract String obtenerDetalles();

    public int calcularAntiguedad() {
        return LocalDate.now().getYear() - this.anio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isVendido() {
        return vendido;
    }

    public int getKilometraje() {
        return kilometraje;
    }
}
