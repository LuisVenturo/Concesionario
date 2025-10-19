package domain;

public class Motocicleta extends Vehiculo {
    private int cilindrada;
    private String tipoMotocicleta;
    private boolean tieneMaletero;

    public Motocicleta(String marca, String modelo, int anio, double precio, int kilometraje, int cilindrada, String tipoMotocicleta, boolean tieneMaletero) {
        super(marca, modelo, anio, precio, kilometraje);
        this.cilindrada = cilindrada;
        this.tipoMotocicleta = tipoMotocicleta;
        this.tieneMaletero = tieneMaletero;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public String getTipoMotocicleta() {
        return tipoMotocicleta;
    }

    public boolean isTieneMaletero() {
        return tieneMaletero;
    }

    @Override
    public String obtenerTipoVehiculo() {
        return "MOTOCICLETA";
    }

    @Override
    public String obtenerDetalles() {
        return "Motocicleta{" +
                "cilindrada= " + cilindrada +
                ", tipoMotocicleta= '" + tipoMotocicleta + '\'' +
                ", tieneMaletero= " + tieneMaletero +
                ", marca= " + getMarca() +
                ", modelo= " + getModelo() +
                ", anio= " + getAnio() +
                ", precio= " + getPrecio() +
                ", kilometraje= " + getKilometraje() +
                '}';
    }

    public boolean esAltaCilindrada() {
        if (this.cilindrada>= 600) {
            return true;
        }
        return false;
    }
}
