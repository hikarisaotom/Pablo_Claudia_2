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
    public static String Socio = "clau";
    public static String ContraSocio = "123";
    public static int PosicionU=-9;
  public static ArrayList<String> nombre_Tiendas = new ArrayList();

    public static void main(String[] args) {
        String Opcion = "";
        while (Opcion != "Salir") {
            String[] Opciones = {"Crear Usuario", "Log in Cliente", "Log in socio", "Salir"};
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
                    } else {
                        JOptionPane.showMessageDialog(null, "Error en los datos");
                    }
                    break;
                case "Log in socio":
                    if (LoginSocio(Usuario)) {
                         JOptionPane.showMessageDialog(null, "Bienvenido Socio");
                        MenuEmpleado();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error en los datos");
                    }
                    break;
                case "Crear Usuario":
                    CrearUsuario();
                    break;
            }
        }
    }

    public static void CrearUsuario() {
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
        Clientes Cli = new Clientes();
        boolean Bandera = false;
        String User = "";
        String Contra = "";
        String Correo = "";
        String Id = "";
        String Nombre = "";
        User = JOptionPane.showInputDialog("Ingrese su UserName");
        while (nicks.contains(User)) {
            User = JOptionPane.showInputDialog("Ingrese su User Name");
        }
        nicks.add(User);
        Contra = JOptionPane.showInputDialog("Ingrese su Contraseña");
        Correo = JOptionPane.showInputDialog("Ingrese su Correo");
        Nombre = JOptionPane.showInputDialog("Ingrese su Nombre Completo");
        double Dinero = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de dinero que tiene disponible"));
        Id = GenerarCodigo();
        Calendar Fecha = GenerarFecha();
        Cli.setCorreo(Correo);
        Cli.setContraseña(Contra);
        Cli.setDinero(Dinero);
        Cli.setNombrecompleto(Nombre);
        Cli.setUsername(User);

        return Cli;
    }

    public static void CrearProducto() {
        int descuento = 0;
        double precio = 0.0;
        String Deesfripcion = JOptionPane.showInputDialog("Ingrese la descripcion del producto");
        String Marca = JOptionPane.showInputDialog("Ingrese la marca del producto");
        try {
            descuento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el descuento del producto:"));
            precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
        } catch (Exception e) {

        }
        String Opcion = "";
        String[] Opciones = {"Comida", "Ropa", "Juguetes"};
        switch (Opcion) {
            case "Comida":
                Comida C = new Comida();
                C.setDescripcion(Deesfripcion);
                C.setDescuento(descuento);
                C.setMarca(Marca);
                Producto.add(C);
                break;
            case "Ropa":
                Ropa R = new Ropa();
                R.setDescripcion(Deesfripcion);
                R.setDescuento(descuento);
                R.setMarca(Marca);
                Producto.add(R);
                break;
            case "Juguetes":
                Juguetes J = new Juguetes();
                J.setDescripcion(Deesfripcion);
                J.setDescuento(descuento);
                J.setMarca(Marca);
                Producto.add(J);
                break;
        }
    }

    public static void AgregarEmpleados() {
        int Pos = Integer.parseInt(JOptionPane.showInputDialog("Lista de tiendas disponibles hasta el momento: \n" + Imprimir()));
        if (Tienda.get(Pos).getEmple().size() == 4 && Tienda.get(Pos) instanceof Locales_Comida) {
            JOptionPane.showMessageDialog(null, "Numero maximo de empleados encontrado");
        } else {
            int Pos2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el empleado a agregar: \n" + ImprimirE()));
            Tienda.get(Pos).setEmple(Empleado.get(Pos2));
        }

    }

    public static void CrearLocal() {
        Tiendas T = new Tiendas();
        quioscos Q = new quioscos();
        Locales_Comida LC = new Locales_Comida();
        Locales L = new Locales();
        String Nombre = "";
        int Piso = -2;

        Nombre = JOptionPane.showInputDialog("el Nombre de la cliente");
        String Opcion = "";
        String[] Opciones = {"Tienda", "Quiosco", "Local Comida"};
        Opcion = (String) JOptionPane.showInputDialog(null,
                "Tipo de tienda que desea crear", //Mensaje
                "                                  Tipo_Tienda",//TITULO
                JOptionPane.QUESTION_MESSAGE,
                null,
                Opciones,
                Opciones[0]);
        while (Piso <= 0) {
            try {
                Piso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el piso del edificio"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Los pisos son unicamente datos numericos");
                Piso = 0;
            }
        }
        switch (Opcion) {
            case "Tienda":
                T.setNombre(Nombre);
                T.setNum_Piso(Piso);
                int Metros = 0;
                while (Metros <= 0 || Metros > 18) {
                    try {
                        Metros = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el piso del edificio"));
                        if (Metros > 18) {
                            JOptionPane.showMessageDialog(null, "Las tiendas no pueden tener mas de 18 Metros .");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Los pisos son unicamente datos numericos");
                        Metros = 0;
                    }
                }
                T.setTamano(Metros);
                Tienda.add(T);
                nombre_Tiendas.add(Nombre);
                break;
            case "Quiosco":
                String[] Nombres = new String[nombre_Tiendas.size()];
                for (int i = 0; i < nombre_Tiendas.size(); i++) {
                    Nombres[i] = nombre_Tiendas.get(i);
                }
                String Tiendita;
                Tiendita = (String) JOptionPane.showInputDialog(null,
                        "Nombre de las tiendas existentes", //Mensaje
                        "                                  Nombre del quiosco",//TITULO
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        Nombres,
                        Nombres[0]);
                Q.setNombre(Nombre);
                Q.setNum_Piso(Piso);
                Q.setNombre_Tienda(Tiendita);
                Tienda.add(Q);
                break;
            case "Local Comida":
                String Impresion = "Seleeccine el producto del dia: \n";
                for (int i = 0; i < Producto.size(); i++) {
                    Impresion += i + " )" + Producto.get(i);

                }
                int indice = 0;
                while (indice < 0 || indice > Producto.size() - 1) {
                    try {
                        indice = Integer.parseInt(JOptionPane.showInputDialog(Impresion));
                        if (indice < 0 || indice > Producto.size() - 1) {
                            JOptionPane.showMessageDialog(null, "El numero se encuentra fuera de rango");
                            continue;
                        }
                        if (Producto.get(indice) instanceof Comida) {
                            double Precio = Producto.get(indice).getPrecio()/2;
                            Producto.get(indice).setPrecio(Precio);
                            Q.setProducto(((Comida) Producto.get(indice)));
                            JOptionPane.showMessageDialog(null, "Producto agregado con 50% de descuento.");
                        } else {
                            JOptionPane.showMessageDialog(null, "El producto seleccionado no es alimenticio.");
                            continue;
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "El dato es incorrecto");
                        indice = -6;
                    }
                }
                Q.setNombre(Nombre);
                Q.setNum_Piso(Piso);
                Tienda.add(Q);
                break;
        }
    }

    public static Calendar GenerarFecha() {
        Calendar Calendario = new GregorianCalendar(Ran.nextInt(10) + 2018, 0, Ran.nextInt(20));
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

        Empleados EMP = new Empleados();
        boolean Bandera = false;
        String User = "";
        String Contra = "";
        String Correo = "";
        String Id = "";
        String Nombre = "";
        User = JOptionPane.showInputDialog("Ingrese su UserName");
        while (nicks.contains(User)) {
            User = JOptionPane.showInputDialog("Ingrese su User Name");
        }
        nicks.add(User);
        Contra = JOptionPane.showInputDialog("Ingrese su Contraseña");
        Correo = JOptionPane.showInputDialog("Ingrese su Correo");
        Nombre = JOptionPane.showInputDialog("Ingrese su Nombre");
        double Dinero = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de dinero que tiene disponible"));
        Id = GenerarCodigo();
        Calendar Fecha = GenerarFecha();
        EMP.setContraseña(Contra);
        ((Personas) EMP).setCorreo(Correo);
        EMP.setFehanacimiento(Fecha);
        EMP.setNombrecompleto(Nombre);
        EMP.setUsername(User);
        return EMP;
    }

    public static void Menucliente() {
        int pos = Integer.parseInt(JOptionPane.showInputDialog("Tiendas disponibles" + Imprimir() + "\n Ingrese a cual desea Entrar.\n"));

    }

    
    public static void MenuEmpleado() {
        String Opcion = "";
        String[] Opciones = {"Crear Tienda", "Agregar Empleados a las tienda", "Agregar Productos a la tienda", "Modificar"};
        String[] Opciones2 = {"Personas", "Tiendas", "Productos"};
        Opcion = (String) JOptionPane.showInputDialog(null,
                "Bienvenido al Menu principal: Socio", //Mensaje
                "                                  Menu principal",//TITULO
                JOptionPane.QUESTION_MESSAGE,
                null,
                Opciones,
                Opciones[0]);
        switch (Opcion) {
            case "Crear Tienda":
                CrearLocal();
                break;
            case "Agregar Empleados a las tienda":
               Empleado.add(CrearEmpleado());
                break;
            case "Agregar Productos a la tienda":
                CrearProducto();
                break;
            case "Modificar":
       

                 Opcion = (String) JOptionPane.showInputDialog(null,
                "Valor que desea modificar", //Mensaje
                "                                  Modificar",//TITULO
                JOptionPane.QUESTION_MESSAGE,
                null,
                Opciones2,
                Opciones2[0]);
                 switch(Opcion){
                     case"Personas":
                         modificarPersona();
                         break;
                          case "Tiendas":
                         break;
                          case "Productos":
                         break;
                        
                 }
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
                if (Usuario.equals(((Personas) Personas.get(i)).getUsername()) && Contra.equals(((Personas) Personas.get(i)).getContraseña())) {
                    System.out.println("ENCPNTROP COINCIDENCIA");
                    Acceso = true;
                    PosicionU=i;
                }
            }
        }
        return Acceso;
    }

    public static boolean LoginSocio(ArrayList Personas) {

        String Usuario = JOptionPane.showInputDialog("Ingrese su usuario.");
        String Contra = JOptionPane.showInputDialog("Ingrese su Contraseña");
        boolean Acceso = false;
        if (Usuario.equals(Socio)&&ContraSocio.equals(Contra)) {
            Acceso=true;
        }else{
            Acceso=false;
        }
//        for (int i = 0; i < Personas.size(); i++) {
//            if (Personas.get(i) instanceof Empleados) {
//                if (Usuario.equals(((Personas) Personas.get(i)).getUsername()) && Contra.equals(((Personas) Personas.get(i)).getContraseña())) {
//                    System.out.println("ENCPNTROP COINCIDENCIA");
//                    Acceso = true;
//                }
//            }
//        }
        return Acceso;
    }

    public static String Imprimir() {
        String S = "";
        for (int i = 0; i < Tienda.size(); i++) {
            S += i + ")" + Tienda.get(i);
        }
        return S;
    }

    public static String ImprimirE() {
        String S = "";
        for (int i = 0; i < Empleado.size(); i++) {
            S += i + ")" + Empleado.get(i);
        }
        return S;
    }

    public static String ImprimirP() {
        String S = "";
        for (int i = 0; i < Producto.size(); i++) {
            S += i + ")" + Producto.get(i);
        }
        return S;
    }

    public static void modificarPersona() {

        String Opcion = "";
        String Opcion2 = "";

        String[] OpcionesM = {"Modificar Cliente", "Modificar Empleado", "Salir"};

        Opcion = (String) JOptionPane.showInputDialog(null,
                "Seleccione una opción", //Mensaje
                "                                  MENU",//TITULO
                JOptionPane.QUESTION_MESSAGE,
                null,
                OpcionesM,
                OpcionesM[0]);

        switch (Opcion) {
            case "Modificar Cliente":
                String[] OpcionesMC = {"Modificar Usuario", "Modificar Contraseña",
                    "Modificar Correo", "Moficicar ID", "Modificar Nombre"};
                Opcion2 = (String) JOptionPane.showInputDialog(null,
                        "Seleccione una opción", //Mensaje
                        "                                  MENU",//TITULO
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        OpcionesMC,
                        OpcionesMC[0]);

                switch (Opcion2) {
                    case "Modificar Usuario":
                        int posicion;
                        String Username;
                        posicion = Integer.parseInt(JOptionPane.showInputDialog("" + "Cliente a modificar: "));
                        Username = JOptionPane.showInputDialog("" + "Nuevo Username: ");
                        ((Clientes) Usuario.get(posicion)).setUsername(Username);
                        break;
                }

                break;
            case "Modificar Empleado":
                break;
        }

        /* int posicion;
        String Username;
        posicion=Integer.parseInt(JOptionPane.showInputDialog(""+"Posicion a modificar: "));
        Username=JOptionPane.showInputDialog(""+"Nuevo Username: ");
        ((Usuario).get(p)).setAncho(a);*/
    }
     public static void  Factura(ArrayList Lista, ArrayList Cesta) {
        int Pos = -5;
        int Cantidad = -9;
        double Convertido = -6;
        
        int Inventario = 0;
        double Inventario2 = 0;

        while (Pos < 0 || Pos > Lista.size()) {
            Pos = Integer.parseInt(JOptionPane.showInputDialog("                                    SELECIONE UN PRODUCTO: \n\n" + ImprimirP() + "\n Ingrese la posicion del producto que desea Comprar: "));
        }
         if (((Clientes)Usuario.get(PosicionU)).getDinero()<Producto.get(Pos).getPrecio()) {
             Cesta.add(Producto.get(Pos));
         }
     }
}
