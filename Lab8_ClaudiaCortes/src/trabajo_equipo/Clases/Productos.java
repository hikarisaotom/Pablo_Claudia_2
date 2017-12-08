package trabajo_equipo.Clases;

import java.util.ArrayList;

public class Productos {

    double precio;
    String descripcion;
    String marca;
    int descuento;
    ArrayList Productos=new ArrayList();
    

    public Productos() {
    }

    public Productos(double precio, String descripcion, String marca, int descuento) {
        this.precio = precio;
        this.descripcion = descripcion;
        this.marca = marca;
        this.descuento = descuento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "precio=" + precio + " descripcion=" + descripcion;
    }
    


    
}
