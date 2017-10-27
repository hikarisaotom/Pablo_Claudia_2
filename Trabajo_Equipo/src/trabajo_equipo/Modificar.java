package trabajo_equipo;

import javax.swing.JOptionPane;

public class Modificar {
    
    public void modificarnombre(String nombre){
        
        int posicion;
        String Username;
        posicion=Integer.parseInt(JOptionPane.showInputDialog(""+"Posicion a modificar: "));
        Username=JOptionPane.showInputDialog(""+"Nuevo Username: ");
<<<<<<< HEAD
             
=======
                ((Trabajo_Equipo)Usuario.get(posicion)).setUsername(Username);
>>>>>>> a603841ab115b3aeeb4f502fec836c80cf5c568a
        
    } 
    
    
    
}
