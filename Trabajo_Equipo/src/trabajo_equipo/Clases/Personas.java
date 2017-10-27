
package trabajo_equipo.Clases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Personas {
    protected String username;
    protected String contraseña;
    protected String correo;
    protected String Nombrecompleto;
    protected Calendar fehanacimiento;
    protected DateFormat Formato = new SimpleDateFormat("dd/mm/yy");
    protected String ID;

    public Personas() {
        
    }

    public Personas(String username, String contraseña, String correo, String Nombrecompleto, Calendar fehanacimiento, String Id) {
        this.username = username;
        this.contraseña = contraseña;
        this.correo = correo;
        this.Nombrecompleto = Nombrecompleto;
        this.fehanacimiento = fehanacimiento;
        this.ID=Id;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombrecompleto() {
        return Nombrecompleto;
    }

    public void setNombrecompleto(String Nombrecompleto) {
        this.Nombrecompleto = Nombrecompleto;
    }

    public Calendar getFehanacimiento() {
        return fehanacimiento;
    }

    public void setFehanacimiento(Calendar fehanacimiento) {
        this.fehanacimiento = fehanacimiento;
    }

    @Override
    public String toString() {
        return "Personas{" + "username=" + username + ", contrase\u00f1a=" + contraseña + ", correo=" + correo + ", Nombrecompleto=" + Nombrecompleto + ", fehanacimiento=" + fehanacimiento + ", Formato=" + Formato + ", ID=" + ID + '}';
    }
    
    
    
    
}
