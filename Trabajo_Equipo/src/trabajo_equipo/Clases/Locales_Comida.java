
package trabajo_equipo.Clases;

import java.util.ArrayList;

public class Locales_Comida extends Locales {
    private Productos Producto_Dia;
    ArrayList ListaEmpleados<Empleados>=new ArrayList();

    public Locales_Comida() {
        super();
    }

    public Locales_Comida(Productos Producto_Dia) {
        this.Producto_Dia = Producto_Dia;
    }

    public Productos getProducto_Dia() {
        return Producto_Dia;
    }

    public void setProducto_Dia(Productos Producto_Dia) {
        this.Producto_Dia = Producto_Dia;
    }

    
    
    
}
