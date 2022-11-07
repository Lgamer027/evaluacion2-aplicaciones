package cl.inacap.listadecompras.MODELO;

public class Producto {
    private String nombre;
    private int cantidad;
    private String categoria;
    private boolean estado;

    public static final boolean PENDIENTE=true;
    public static final boolean COMPRADO=false;






    public Producto(String nombre, int cantidad, String categoria) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.estado=PENDIENTE;
    }





    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return categoria;
    }

    public void setCategoria(String categoria) {this.categoria = categoria;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        String comprado;
        if(estado==COMPRADO)
        {
            comprado="comprado";
        }
        else
        {
            comprado="pendiente";
        }
        return nombre + ": " + comprado;
    }
}
