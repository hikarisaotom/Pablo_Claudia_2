
package trabajo_equipo.Clases;

public class Locales {
    public class Tiendas {
   protected String Nombre;
    protected int Num_Piso;
   //protected ArrayList<productos> = new ArrayList();
    protected String Empleado;

    public Tiendas() {
    }

    public Tiendas(String Nombre, int Num_Piso, String Empleado) {
        this.Nombre = Nombre;
        this.Num_Piso = Num_Piso;
        this.Empleado = Empleado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNum_Piso() {
        return Num_Piso;
    }

    public void setNum_Piso(int Num_Piso) {
        this.Num_Piso = Num_Piso;
    }

    public String getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(String Empleado) {
        this.Empleado = Empleado;
    }

    @Override
    public String toString() {
        return "Tiendas{" + "Nombre=" + Nombre + ", Num_Piso=" + Num_Piso + ", Empleado=" + Empleado + '}';
    }
    }
}
