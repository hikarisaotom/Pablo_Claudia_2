
package trabajo_equipo.Clases;

import java.util.Calendar;

public class Comida extends Productos{
    private Calendar Fecha_Caucidad;

    public Comida() {
        super();
    }

    public Calendar getFecha_Caucidad() {
        return Fecha_Caucidad;
    }

    public void setFecha_Caucidad(Calendar Fecha_Caucidad) {
        this.Fecha_Caucidad = Fecha_Caucidad;
    }

    @Override
    public String toString() {
        return super.toString()+"Comida{" + "Fecha_Caucidad=" + Fecha_Caucidad + '}';
    }
    
    
}
