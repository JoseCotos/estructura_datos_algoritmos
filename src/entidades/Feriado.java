package entidades;

import java.util.LinkedList;

public class Feriado {
    private int idFeriado;
    private int ferMes;
    private int ferDiaSemana;
    private String ferTipo;
    private String ferDescripcion;
    private LinkedList<Feriado> colFeriado;

    public Feriado(int idFeriado, int ferMes, int ferDiaSemana, String ferTipo, String ferDescripcion) {
        this.idFeriado = idFeriado;
        this.ferMes = ferMes;
        this.ferDiaSemana = ferDiaSemana;
        this.ferTipo = ferTipo;
        this.ferDescripcion = ferDescripcion;
    }

    public Feriado() {

    }

    public void llenarDatosIniciales(){
        colFeriado = new LinkedList<Feriado>();
        Feriado feriado;

        feriado = new Feriado(1,1,1,"D","Año Nuevo"); colFeriado.add(feriado);
        feriado = new Feriado(2,4,6,"D","Jueves Santo"); colFeriado.add(feriado);
        feriado = new Feriado(3,4,7,"D","Viernes Santo"); colFeriado.add(feriado);
        feriado = new Feriado(4,5,1,"D","Día del Trabajo"); colFeriado.add(feriado);
        feriado = new Feriado(5,6,29,"D","Día de San Pedro y San Pablo"); colFeriado.add(feriado);
        feriado = new Feriado(6,7,28,"D","Fiestas Patrias"); colFeriado.add(feriado);
        feriado = new Feriado(7,7,29,"D","Fiestas Patrias"); colFeriado.add(feriado);
        feriado = new Feriado(8,8,6,"D","Batalla de Junin"); colFeriado.add(feriado);
        feriado = new Feriado(9,8,30,"D","Día de Santa Rosa de Lima"); colFeriado.add(feriado);
        feriado = new Feriado(10,10,8,"D","Combate de Angamos"); colFeriado.add(feriado);
        feriado = new Feriado(11,11,1,"D","Día de Todos los Santos"); colFeriado.add(feriado);
        feriado = new Feriado(12,12,1,"D","Día de la Inmaculada Concepción"); colFeriado.add(feriado);
        feriado = new Feriado(13,12,9,"D","Batalla de Ayacucho"); colFeriado.add(feriado);
        feriado = new Feriado(14,12,25,"D","Navidad"); colFeriado.add(feriado);
    }

    @Override
    public String toString() {
        return "Feriado{" +
                "idFeriado=" + idFeriado +
                ", ferMes=" + ferMes +
                ", ferDiaSemana=" + ferDiaSemana +
                ", ferTipo='" + ferTipo + '\'' +
                ", ferDescripcion='" + ferDescripcion + '\'' +
                ", colFeriado=" + colFeriado +
                '}';
    }

    public LinkedList<Feriado> getColFeriado() {
        return colFeriado;
    }

    public void setColFeriado(LinkedList<Feriado> colFeriado) {
        this.colFeriado = colFeriado;
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
