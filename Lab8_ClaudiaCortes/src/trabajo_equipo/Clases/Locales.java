package trabajo_equipo.Clases;

import java.util.ArrayList;

public class Locales {


        protected String Nombre;
        protected int Num_Piso;
        protected ArrayList<Productos> Produc = new ArrayList();
         protected ArrayList<Empleados> Emple = new ArrayList();
        protected Empleados Empleado;
        ArrayList <Productos> Facturados =new ArrayList();

        public Locales() {
        }

    public ArrayList<Productos> getFacturados() {
        return Facturados;
    }

    public void setFacturados(ArrayList<Productos> Facturados) {
        this.Facturados = Facturados;
    }

    public ArrayList<Productos> getProduc() {
        return Produc;
    }

    public void setProduc(ArrayList<Productos> Produc) {
        this.Produc = Produc;
    }

    public ArrayList<Empleados> getEmple() {
        return Emple;
    }

    public void setEmple(Empleados Emple) {
        
    }

        public Locales(String Nombre, int Num_Piso, Empleados Empleado) {
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

        public Empleados getEmpleado() {
            return Empleado;
        }

        public void setEmpleado(Empleados Empleado) {
            this.Empleado = Empleado;
        }

    @Override
    public String toString() {
        return Nombre +" Empleado de turno: " + Empleado;
    }

       
    }

