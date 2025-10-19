package domain;

public class Cliente {
    private String nombre;
    private String cedula;
    private String telefono;
    private double presupuesto;
    private int vehiculosComprados = 0;
    private static int totalClientes = 0;

    public Cliente(String nombre, String cedula, String telefono, double presupuesto) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.presupuesto = presupuesto;

        totalClientes++;
    }

    public boolean puedePagar(double monto) {
        return this.presupuesto >= monto;
    }

    public void realizarCompra(double monto) {
        if (puedePagar(monto)) {
            this.presupuesto -= monto;
            this.vehiculosComprados++;
            System.out.printf("Compra realizada por %s a un monto de $%.2f\n", nombre, monto);
        } else {
            System.out.println("Compra fallida: presupuesto insuficiente.");
        }
    }

    public void agregarPresupuesto(double monto) {
        this.presupuesto = this.presupuesto + monto;
        System.out.println("Nuestro presupuesto actual es: " + presupuesto);
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public int getVehiculosComprados() {
        return vehiculosComprados;
    }

    public static int getTotalClientes() {
        return totalClientes;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", telefono='" + telefono + '\'' +
                ", presupuesto=" + presupuesto +
                ", vehiculosComprados=" + vehiculosComprados +
                '}';
    }
}
