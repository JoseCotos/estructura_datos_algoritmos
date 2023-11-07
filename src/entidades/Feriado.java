package entidades;

public class Feriado {
    private int idFeriado;
    private int ferMes;
    private int ferDiaSemana;
    private String ferTipo;
    private String ferDescripcion;

    public Feriado(int idFeriado, int ferMes, int ferDiaSemana, String ferTipo, String ferDescripcion) {
        this.idFeriado = idFeriado;
        this.ferMes = ferMes;
        this.ferDiaSemana = ferDiaSemana;
        this.ferTipo = ferTipo;
        this.ferDescripcion = ferDescripcion;
    }

    public Feriado() {
    }

    public int getIdFeriado() {
        return idFeriado;
    }

    public void setIdFeriado(int idFeriado) {
        this.idFeriado = idFeriado;
    }

    public int getFerMes() {
        return ferMes;
    }

    public void setFerMes(int ferMes) {
        this.ferMes = ferMes;
    }

    public int getFerDiaSemana() {
        return ferDiaSemana;
    }

    public void setFerDiaSemana(int ferDiaSemana) {
        this.ferDiaSemana = ferDiaSemana;
    }

    public String getFerTipo() {
        return ferTipo;
    }

    public void setFerTipo(String ferTipo) {
        this.ferTipo = ferTipo;
    }

    public String getFerDescripcion() {
        return ferDescripcion;
    }

    public void setFerDescripcion(String ferDescripcion) {
        this.ferDescripcion = ferDescripcion;
    }
}
