package entidades;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;

public class Asistencia {
    private int idAsistencia;
    private LocalDate asiFecEntrada;
    private String asiHorEntrada;
    private LocalDate asiFecSalida;
    private String asiHorSalida;
    private boolean asiSwAutoTardanza;
    private boolean asiSwAutoHoraExtra;
    private boolean asiSwAutoPermiso;
    private boolean asiSwAutoCompensacion;
    private boolean asiSwHoraTrabajada;
    private boolean asiSwHoraRealTrabajada;
    private LinkedList<Asistencia> colAsistencia;

    public Asistencia(int idAsistencia, LocalDate asiFecEntrada, String asiHorEntrada, LocalDate asiFecSalida, String asiHorSalida, boolean asiSwAutoTardanza, boolean asiSwAutoHoraExtra, boolean asiSwAutoPermiso, boolean asiSwAutoCompensacion, boolean asiSwHoraTrabajada, boolean asiSwHoraRealTrabajada) {
        this.idAsistencia = idAsistencia;
        this.asiFecEntrada = asiFecEntrada;
        this.asiHorEntrada = asiHorEntrada;
        this.asiFecSalida = asiFecSalida;
        this.asiHorSalida = asiHorSalida;
        this.asiSwAutoTardanza = asiSwAutoTardanza;
        this.asiSwAutoHoraExtra = asiSwAutoHoraExtra;
        this.asiSwAutoPermiso = asiSwAutoPermiso;
        this.asiSwAutoCompensacion = asiSwAutoCompensacion;
        this.asiSwHoraTrabajada = asiSwHoraTrabajada;
        this.asiSwHoraRealTrabajada = asiSwHoraRealTrabajada;
    }

    public Asistencia() {
    }

