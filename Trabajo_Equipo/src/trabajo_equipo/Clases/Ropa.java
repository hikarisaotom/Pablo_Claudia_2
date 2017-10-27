package trabajo_equipo.Clases;

public class Ropa extends Productos{
   String talla;
   String genero;

    public Ropa() {
        super();
    }

    public Ropa(String talla, String genero) {
        this.talla = talla;
        this.genero = genero;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return super.toString()+"Ropa{" + "talla=" + talla + ", genero=" + genero + '}';
    }
   
}
