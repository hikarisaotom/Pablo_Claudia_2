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
      public static ArrayList<String> nicks = new ArrayList();
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
             
                case "Log in Cliente":
                    if (LoginCliente(Usuario)) {
                        Menucliente();
                    }else{
                        JOptionPane.showMessageDialog(null,"Error en los datos");
                    }
                    break;
                case "Log in Empleados":
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
                Usuario.add(CrearCliente());
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
         User = JOptionPane.showInputDialog("Ingrese su UserName");  
        while (nicks.contains(User)) {
            User = JOptionPane.showInputDialog("Ingrese su User Name");  
        }
        nicks.add(User);
        Contra = JOptionPane.showInputDialog("Ingrese su Contraseña");
        Correo=JOptionPane.showInputDialog("Ingrese su Correo");
        Nombre=JOptionPane.showInputDialog("Ingrese su Nombre Completo");
        double Dinero=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de dinero que tiene disponible"));
        Id=GenerarCodigo();
        Calendar Fecha=GenerarFecha();
        Cli.setCorreo(Correo);
        Cli.setContraseña(Contra);
        Cli.setDinero(Dinero);
        Cli.setNombrecompleto(Nombre);
        Cli.setUsername(User);
        
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
       User = JOptionPane.showInputDialog("Ingrese su UserName");  
        while (nicks.contains(User)) {
            User = JOptionPane.showInputDialog("Ingrese su User Name");  
        }
        nicks.add(User);
        Contra = JOptionPane.showInputDialog("Ingrese su Contraseña");
        Correo=JOptionPane.showInputDialog("Ingrese su Correo");
        Nombre=JOptionPane.showInputDialog("Ingrese su Nombre");
        double Dinero=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de dinero que tiene disponible"));
        Id=GenerarCodigo();
        Calendar Fecha=GenerarFecha();
        EMP.setContraseña(Contra);
        ((Personas)EMP).setCorreo(Correo);
        EMP.setFehanacimiento(Fecha);
        EMP.setNombrecompleto(Nombre);
        EMP.setUsername(User);
        
        return EMP;
       
    }
 

    public static void Menucliente() {
        JOptionPane.showInputDialog("Tiendas disponibles"+Imprimir()+"\n");

    }

    public static void MenuEmpleado() {

    }

    public static boolean LoginCliente(ArrayList Personas) {
        System.out.println(Usuario);
        String Usuario = JOptionPane.showInputDialog("Ingrese su usuario.");
        String Contra = JOptionPane.showInputDialog("Ingrese su Contra.");
        boolean Acceso = false;
        for (int i = 0; i < Personas.size(); i++) {
           if (Personas.get(i) instanceof Clientes) {
                if (Usuario.equals( ((Personas) Personas.get(i)).getUsername()) && Contra.equals(((Personas) Personas.get(i)).getContraseña())) {
                    System.out.println("ENCPNTROP COINCIDENCIA");
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
                if (Usuario.equals( ((Personas) Personas.get(i)).getUsername()) && Contra.equals(((Personas) Personas.get(i)).getContraseña())) {
                    System.out.println("ENCPNTROP COINCIDENCIA");
                    Acceso = true;
                }
            }
        }
        return Acceso;
    }
    
    public static String Imprimir(){
        String S="";
        for (int i = 0; i <Tienda.size(); i++) {
            S+=i+")"+Tienda.get(i);
        }
        return S;
    }

    public static void MenuClientes() {

    }

}