    public void llenarDatosIniciales(){
        colAsistencia = new LinkedList<Asistencia>();
        Asistencia asistencia;

        asistencia = new Asistencia(1,LocalDate.of(2023,11,2),"08:00",LocalDate.of(2023,11,2),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(2,LocalDate.of(2023,11,3),"08:00",LocalDate.of(2023,11,3),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(3,LocalDate.of(2023,11,6),"08:00",LocalDate.of(2023,11,6),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(4,LocalDate.of(2023,11,7),"08:00",LocalDate.of(2023,11,7),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(5,LocalDate.of(2023,11,8),"08:00",LocalDate.of(2023,11,8),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(6,LocalDate.of(2023,11,9),"08:00",LocalDate.of(2023,11,9),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(7,LocalDate.of(2023,11,10),"08:00",LocalDate.of(2023,11,10),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(8,LocalDate.of(2023,11,13),"08:00",LocalDate.of(2023,11,13),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(9,LocalDate.of(2023,11,14),"08:00",LocalDate.of(2023,11,14),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(10,LocalDate.of(2023,11,15),"08:00",LocalDate.of(2023,11,15),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(11,LocalDate.of(2023,11,16),"08:00",LocalDate.of(2023,11,16),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(12,LocalDate.of(2023,11,17),"08:00",LocalDate.of(2023,11,17),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(13,LocalDate.of(2023,11,20),"08:00",LocalDate.of(2023,11,20),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(14,LocalDate.of(2023,11,21),"08:00",LocalDate.of(2023,11,21),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(15,LocalDate.of(2023,11,22),"08:00",LocalDate.of(2023,11,22),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(16,LocalDate.of(2023,11,23),"08:00",LocalDate.of(2023,11,23),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(17,LocalDate.of(2023,11,24),"08:00",LocalDate.of(2023,11,24),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(18,LocalDate.of(2023,11,27),"08:00",LocalDate.of(2023,11,27),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(19,LocalDate.of(2023,11,28),"08:00",LocalDate.of(2023,11,28),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(20,LocalDate.of(2023,11,29),"08:00",LocalDate.of(2023,11,29),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(21,LocalDate.of(2023,11,30),"08:00",LocalDate.of(2023,11,30),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(22,LocalDate.of(2023,12,1),"08:00",LocalDate.of(2023,12,1),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(23,LocalDate.of(2023,12,4),"08:00",LocalDate.of(2023,12,4),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(24,LocalDate.of(2023,12,5),"08:00",LocalDate.of(2023,12,5),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(25,LocalDate.of(2023,12,6),"08:00",LocalDate.of(2023,12,6),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(26,LocalDate.of(2023,12,7),"08:00",LocalDate.of(2023,12,7),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(27,LocalDate.of(2023,12,8),"08:00",LocalDate.of(2023,12,8),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(28,LocalDate.of(2023,12,11),"08:00",LocalDate.of(2023,12,11),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(29,LocalDate.of(2023,12,12),"08:00",LocalDate.of(2023,12,12),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(30,LocalDate.of(2023,12,13),"08:00",LocalDate.of(2023,12,13),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(31,LocalDate.of(2023,12,14),"08:00",LocalDate.of(2023,12,14),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
        asistencia = new Asistencia(32,LocalDate.of(2023,12,15),"08:00",LocalDate.of(2023,12,15),"17:00",false,false,false,false,false,false); colAsistencia.add(asistencia);
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "idAsistencia=" + idAsistencia +
                ", asiFecEntrada=" + asiFecEntrada +
                ", asiHorEntrada='" + asiHorEntrada + '\'' +
                ", asiFecSalida=" + asiFecSalida +
                ", asiHorSalida='" + asiHorSalida + '\'' +
                ", asiSwAutoTardanza=" + asiSwAutoTardanza +
                ", asiSwAutoHoraExtra=" + asiSwAutoHoraExtra +
                ", asiSwAutoPermiso=" + asiSwAutoPermiso +
                ", asiSwAutoCompensacion=" + asiSwAutoCompensacion +
                ", asiSwHoraTrabajada=" + asiSwHoraTrabajada +
                ", asiSwHoraRealTrabajada=" + asiSwHoraRealTrabajada +
                ", colAsistencia=" + colAsistencia +
                '}';
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public LocalDate getAsiFecEntrada() {
        return asiFecEntrada;
    }

    public void setAsiFecEntrada(LocalDate asiFecEntrada) {
        this.asiFecEntrada = asiFecEntrada;
    }

    public String getAsiHorEntrada() {
        return asiHorEntrada;
    }

    public void setAsiHorEntrada(String asiHorEntrada) {
        this.asiHorEntrada = asiHorEntrada;
    }

    public LocalDate getAsiFecSalida() {
        return asiFecSalida;
    }

    public void setAsiFecSalida(LocalDate asiFecSalida) {
        this.asiFecSalida = asiFecSalida;
    }

    public String getAsiHorSalida() {
        return asiHorSalida;
    }

    public void setAsiHorSalida(String asiHorSalida) {
        this.asiHorSalida = asiHorSalida;
    }

    public boolean isAsiSwAutoTardanza() {
        return asiSwAutoTardanza;
    }

    public void setAsiSwAutoTardanza(boolean asiSwAutoTardanza) {
        this.asiSwAutoTardanza = asiSwAutoTardanza;
    }

    public boolean isAsiSwAutoHoraExtra() {
        return asiSwAutoHoraExtra;
    }

    public void setAsiSwAutoHoraExtra(boolean asiSwAutoHoraExtra) {
        this.asiSwAutoHoraExtra = asiSwAutoHoraExtra;
    }

    public boolean isAsiSwAutoPermiso() {
        return asiSwAutoPermiso;
    }

    public void setAsiSwAutoPermiso(boolean asiSwAutoPermiso) {
        this.asiSwAutoPermiso = asiSwAutoPermiso;
    }

    public boolean isAsiSwAutoCompensacion() {
        return asiSwAutoCompensacion;
    }

    public void setAsiSwAutoCompensacion(boolean asiSwAutoCompensacion) {
        this.asiSwAutoCompensacion = asiSwAutoCompensacion;
    }

    public boolean isAsiSwHoraTrabajada() {
        return asiSwHoraTrabajada;
    }

    public void setAsiSwHoraTrabajada(boolean asiSwHoraTrabajada) {
        this.asiSwHoraTrabajada = asiSwHoraTrabajada;
    }

    public boolean isAsiSwHoraRealTrabajada() {
        return asiSwHoraRealTrabajada;
    }

    public void setAsiSwHoraRealTrabajada(boolean asiSwHoraRealTrabajada) {
        this.asiSwHoraRealTrabajada = asiSwHoraRealTrabajada;
    }

    public LinkedList<Asistencia> getColAsistencia() {
        return colAsistencia;
    }

    public void setColAsistencia(LinkedList<Asistencia> colAsistencia) {
        this.colAsistencia = colAsistencia;
    }
}
