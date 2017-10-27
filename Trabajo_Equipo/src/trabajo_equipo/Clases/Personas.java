
package trabajo_equipo.Clases;

import java.util.Date;

public class Personas {
    String username;
    String contraseña;
    String correo;
    String Nombrecompleto;
    Date fehanacimiento;

    public Personas() {
    }

    public Personas(String username, String contraseña, String correo, String Nombrecompleto, Date fehanacimiento) {
        this.username = username;
        this.contraseña = contraseña;
        this.correo = correo;
        this.Nombrecompleto = Nombrecompleto;
        this.fehanacimiento = fehanacimiento;
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

    public Date getFehanacimiento() {
        return fehanacimiento;
    }

    public void setFehanacimiento(Date fehanacimiento) {
        this.fehanacimiento = fehanacimiento;
    }
    
    
    
    
}
