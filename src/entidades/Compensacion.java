package entidades;

import java.time.LocalDate;
import java.util.LinkedList;

public class Compensacion {
    private int idCompensacion;
    private LocalDate comFecha;
    private int comMinutos;
    private LocalDate comFechaHE;
    private int comMinnutosHE;
    private boolean comSubsanado;
    private int idPersona;

    private LinkedList<Compensacion> colCompensacion;


    public Compensacion() {
    }

    public void llenarDatosIniciales() {
        /*
        colFeriado = new LinkedList<Feriado>();
        Feriado feriado;

        feriado = new Feriado(1,1,1,"D","Año Nuevo"); colFeriado.add(feriado);
         */


        colCompensacion = new LinkedList<Compensacion>();
        Compensacion compensacion;

        compensacion = new Compensacion(1,null,0,LocalDate.of(2023,11,2),150,false,1 ); colCompensacion.add(compensacion);
        compensacion = new Compensacion(2,null,0,LocalDate.of(2023,11,2),120,false,2 ); colCompensacion.add(compensacion);
        compensacion = new Compensacion(3,null,0,LocalDate.of(2023,11,3),90,false,1 ); colCompensacion.add(compensacion);
        compensacion = new Compensacion(4,null,0,LocalDate.of(2023,11,3),130,false,2 ); colCompensacion.add(compensacion);
        compensacion = new Compensacion(5,null,0,LocalDate.of(2023,11,3),150,false,3 ); colCompensacion.add(compensacion);
        compensacion = new Compensacion(6,null,0,LocalDate.of(2023,11,6),180,false,1 ); colCompensacion.add(compensacion);
        compensacion = new Compensacion(7,null,0,LocalDate.of(2023,11,6),100,false,2 ); colCompensacion.add(compensacion);
        compensacion = new Compensacion(8,null,0,LocalDate.of(2023,11,6),110,false,3 ); colCompensacion.add(compensacion);
        compensacion = new Compensacion(9,null,0,LocalDate.of(2023,11,7),120,false,2 ); colCompensacion.add(compensacion);
        compensacion = new Compensacion(10,null,0,LocalDate.of(2023,11,7),120,false,3 ); colCompensacion.add(compensacion);


    }

    public Compensacion(int idCompensacion, LocalDate comFecha, int comMinutos, LocalDate comFechaHE, int comMinnutosHE, boolean comSubsanado, int idPersona) {
        this.idCompensacion = idCompensacion;
        this.comFecha = comFecha;
        this.comMinutos = comMinutos;
        this.comFechaHE = comFechaHE;
        this.comMinnutosHE = comMinnutosHE;
        this.comSubsanado = comSubsanado;
        this.idPersona = idPersona;
    }

    public int getIdCompensacion() {
        return idCompensacion;
    }

    public void setIdCompensacion(int idCompensacion) {
        this.idCompensacion = idCompensacion;
    }

    public LocalDate getComFecha() {
        return comFecha;
    }

    public void setComFecha(LocalDate comFecha) {
        this.comFecha = comFecha;
    }

    public int getComMinutos() {
        return comMinutos;
    }

    public void setComMinutos(int comMinutos) {
        this.comMinutos = comMinutos;
    }

    public LocalDate getComFechaHE() {
        return comFechaHE;
    }

    public void setComFechaHE(LocalDate comFechaHE) {
        this.comFechaHE = comFechaHE;
    }

    public int getComMinnutosHE() {
        return comMinnutosHE;
    }

    public void setComMinnutosHE(int comMinnutosHE) {
        this.comMinnutosHE = comMinnutosHE;
    }


    public void setComSubsanado(boolean comSubsanado) {
        this.comSubsanado = comSubsanado;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }


    public boolean isComSubsanado() {
        return comSubsanado;
    }

    public LinkedList<Compensacion> getColCompensacion() {
        return colCompensacion;
    }

    public void setColCompensacion(LinkedList<Compensacion> colCompensacion) {
        this.colCompensacion = colCompensacion;
    }

    @Override
    public String toString() {
        return "Compensacion{" +
                "idCompensacion=" + idCompensacion +
                ", comFecha=" + comFecha +
                ", comMinutos=" + comMinutos +
                ", comFechaHE=" + comFechaHE +
                ", comMinnutosHE=" + comMinnutosHE +
                ", comSubsanado=" + comSubsanado +
                ", idPersona=" + idPersona +
                ", colCompensacion=" + colCompensacion +
                '}';
    }
}
