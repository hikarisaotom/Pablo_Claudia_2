
package trabajo_equipo.Clases;

public class Juguetes extends Productos{
    private String Tipo;

    public Juguetes(String Tipo) {
        this.Tipo = Tipo;
    }

    public Juguetes() {
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    @Override
    public String toString() {
        return super.toString()+"Juguetes{" + "Tipo=" + Tipo + '}';
    }
    
    
   
}
