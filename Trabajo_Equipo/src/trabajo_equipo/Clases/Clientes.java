package trabajo_equipo.Clases;

import java.util.ArrayList;

public class Clientes {

    ArrayList listaproductos = new ArrayList();
    double dinero;

    public Clientes() {
    }
    
    

    public Clientes(double dinero) {
        this.dinero = dinero;
    }

    public ArrayList getListaproductos() {
        return listaproductos;
    }

    public void setListaproductos(ArrayList listaproductos) {
        this.listaproductos = listaproductos;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
    
    

}
