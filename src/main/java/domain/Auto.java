package domain;

public class Auto extends Vehiculo {

    private int numeroPuertas;
    private String tipoTransmision;
    private boolean tieneAireAcondicionado;

    public Auto(String marca, String modelo, int anio, double precio, int kilometraje, int numeroPuertas, String tipoTransmision, boolean tieneAireAcondicionado) {
        super(marca, modelo, anio, precio, kilometraje);
        this.numeroPuertas = numeroPuertas;
        this.tipoTransmision = tipoTransmision;
        this.tieneAireAcondicionado = tieneAireAcondicionado;
    }

    @Override
    public String obtenerTipoVehiculo() {
        return "AUTOMÓVIL";
    }

    @Override
    public String obtenerDetalles() {
        return "Auto{" +
                "numeroPuertas= " + numeroPuertas +
                ", tipoTransmision= '" + tipoTransmision + '\'' +
                ", tieneAireAcondicionado= " + tieneAireAcondicionado +
                ", modelo= " + this.getModelo() +
                ", anio= " + this.getAnio() +
                ", precio= " + this.getPrecio() +
                ", kilometraje= " + this.getKilometraje() +
                ", marca= " + this.getMarca() +
                ", estado= " + isVendido() +
                '}';
    }

    public boolean esCompacto() {
        if (numeroPuertas >= 2 && numeroPuertas <= 3) {
            return true;
        }
        return false;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public String getTipoTransmision() {
        return tipoTransmision;
    }

    public boolean isTieneAireAcondicionado() {
        return tieneAireAcondicionado;
    }
}
