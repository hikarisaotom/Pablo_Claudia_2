package trabajo_equipo.Clases;

public class Tiendas extends Locales{
   private int Tamano; //Validado.

    public Tiendas() {
        super();
    }

    public Tiendas(int Tamano) {
        this.Tamano = Tamano;
    }

    public int getTamano() {
        return Tamano;
    }

    public void setTamano(int Tamano) {
        if (Tamano<=18 && Tamano>0) {
             this.Tamano = Tamano;
        }
    }

    @Override
    public String toString() {
        return super.toString()+"Tiendas{" + "Tamano=" + Tamano + '}';
    }
    

    
}
