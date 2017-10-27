package trabajo_equipo;

import javax.swing.JOptionPane;

public class Trabajo_Equipo {

    public static void main(String[] args) {
        String Opcion = "";

        while (Opcion != "Salir") {
            String[] Opciones = {"Crear Usuario","Log in Cliente", "Log in Empleados", "Salir"};
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
                case "Empleados":
                    
                    break;
            }
        }
    }
    
    public static void MenuClientes(){
        
        
    }

}
