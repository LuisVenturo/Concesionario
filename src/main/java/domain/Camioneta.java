package domain;

public class Camioneta extends Vehiculo {
    private double capacidadCarga;
    private String traccion;
    private int numeroAsientos;

    public Camioneta(String marca, String modelo, int anio, double precio, int kilometraje, double capacidadCarga, String traccion, int numeroAsientos) {
        super(marca, modelo, anio, precio, kilometraje);
        this.capacidadCarga = capacidadCarga;
        this.traccion = traccion;
        this.numeroAsientos = numeroAsientos;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public String getTraccion() {
        return traccion;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    @Override
    public String obtenerTipoVehiculo() {
        return "CAMIONETA";
    }

    @Override
    public String obtenerDetalles() {
        return "Camioneta{" +
                "capacidadCarga=" + capacidadCarga +
                ", traccion='" + traccion + '\'' +
                ", numeroAsientos=" + numeroAsientos +
                ", marca= " + getMarca() +
                ", modelo= " + getModelo() +
                ", anio= " + getAnio() +
                ", precio= " + getPrecio() +
                ", kilometraje= " + getKilometraje() +
                '}';
    }

    public boolean esDobleTraccion() {
        if (this.traccion.equals("4x4")) {
            return true;
        }
        return false;
    }
}
