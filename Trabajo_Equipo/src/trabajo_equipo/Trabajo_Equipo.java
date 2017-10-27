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
    public static ArrayList<Empleados> Empleado = new ArrayList();
    public static ArrayList<Locales> Tienda = new ArrayList();
    public static ArrayList<Productos> Producto = new ArrayList();
    public static ArrayList<String> Codigos = new ArrayList();
      public static ArrayList<String> nicks = new ArrayList();
      public static String Socio="Claudia";
      public static String ContraSocio="123456";
      
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
                case "Log in socio":
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
                    String[] Opciones = {"Cliente"};

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
          /*  case "Empleado":
              
                break;*/
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
    public static void CrearProducto(){
        
        double precio= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
        
        
    }
    public static void AgregarEmpleados(){
        int Pos=Integer.parseInt(JOptionPane.showInputDialog("Lista de tiendas disponibles hasta el momento: \n"+Imprimir()));
     if(Tienda.get(Pos).getEmple().size()==4&&Tienda.get(Pos) instanceof Locales_Comida){
         JOptionPane.showMessageDialog(null,"Numero maximo de empleados encontrado");
     }else{
          int Pos2=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el empleado a agregar: \n"+ImprimirE()));
      Tienda.get(Pos).setEmple(Empleado.get(Pos2));
     }

    }
    
    public static void CrearLocal(){
    Tiendas T= new Tiendas();
    quioscos Q= new quioscos();
    Locales_Comida LC= new Locales_Comida();
    Locales L= new Locales();
        String Nombre="";
        int Piso=-2;
        Nombre=JOptionPane.showInputDialog("el Nombre de la cliente");
        String Opcion="";
         String[] Opciones = {"Tienda", "Quiosco", "Local Comida"};
            Opcion = (String) JOptionPane.showInputDialog(null,
                    "Tipo de tienda que desea crear", //Mensaje
                    "                                  Tipo_Tienda",//TITULO
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    Opciones,
                    Opciones[0]);
            switch (Opcion){
                case "Tienda":
                 T.setNombre(Nombre);
                 T.setNum_Piso(Piso);
                 Tienda.add(T);
                    break;
                case "Quiosco":
                   Q.setNombre(Nombre);
                   Q.setNum_Piso(Piso);
                   Tienda.add(Q);
                    break;
                case "Local Comida":
                      Q.setNombre(Nombre);
                   Q.setNum_Piso(Piso);
                   Tienda.add(Q);
                    break;
            }
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
<<<<<<< HEAD
        EMP.setCorreo(Correo);
        ((Personas)EMP).setFehanacimiento(Fecha);
=======
        ((Personas)EMP).setCorreo(Correo);
        EMP.setFehanacimiento(Fecha);
>>>>>>> 531a0ac73f71f3fc7a7fe83be342d0e5f18114b2
        EMP.setNombrecompleto(Nombre);
        EMP.setUsername(User);
        return EMP;
    }
    public static void Menucliente() {
        int pos=Integer.parseInt(JOptionPane.showInputDialog("Tiendas disponibles"+Imprimir()+"\n Ingrese a cual desea Entrar.\n"));
   
    }

    public static void MenuEmpleado() {
        String Opcion="";
         String[] Opciones = {"Crear Tienda", "Agregar Empleados a las tienda", "Agregar Productos a la tienda","Modificar"};
            Opcion = (String) JOptionPane.showInputDialog(null,
                    "Tipo de tienda que desea crear", //Mensaje
                    "                                  Tipo_Tienda",//TITULO
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    Opciones,
                    Opciones[0]);
        switch (Opcion) {
            case "Crear Tienda":
                 CrearLocal();
                break;
                  case "Agregar Empleados a las tienda":
                      AgregarEmpleados();
                break;
                  case "Agregar Productos a la tienda":
                      CrearProducto();
                break;
                  case "Modificar":
                        Empleado.add(CrearEmpleado());
                      break;
        }
               
                
               
        

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
     public static String ImprimirE(){
        String S="";
        for (int i = 0; i <Empleado.size(); i++) {
            S+=i+")"+Empleado.get(i);
        }
        return S;
    }
     public static String ImprimirP(){
          String S="";
        for (int i = 0; i <Producto.size(); i++) {
            S+=i+")"+Producto.get(i);
        }
        return S;
     }

    public static void MenuClientes() {

    }
    

}
