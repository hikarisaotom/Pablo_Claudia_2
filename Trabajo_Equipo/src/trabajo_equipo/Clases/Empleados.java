package trabajo_equipo.Clases;

public class Empleados extends Personas{
    String horario;
    int numerovendidos;

    public Empleados() {
        super();
    }

    public Empleados(String horario, int numerovendidos) {
        this.horario = horario;
        this.numerovendidos = numerovendidos;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getNumerovendidos() {
        return numerovendidos;
    }

    public void setNumerovendidos(int numerovendidos) {
        this.numerovendidos = numerovendidos;
    }
    
    
}
