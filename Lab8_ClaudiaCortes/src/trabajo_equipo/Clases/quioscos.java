
package trabajo_equipo.Clases;

import java.util.ArrayList;

public class quioscos extends Locales{
    private String Nombre_Tienda;
    Comida producto;
   private ArrayList<Productos>Productos=new ArrayList();
    //Tiendas t=new Tiendas();

    public quioscos() {
        super();
    }

    public quioscos(String Nombre_Tienda, Comida producto) {
        this.Nombre_Tienda = Nombre_Tienda;
        this.producto = producto;
    }

    public String getNombre_Tienda() {
        return Nombre_Tienda;
    }

    public void setNombre_Tienda(String Nombre_Tienda) {
        this.Nombre_Tienda = Nombre_Tienda;
    }

    public Comida getProducto() {
        return producto;
    }

    public void setProducto(Comida producto) {
        this.producto = producto;
    }

    public ArrayList<Productos> getProductos() {
        return Productos;
    }

    public void setProductos(ArrayList<Productos> Productos) {
        this.Productos = Productos;
    }
    

    @Override
    public String toString() {
        return super.toString()+ "Nombre_Tienda=" + Nombre_Tienda + " producto del dia" + producto;
    }
   
    
   
}
