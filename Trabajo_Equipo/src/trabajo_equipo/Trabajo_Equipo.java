package trabajo_equipo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.swing.JOptionPane;
import trabajo_equipo.Clases.*;

public class Trabajo_Equipo {
   public static Random Ran = new Random();
    public static ArrayList<Personas> Usuario = new ArrayList();
    public static ArrayList<Tiendas> Tienda = new ArrayList();
    public static ArrayList<Productos> Producto = new ArrayList();
    public static ArrayList<String> Codigos = new ArrayList();
    public static void main(String[] args) {
        String Opcion = "";
        while (Opcion != "Salir") {
            String[] Opciones = {"Crear Usuario", "Log in Cliente", "Log in Empleados", "Salir"};
            Opcion = (String) JOptionPane.showInputDialog(null,
                    "Seleccione una opción", //Mensaje
                    "                                  MENU",//TITULO
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    Opciones,
                    Opciones[0]);
            switch (Opcion) {
                case "Cliente":
                    if (LoginCliente(Usuario)) {
                        Menucliente();
                    }else{
                        JOptionPane.showMessageDialog(null,"Error en los datos");
                    }
                    break;
                case "Empleados":
                    if (LoginEmpleado(Usuario)) {
                        MenuEmpleado();
                   }else{
                        JOptionPane.showMessageDialog(null,"Error en los datos");
                    }
                    break;
                case "Crear Usuario":
                        CrearUsuario();
                    break;
            }
        }
    }
    
    public static void  CrearUsuario(){
        String Opcion;
                    String[] Opciones = {"Cliente", "Empleado"};

         Opcion = (String) JOptionPane.showInputDialog(null,
                    "Seleccione una opción", //Mensaje
                    "                                  MENU",//TITULO
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    Opciones,
                    Opciones[0]);
         switch (Opcion) {
            case "Cliente":
                
                break;
            case "Empleado":
               Usuario.add(CrearEmpleado());
                break;
        }
    }
    public static Clientes CrearCliente() {
        Clientes Cli= new Clientes();
        boolean Bandera = false;
        String User="";
        String Contra="";
        String Correo="";
        String Id="";
        String Nombre="";
        while (true) {
            if (Bandera) {
                break;
            }
            User = JOptionPane.showInputDialog("Ingrese su User Name");
            for (int i = 0; i < Usuario.size(); i++) {
                if (User.equals(Usuario.get(i).getUsername())) {
                    Bandera = true;
                }
            }
        }
        Contra = JOptionPane.showInputDialog("Ingrese su Contraseña");
        Correo=JOptionPane.showInputDialog("Ingrese su Correo");
        Nombre=JOptionPane.showInputDialog("Ingrese su Nombre");
        double Dinero=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de dinero que tiene disponible"));
        Id=GenerarCodigo();
        Calendar Fecha=GenerarFecha();
        Cli.setCorreo(Correo);
        Cli.setContraseña(Contra);
        Cli.setDinero(Dinero);
        
        return Cli;
    }

     public static Calendar GenerarFecha(){
        Calendar Calendario = new GregorianCalendar(Ran.nextInt(10)+2018,0,Ran.nextInt(20));
        return Calendario;
    }
  
      public static String GenerarCodigo() {
        String Codigo = "";
        boolean Bandera = true;
        for (int i = 0; i < 7; i++) {
            if (Bandera) {
                Codigo += "" + Ran.nextInt(256);
                Bandera = !Bandera;
            } else {
                Codigo += "" + (char) Ran.nextInt(256);
                Bandera = !Bandera;
            }
        }
        while (Codigos.contains(Codigo)) {
            Codigo = "";
            for (int i = 0; i < 7; i++) {
                if (Bandera) {
                    Codigo += "" + Ran.nextInt(256);
                    Bandera = !Bandera;
                } else {
                    Codigo += "" + (char) Ran.nextInt(256);
                    Bandera = !Bandera;
                }
            }
        }
        Codigos.add(Codigo);
        return Codigo;
    }
    public static Empleados CrearEmpleado() {
        
        Empleados EMP= new Empleados();
        boolean Bandera = false;
        String User="";
        String Contra="";
        String Correo="";
        String Id="";
        String Nombre="";
        while (true) {
            if (Bandera) {
                break;
            }
            User = JOptionPane.showInputDialog("Ingrese su User Name");
            for (int i = 0; i < Usuario.size(); i++) {
                if (User.equals(Usuario.get(i).getUsername())) {
                    Bandera = true;
                }
            }
        }
        Contra = JOptionPane.showInputDialog("Ingrese su Contraseña");
        Correo=JOptionPane.showInputDialog("Ingrese su Correo");
        Nombre=JOptionPane.showInputDialog("Ingrese su Nombre");
        double Dinero=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de dinero que tiene disponible"));
        Id=GenerarCodigo();
        Calendar Fecha=GenerarFecha();
        EMP.setContraseña(Contra);
        EMP.setCorreo(Correo);
        ((Personas)EMP).setFehanacimiento(Fecha);
        EMP.setNombrecompleto(Nombre);
        EMP.setUsername(User);
        
        return EMP;
       
    }
 

    public static void Menucliente() {

    }

    public static void MenuEmpleado() {

    }

    public static boolean LoginCliente(ArrayList Personas) {
        String Usuario = JOptionPane.showInputDialog("Ingrese su usuario.");
        String Contra = JOptionPane.showInputDialog("Ingrese su Contra.");
        boolean Acceso = false;
        for (int i = 0; i < Personas.size(); i++) {
            if (Personas.get(i) instanceof Clientes) {
                if (Usuario == ((Personas) Personas.get(i)).getUsername() && Contra == ((Personas) Personas.get(i)).getContraseña()) {
                    Acceso = true;
                }
            }
        }
        return Acceso;
    }

    public static boolean LoginEmpleado(ArrayList Personas) {

        String Usuario = JOptionPane.showInputDialog("Ingrese su usuario.");
        String Contra = JOptionPane.showInputDialog("Ingrese su Contra.");
        boolean Acceso = false;
        for (int i = 0; i < Personas.size(); i++) {
            if (Personas.get(i) instanceof Empleados) {
                if (Usuario == ((Personas) Personas.get(i)).getUsername() && Contra == ((Personas) Personas.get(i)).getContraseña()) {
                    Acceso = true;
                }
            }
        }
        return Acceso;
    }

    public static void MenuClientes() {

    }

}
