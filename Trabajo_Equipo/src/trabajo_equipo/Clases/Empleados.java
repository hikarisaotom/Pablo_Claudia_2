package trabajo_equipo.Clases;

public class Empleados {
    String horario;
    int numerovendidos;

    public Empleados() {
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
