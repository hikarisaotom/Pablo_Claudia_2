package trabajo_equipo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.swing.JOptionPane;
import trabajo_equipo.Clases.*;

public class Trabajo_Equipo {

    public static Random Ran = new Random();
    public static ArrayList<Clientes> Usuario = new ArrayList();
    public static ArrayList<Empleados> Empleado = new ArrayList();
    public static ArrayList<Locales> Tienda = new ArrayList();
    public static ArrayList<Productos> Producto = new ArrayList();
    public static ArrayList<String> Codigos = new ArrayList();
    public static ArrayList<String> nicks = new ArrayList();
    public static String Socio = "clau";
    public static String ContraSocio = "123";
    public static int PosicionU = -9;
    public static ArrayList<String> nombre_Tiendas = new ArrayList();
    public static Clientes Cliente_Actual;
    public static Empleados Empleado_Actual;
    public static Locales Tienda_Actual;
    public static Productos Producto_Actual;

    public static void main(String[] args) {
        String Opcion = "";
        while (Opcion != "Salir") {
            String[] Opciones = {"Crear Usuario", "Log in Cliente", "Log in socio", "Salir"};
            try {
                Opcion = (String) JOptionPane.showInputDialog(null,
                        "Seleccione una opción", //Mensaje
                        "                                  MENU",//TITULO
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        Opciones,
                        Opciones[0]);
                if (Opcion == null) {
                    continue;
                }
            } catch (java.lang.NullPointerException x) {

            }
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
                case "Salir":
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema");
                    break;
            }
        }
    }

    public static void CrearUsuario() {
        String Opcion = "";
        String[] Opciones = {"Cliente"};
        int Bandera_1 = 0;
        while (Bandera_1 == 0) {
            try {
                Opcion = (String) JOptionPane.showInputDialog(null,
                        "Seleccione una opción", //Mensaje
                        "                                  MENU",//TITULO
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        Opciones,
                        Opciones[0]);
                if (Opcion == null) {
                    Bandera_1 = 0;
                } else {
                    Bandera_1 = 6;
                }
            } catch (Exception e) {
                Bandera_1 = 0;
            }
        }
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
        double Dinero = 0.0;
        int Bandera_1 = 0;
        User = JOptionPane.showInputDialog("Ingrese su UserName");
        while (nicks.contains(User)) {
            User = JOptionPane.showInputDialog("Ingrese su User Name");
        }
        nicks.add(User);
        Contra = JOptionPane.showInputDialog("Ingrese su Contraseña");
        Correo = JOptionPane.showInputDialog("Ingrese su Correo");
        Nombre = JOptionPane.showInputDialog("Ingrese su Nombre Completo");
        while (Bandera_1 == 0) {
            try {
                Dinero = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de dinero que tiene disponible"));
                Bandera_1 = 9;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Los valores deben ser un numero decimal ");
                Bandera_1 = 0;
            }
        }
        Id = GenerarCodigo();
        Calendar Fecha = GenerarFecha();
        Cli.setCorreo(Correo);
        Cli.setContraseña(Contra);
        Cli.setDinero(Dinero);
        Cli.setNombrecompleto(Nombre);
        Cli.setUsername(User);
        JOptionPane.showMessageDialog(null, "Cliente Creado");
        //Usuario.add(Cli);
        System.out.println(Empleado);
        return Cli;

    }

    public static void CrearProducto() {
        int descuento = 0;
        double precio = 0.0;
        Productos P=new Productos();
        String Deescripcion = JOptionPane.showInputDialog("Ingrese la descripcion del producto");
        String Marca = JOptionPane.showInputDialog("Ingrese la marca del producto");
        int Bandera_1 = 0;
        while (Bandera_1 == 0) {
            try {
                descuento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el descuento del producto:"));
                precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
                Bandera_1 = 6;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en los datos, vuelva a ingresarlos");
                Bandera_1 = 0;
            }
        }
        String Opcion = "";
        String[] Opciones = {"Comida", "Ropa", "Juguetes"};
        switch (Opcion) {
            case "Comida":
                Comida C = new Comida();
                C.setPrecio(precio);
                C.setDescripcion(Deescripcion);
                C.setDescuento(descuento);
                C.setMarca(Marca);
              //  Producto.add(C);
                 Producto.add(C);
                 P=C;
                break;
            case "Ropa":
                Ropa R = new Ropa();
                    R.setPrecio(precio);
                R.setDescripcion(Deescripcion);
                R.setDescuento(descuento);
                R.setMarca(Marca);
                String Talla = JOptionPane.showInputDialog(null, "Ingrese la talla de la ropa");
                String Genero = JOptionPane.showInputDialog(null, "Sexo de la ropa.");
                R.setGenero(Genero.charAt(0) + "");
                R.setTalla(Talla);
               // Producto.add(R);
                 Producto.add(R);
                   P=R;
                break;
            case "Juguetes":
                Juguetes J = new Juguetes();
                    J.setPrecio(precio);
                J.setDescripcion(Deescripcion);
                J.setDescuento(descuento);
                J.setMarca(Marca);
                String Tipo = JOptionPane.showInputDialog(null, "Ingrese el tipo de jueguete");
                J.setTipo(Tipo);
               // Producto.add(J);
                Producto.add(J);
                  P=J;
                break;
        }
       Producto.add(P);
        System.out.println("LOS PRODUCTOS "+Producto);
        JOptionPane.showMessageDialog(null, "Producto agregado");
      
    }

    public static void AgregarEmpleados() {
        int Pos = 0;
        int Bandera_1 = 0;
        int Bandera_2 = 0;
        while (Bandera_1 == 0) {
            try {
                Pos = Integer.parseInt(JOptionPane.showInputDialog("Lista de tiendas disponibles hasta el momento: \n" + Imprimir()));
                if (Pos < 0 || Pos > Tienda.size() - 1) {
                    JOptionPane.showConfirmDialog(null, "El numero esta fuera de Rango");
                    Bandera_1 = 0;
                } else {
                    Bandera_1 = 6;
                }
            } catch (Exception e) {
                Bandera_1 = 0;
            }
        }

        if (Tienda.get(Pos).getEmple().size() == 4 && Tienda.get(Pos) instanceof Locales_Comida) {
            JOptionPane.showMessageDialog(null, "Numero maximo de empleados encontrado");
        } else {
            /*EMPLEADOS*/
            int Pos2 = 0;
            while (Bandera_2 == 0) {
                try {
                    Pos2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el empleado a agregar: \n" + ImprimirE()));
                    if (Pos2 < 0 || Pos > Empleado.size() - 1) {
                        JOptionPane.showConfirmDialog(null, "El numero esta fuera de Rango");
                        Bandera_2 = 0;
                    } else {
                        Bandera_2 = 6;
                    }
                } catch (Exception e) {
                    Bandera_2 = 0;
                }
            }
            Tienda.get(Pos).setEmple(Empleado.get(Pos2));
            JOptionPane.showMessageDialog(null, "Empleado agregado");
        }
        System.out.println("LAS TIENDAS: \n"
                + Tienda);

    }

    public static void CrearLocal() {
        Tiendas T = new Tiendas();
        quioscos Q = new quioscos();
        Locales_Comida LC = new Locales_Comida();
        Locales L = new Locales();
        String Nombre = "";
        int Piso = -2;

        String Opcion = "";
        String[] Opciones = {"Tienda", "Quiosco", "Local Comida"};
        int Bandera_1 = 0;
        while (Bandera_1 == 0) {
            Opcion = (String) JOptionPane.showInputDialog(null,
                    "Tipo de tienda que desea crear", //Mensaje
                    "                                  Tipo_Tienda",//TITULO
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    Opciones,
                    Opciones[0]);
            if (Opcion==null) {
                Bandera_1=0;
                continue;
            }
            if ((Opcion.equals("Quiosco") && nombre_Tiendas.size() == 0 || Opcion.equals("Local Comida")) && Producto.size() <= 0) {
                JOptionPane.showMessageDialog(null, "Para crear Quioscos y locales de comida deben haber productos agregados");
                Bandera_1 = 0;
            } else {
                Bandera_1 = 5;
            }
        }
        Nombre = JOptionPane.showInputDialog("el Nombre de la tienda");
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
                        Metros = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad en metros del edificio"));
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
                            int Descuento = 50;
                            Producto.get(indice).setDescuento(Descuento);
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
        JOptionPane.showMessageDialog(null, "Tienda creada agregado");
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

        Id = GenerarCodigo();
        Calendar Fecha = GenerarFecha();
        EMP.setContraseña(Contra);
        EMP.setCorreo(Correo);
        EMP.setFehanacimiento(Fecha);
        EMP.setNombrecompleto(Nombre);
        EMP.setUsername(User);
        JOptionPane.showMessageDialog(null, "Empleado Creado");
        System.out.println(Empleado);
        Empleado.add(EMP);
        System.out.println("LOS EMPLEADOS" + Empleado);
        return EMP;

    }

    public static void Menucliente() {
        int pos = 0;
        int pos1 = 0;
        int Bandera_1 = 0;
        int Bandera_2 = 0;
        while (Bandera_1 == 0) {
            try {
                pos = Integer.parseInt(JOptionPane.showInputDialog("Tiendas disponibles" + Imprimir() + "\n Ingrese a cual desea Entrar.\n"));
                if (pos < 0 || pos > Tienda.size() - 1) {
                    JOptionPane.showMessageDialog(null, "El valor esta fuera de rango.");
                    Bandera_1 = 0;
                } else {
                    Bandera_1 = 3;
                }
            } catch (Exception e) {
                Bandera_1 = 0;
                JOptionPane.showMessageDialog(null, "La posicion debe ser un valor numerico");
            }
        }
        Tienda_Actual = Tienda.get(pos);
        while (Bandera_2 == 0) {
            try {
                pos1 = Integer.parseInt(JOptionPane.showInputDialog("Productos Disponibles" + ImprimirP() + "\n Ingrese que producto desea comprar.\n"));
                if (pos1 < 0 || pos1 > Producto.size() - 1) {
                    JOptionPane.showMessageDialog(null, "El valor esta fuera de rango.");
                    Bandera_2 = 0;
                } else {
                    Bandera_2 = 3;
                }
            } catch (Exception e) {
                Bandera_2 = 0;
                JOptionPane.showMessageDialog(null, "La posicion debe ser un valor numerico");
            }
        }
        Producto_Actual = Producto.get(pos1);
        Double Descuento = 0.10 * Producto_Actual.getDescuento();
        if (Cliente_Actual.getDinero() < Producto_Actual.getPrecio() - Descuento) {
            JOptionPane.showMessageDialog(null, "No puede comprar el producto, su dinero es insuficiente");
        } else {
            JOptionPane.showMessageDialog(null, "Se ha agregado el producto al carrito ");
            Cliente_Actual.getListaproductos().add(Producto_Actual);
            Tienda_Actual.getFacturados().add(Producto_Actual);
        }
    }

    public static void MenuEmpleado() {
        String Opcion = "";
        String[] Opciones = {"Crear Tienda", "Crear Empleado", "Crear Producto", "Agregar Empleados a tiendas", "Agregar Productos a la tienda", "Facturacion", "Modificar", "Eliminar"};
        int Bandera = 0;
        while (Bandera == 0) {
            try {
                Opcion = (String) JOptionPane.showInputDialog(null,
                        "Bienvenido al Menu principal: Socio", //Mensaje
                        "                                  Menu principal",//TITULO
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        Opciones,
                        Opciones[0]);
                if (Opcion == null) {
                    Bandera = 0;
                } else {
                    Bandera = 6;
                }
            } catch (Exception e) {

            }
        }
        switch (Opcion) {
            case "Agregar Productos a la tienda":
                AgregarProducto();
                break;
            case "Facturacion":
                //Factura();
                String S="";
                for (int i = 0; i <Tienda.size(); i++) {
                    if (Tienda.get(i).getFacturados().size()>=5) {
                        S+=ImprimirF(Tienda.get(i));
                    }
                    if (S=="") {
                        JOptionPane.showMessageDialog(null,"No se han vendido mas de 5 productos en ninguna tienda");
                    }else{
                           JOptionPane.showMessageDialog(null,"EMITIENDO FACTURAS: \n"+S);
                    }
                }
                break;
            case "Eliminar":
                Eliminar();
                break;
            case "Crear Tienda":
                CrearLocal();
                break;
            case "Agregar Empleados a tiendas":
                AgregarEmpleados();
                System.out.println("LISTA DE EMPLEADOS CREADOS" + Empleado);
                break;
            case "Crear Producto":
                CrearProducto();
                System.out.println("LOS PRODUCTIOS"+Producto);
                break;
            case "Modificar":
                Modificar();
                break;
            case "Crear Empleado":
                CrearEmpleado();
                break;
        }
    }

    public static void AgregarProducto() {
        int Pos_Tienda = 0;
        int Pos_Producto = 0;
        int Bandera_1 = 0;
        int Bandera_2 = 0;
        while (Bandera_1 == 0) {
            try {
                Pos_Tienda = Integer.parseInt(JOptionPane.showInputDialog(null, "SELECCIONE LA TIENDA A LA QUE DESEA AGREGAR EL PRODUCTO: \n" + Imprimir()));
                if (Pos_Tienda < 0 || Pos_Tienda >= Tienda.size() - 1) {
                    Bandera_1 = 0;
                    JOptionPane.showMessageDialog(null, "El numero se encuentra fuera del rango");
                } else {
                    Bandera_1 = 6;
                }
            } catch (Exception e) {
                Bandera_1 = 0;
                JOptionPane.showMessageDialog(null, "La posicion debe ser un valor numerico");
            }
        }

        while (Bandera_2 == 0) {
            try {
                Pos_Producto = Integer.parseInt(JOptionPane.showInputDialog(null, "SELECCIONE EL PRODUCTO QUE DESEA AGREGAR: \n" + ImprimirP()));
                if (Pos_Producto < 0 || Pos_Producto >= Producto.size() - 1) {
                    Bandera_2 = 0;
                    JOptionPane.showMessageDialog(null, "El numero se encuentra fuera del rango");
                } else {
                    Bandera_2 = 6;
                }
            } catch (Exception e) {
                Bandera_2 = 0;
                JOptionPane.showMessageDialog(null, "La posicion debe ser un valor numerico");
            }
        }
        Tienda_Actual = Tienda.get(Pos_Tienda);
        Producto_Actual = Producto.get(Pos_Producto);
        if (Tienda_Actual instanceof Tiendas && !(Producto_Actual instanceof Comida)) {
            Tienda_Actual.getProduc().add(Producto_Actual);
            JOptionPane.showMessageDialog(null, "Producto Agregado");
        } else if (Tienda_Actual instanceof Locales_Comida && (Producto_Actual instanceof Comida)) {
            Tienda_Actual.getProduc().add(Producto_Actual);
            JOptionPane.showMessageDialog(null, "Producto Agregado");
        } else if (Tienda_Actual instanceof quioscos) {
            Producto_Actual.setPrecio(Producto_Actual.getPrecio() / 2);
            Tienda_Actual.getProduc().add(Producto_Actual);
            JOptionPane.showMessageDialog(null, "Producto Agregado");
        } else {
            JOptionPane.showMessageDialog(null, "No se puede agregar este tipo de producto a este tipo de tienda");
        }

    }

    public static void Modificar() {
        String Opcion = "";
        String[] Opciones2 = {"Empleados", "Tiendas", "Productos"};
        int Bandera = 0;
        while (Bandera == 0) {
            try {
                Opcion = (String) JOptionPane.showInputDialog(null,
                        "Seleeccione que desea Modificar", //Mensaje
                        "                                  Modificar",//TITULO
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        Opciones2,
                        Opciones2[0]);
                if (Opcion == null) {
                    Bandera = 0;
                } else {
                    Bandera = 6;
                }
            } catch (Exception e) {

            }
        }

        switch (Opcion) {
            case "Empleados":
                modificarPersona();
                System.out.println("MODIFICANDO PERSONAS");
                break;
            case "Tiendas":
                ModificarTiendas();
                break;
            case "Productos":
                ModificarProductos();
                break;

        }
    }

    public static void modificarPersona() {
        String Opcion = "";
        String Opcion2 = "";
        int Bandera = 0;
        int Pos = 0;
        String[] OpcionesM = {"Modificar Cliente", "Modificar Empleado"};
        while (Bandera == 0) {
            try {
                Opcion = (String) JOptionPane.showInputDialog(null,
                        "Seleccione una opción", //Mensaje
                        "                                  MENU",//TITULO
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        OpcionesM,
                        OpcionesM[0]);
                if (Opcion == null) {
                    Bandera = 0;
                    continue;
                }
                ArrayList Lista_Modificar = null;

                String Salida = "";
                if (Opcion.equals("Modificar Cliente")) {
                    Salida += ImprimirC();
                    System.out.println("IMPRIMIENDO C" + ImprimirC());
                    Lista_Modificar = Usuario;
                } else if (Opcion.equals("Modificar Empleado")) {
                    Salida += ImprimirE();
                    System.out.println("IMPRIMIENDO C" + ImprimirE());
                    Lista_Modificar = Empleado;
                }
                System.out.println("LA SALIDA" + Salida);
                Pos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la Posicion que desea Modificar" + Salida));
                if (Pos < 0 || Pos > Lista_Modificar.size() - 1) {
                    JOptionPane.showMessageDialog(null, "La posicion esta fuera de rango.");
                    Bandera = 0;
                } else {
                    Bandera = 6;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "La posicion es un valor numerico unicamente.");
            }
        }
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
        Id = GenerarCodigo();
        switch (Opcion) {
            case "Modificar Cliente":
                int Bandera_2 = 0;
                while (Bandera_2 == 0) {
                    try {
                        double Bandera_1 = 0.0;
                        double Dinero = 0.0;

                        while (Bandera_1 == 0) {
                            try {
                                Dinero = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de dinero que tiene disponible"));
                                if (Dinero > 0.0) {
                                    Bandera_1 = 9;
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Los valores deben ser un numero decimal ");
                                Bandera_1 = 0;
                            }
                        }
                        Clientes EMP = Usuario.get(Pos);
                        Calendar Fecha = GenerarFecha();
                        EMP.setContraseña(Contra);
                        EMP.setCorreo(Correo);
                        EMP.setFehanacimiento(Fecha);
                        EMP.setNombrecompleto(Nombre);
                        EMP.setUsername(User);
                        Bandera_1 = 6;
                        Bandera_2 = 6;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error...reiniciando");
                    }
                }
                break;
            case "Modificar Empleado":
                int Bandera_3 = 0;
                while (Bandera_3 == 0) {
                    try {
                        String Horario = JOptionPane.showInputDialog(null, "Ingrese el nuevo horario de trabajo del empleado");
                        Empleados EMP = Empleado.get(Pos);
                        Calendar Fecha = GenerarFecha();
                        EMP.setContraseña(Contra);
                        EMP.setCorreo(Correo);
                        EMP.setFehanacimiento(Fecha);
                        EMP.setNombrecompleto(Nombre);
                        EMP.setUsername(User);
                        EMP.setHorario(Horario);
                        Bandera_3 = 6;
                    } catch (Exception e) {
                        Bandera_3 = 0;
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error...reiniciando");
                    }
                }
                break;
        }
    }

    public static void ModificarTiendas() {
        String Nombre = "";
        String Opcion = "";
        int pos = 0;
        int Bandera_3 = 0;
        while (Bandera_3 == 0) {
            try {
                pos = Integer.parseInt(JOptionPane.showInputDialog("Tiendas disponibles" + Imprimir() + "\n Ingrese a cual desea Entrar.\n"));
                if (pos < 0 || pos > Tienda.size() - 1) {
                    JOptionPane.showMessageDialog(null, "El valor esta fuera de rango.");
                    Bandera_3 = 0;
                } else {
                    Bandera_3 = 3;
                }
            } catch (Exception e) {
                Bandera_3 = 0;
                JOptionPane.showMessageDialog(null, "La posicion debe ser un valor numerico");
            }
        }
        Tienda_Actual = Tienda.get(pos);
    int Tipo=0;
        if (Tienda_Actual instanceof Tiendas) {
            Tipo=1;
        }else if (Tienda_Actual instanceof Locales_Comida){
            Tipo=2;
        }else if (Tienda_Actual instanceof quioscos){
            Tipo=3;
        }
        String[] Opciones = {"Tienda", "Quiosco", "Local Comida"};
        int Bandera_1 = 0;
        int Piso = 0;
        while (Bandera_1 == 0) {
            Opcion = (String) JOptionPane.showInputDialog(null,
                    "Tipo de tienda que desea crear", //Mensaje
                    "                                  Tipo_Tienda",//TITULO
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    Opciones,
                    Opciones[0]);
            if (Opcion == null) {
                Bandera_1 = 0;
                continue;
            }

        }
        Nombre = JOptionPane.showInputDialog("el Nombre de la tienda");
        while (Piso <= 0) {
            try {
                Piso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el piso del edificio"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Los pisos son unicamente datos numericos");
                Piso = 0;
            }
        }
        switch (Tipo) {
            case 1:
                Tienda_Actual.setNombre(Nombre);
                Tienda_Actual.setNum_Piso(Piso);
                int Metros = 0;
                while (Metros <= 0 || Metros > 18) {
                    try {
                        Metros = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad en metros del edificio"));
                        if (Metros > 18) {
                            JOptionPane.showMessageDialog(null, "Las tiendas no pueden tener mas de 18 Metros .");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Los pisos son unicamente datos numericos");
                        Metros = 0;
                    }
                }
                ((Tiendas) Tienda_Actual).setTamano(Metros);
                //Tienda.add(Tienda_Actual);
                nombre_Tiendas.add(Nombre);
                break;
            case 3:
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
                Tienda_Actual.setNombre(Nombre);
                Tienda_Actual.setNum_Piso(Piso);
                ((quioscos) Tienda_Actual).setNombre_Tienda(Tiendita);
                /// Tienda.add(Q);
                break;
            case 2:
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
                            int Descuento = 50;
                            Producto.get(indice).setDescuento(Descuento);
                            ((Locales_Comida) Tienda_Actual).setProducto_Dia((Comida) Producto.get(indice));
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
                Tienda_Actual.setNombre(Nombre);
                Tienda_Actual.setNum_Piso(Piso);
                Tienda.add(Tienda_Actual);
                System.out.println("LAS TIENDAS");
                break;
        }
        JOptionPane.showMessageDialog(null, "Tienda Modificada ");
    }

    public static void ModificarProductos() {
        int Bandera_2=0;
        int pos1=0;
          while (Bandera_2 == 0) {
            try {
                pos1 = Integer.parseInt(JOptionPane.showInputDialog("Productos Disponibles" +ImprimirP() + "\n Ingrese que producto desea comprar.\n"));
                if (pos1 < 0 || pos1 > Producto.size() - 1) {
                    JOptionPane.showMessageDialog(null, "El valor esta fuera de rango.");
                    Bandera_2 = 0;
                } else {
                    Bandera_2 = 3;
                }
            } catch (Exception e) {
                Bandera_2 = 0;
                JOptionPane.showMessageDialog(null, "La posicion debe ser un valor numerico");
            }
        }
   
        Producto_Actual = Producto.get(pos1);
        int Tipo = 0;
        if (Producto_Actual instanceof Comida) {
            Tipo = 1;
        } else if (Producto_Actual instanceof Juguetes) {
            Tipo = 2;
        } else if (Producto_Actual instanceof Ropa) {
            Tipo = 3;
        }
            int descuento = 0;
        double precio = 0.0;
        String Deescripcion = JOptionPane.showInputDialog("Ingrese la descripcion del producto");
        String Marca = JOptionPane.showInputDialog("Ingrese la marca del producto");
        int Bandera_1 = 0;
        while (Bandera_1 == 0) {
            try {
                descuento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el descuento del producto:"));
                precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
                Bandera_1 = 6;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en los datos, vuelva a ingresarlos");
                Bandera_1 = 0;
            }
        }
        String Opcion = "";
        String[] Opciones = {"Comida", "Ropa", "Juguetes"};
        switch (Tipo) {
            case 1:
                Comida C = new Comida();
               Producto_Actual.setDescripcion(Deescripcion);
               Producto_Actual.setDescuento(descuento);
               Producto_Actual.setMarca(Marca);
               // Producto.add(C);
                break;
            case 3:
                Ropa R = new Ropa();
               Producto_Actual.setDescripcion(Deescripcion);
               Producto_Actual.setDescuento(descuento);
               Producto_Actual.setMarca(Marca);
                String Talla = JOptionPane.showInputDialog(null, "Ingrese la talla de la ropa");
                String Genero = JOptionPane.showInputDialog(null, "Sexo de la ropa.");
                ((Ropa)Producto_Actual).setGenero(Genero.charAt(0) + "");
              ((Ropa)Producto_Actual).setTalla(Talla);
                //Producto.add(R);
                break;
            case 2:
                Juguetes J = new Juguetes();
                 Producto_Actual.setDescripcion(Deescripcion);
                Producto_Actual.setDescuento(descuento);
                Producto_Actual.setMarca(Marca);
                String Tipo1 = JOptionPane.showInputDialog(null, "Ingrese el tipo de jueguete");
                 ((Juguetes)Producto_Actual).setTipo(Tipo1);
                //Producto.add(J);
                break;
        }
        JOptionPane.showMessageDialog(null, "Producto Modificado ");
    }

    public static void Eliminar() {
        String[] Opciones2 = {"Empleados", "Tiendas", "Productos"};
        int Num = 0;
        String Opcion = "";
        while (Num == 0) {
            Opcion = (String) JOptionPane.showInputDialog(null,
                    "Seleeccione la opcion que desea Eliminar", //Mensaje
                    "                                  ELIMINAR",//TITULO
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    Opciones2,
                    Opciones2[0]);
            if (Opcion == null) {
                continue;
            } else {
                Num = 6;
            }
        }
        String Lista;
        ArrayList Lista_Eliminar = null;
        switch (Opcion) {
            case "Empleados":
                Lista = ImprimirE();
                Lista_Eliminar = Empleado;
                break;
            case "Tiendas":
                Lista = Imprimir();
                Lista_Eliminar = Tienda;
                break;
            case "Productos":
                Lista = ImprimirP();
                Lista_Eliminar = Producto;
                break;
        }
        int POS = 0;
        while (POS < 0 || POS > Lista_Eliminar.size() - 1) {
            try {
                POS = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la posicion del elemento e liminar"));
                if (POS > Lista_Eliminar.size() - 1) {
                    JOptionPane.showMessageDialog(null, "Numero fuera de rango");
                    POS = -9;
                } else {
                    Lista_Eliminar.remove(POS);
                    JOptionPane.showMessageDialog(null, "Elemento Eliminado Exitosamente.");
                    System.out.println("LA NUEVA LISTA DE LOS ELEMENTOS");
                    System.out.println(Lista_Eliminar);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Dato Invalido");
            }
        }
    }

    public static boolean LoginCliente(ArrayList Personas) {
        System.out.println("USUARIOS DISPONIBLES " + Usuario);
        String Usuario = JOptionPane.showInputDialog("Ingrese su usuario.");
        String Contra = JOptionPane.showInputDialog("Ingrese su Contra.");
        boolean Acceso = false;
        for (int i = 0; i < Personas.size(); i++) {
            if (Personas.get(i) instanceof Clientes) {
                if (Usuario.equals(((Personas) Personas.get(i)).getUsername()) && Contra.equals(((Personas) Personas.get(i)).getContraseña())) {
                    System.out.println("ENCPNTROP COINCIDENCIA");
                    Acceso = true;
                    PosicionU = i;

                }
            }
        }
        Cliente_Actual = (Clientes) Personas.get(PosicionU);
        System.out.println("EL CLEINTE ACTUAL ES" + Cliente_Actual);
        return Acceso;
    }

    public static boolean LoginSocio(ArrayList Personas) {

        String Usuario = JOptionPane.showInputDialog("Ingrese su usuario.");
        String Contra = JOptionPane.showInputDialog("Ingrese su Contraseña");
        boolean Acceso = false;
        if (Usuario.equals(Socio) && ContraSocio.equals(Contra)) {
            Acceso = true;
        } else {
            Acceso = false;
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
            S += i + ")" + Tienda.get(i).getNombre();
        }
        return S;
    }

    public static String ImprimirC() {
        String S = "";
        for (int i = 0; i < Usuario.size(); i++) {
            S += i + ")" + Usuario.get(i).getNombrecompleto();
        }
        return S;
    }

    public static String ImprimirE() {
        String S = "";
        for (int i = 0; i < Empleado.size(); i++) {
            S += i + ")" + Empleado.get(i).getNombrecompleto();
        }
        return S;
    }

    public static String ImprimirP() {
        String S = "";
        for (int i = 0; i < Producto.size(); i++) {
            S += i + ")" + Producto.get(i).getPrecio() + " " + Producto.get(i).getDescripcion();
        }
        return S;
    }

    public static String ImprimirF(Locales Local) {
        String S = "";
        // for (int i = 0; i < Tienda.size(); i++) {
        S += "----------------------" + Local.getNombre() + "----------------------\n";
        for (int j = 0; j < Local.getFacturados().size(); j++) {
            S += j + " )" + Local.getFacturados().get(j).getDescripcion() + "      " + "Lps." + Local.getFacturados().get(j).getPrecio() + "\n";
        }
        //  }
        return S;
    }

    public static void Factura(ArrayList Lista, ArrayList Cesta) {
        int Pos = -5;
        int Cantidad = -9;
        double Convertido = -6;

        int Inventario = 0;
        double Inventario2 = 0;

        while (Pos < 0 || Pos > Lista.size()) {
            Pos = Integer.parseInt(JOptionPane.showInputDialog("                                    SELECIONE UN PRODUCTO: \n\n" + ImprimirP() + "\n Ingrese la posicion del producto que desea Comprar: "));
        }
        if (((Clientes) Usuario.get(PosicionU)).getDinero() < Producto.get(Pos).getPrecio()) {
            Cesta.add(Producto.get(Pos));
        }
    }
}
