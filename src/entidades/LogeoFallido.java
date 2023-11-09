package entidades;

import java.time.LocalDate;
import java.util.LinkedList;

public class LogeoFallido {
    private int idLogeoFallido;
    private LocalDate logfFecha;
    private String logfDescripcion;

    private LinkedList<LogeoFallido> colLogeoFallido;


    public LogeoFallido(int idLogeoFallido, LocalDate logfFecha, String logfDescripcion) {
        this.idLogeoFallido = idLogeoFallido;
        this.logfFecha = logfFecha;
        this.logfDescripcion = logfDescripcion;
    }

    public LogeoFallido() {
    }


    public void llenarDatosIniciales(){
        /*
        colFeriado = new LinkedList<Feriado>();
        Feriado feriado;

        feriado = new Feriado(1,1,1,"D","Año Nuevo"); colFeriado.add(feriado);
         */

        colLogeoFallido = new LinkedList<LogeoFallido>();
        LogeoFallido logeoFallido;

        logeoFallido = new LogeoFallido(1,LocalDate.of(2023,11,2),"Error de sesion"); colLogeoFallido.add(logeoFallido);
        logeoFallido = new LogeoFallido(2,LocalDate.of(2023,11,2),"Error de sesion"); colLogeoFallido.add(logeoFallido);
        logeoFallido = new LogeoFallido(3,LocalDate.of(2023,11,3),"Error de sesion"); colLogeoFallido.add(logeoFallido);
        logeoFallido = new LogeoFallido(4,LocalDate.of(2023,11,3),"Error de sesion"); colLogeoFallido.add(logeoFallido);
        logeoFallido = new LogeoFallido(5,LocalDate.of(2023,11,3),"Error de sesion"); colLogeoFallido.add(logeoFallido);
        logeoFallido = new LogeoFallido(6,LocalDate.of(2023,11,6),"Error de sesion"); colLogeoFallido.add(logeoFallido);
        logeoFallido = new LogeoFallido(7,LocalDate.of(2023,11,7),"Error de sesion"); colLogeoFallido.add(logeoFallido);
        logeoFallido = new LogeoFallido(8,LocalDate.of(2023,11,7),"Error de sesion"); colLogeoFallido.add(logeoFallido);
        logeoFallido = new LogeoFallido(9,LocalDate.of(2023,11,7),"Error de sesion"); colLogeoFallido.add(logeoFallido);
        logeoFallido = new LogeoFallido(10,LocalDate.of(2023,11,7),"Error de sesion"); colLogeoFallido.add(logeoFallido);





    }


        @Override
    public String toString() {
        return "LogeoFallido{" +
                "idLogeoFallido=" + idLogeoFallido +
                ", logfFecha=" + logfFecha +
                ", logfDescripcion='" + logfDescripcion + '\'' +
                '}';
    }

    public int getIdLogeoFallido() {
        return idLogeoFallido;
    }

    public void setIdLogeoFallido(int idLogeoFallido) {
        this.idLogeoFallido = idLogeoFallido;
    }

    public LocalDate getLogfFecha() {
        return logfFecha;
    }

    public void setLogfFecha(LocalDate logfFecha) {
        this.logfFecha = logfFecha;
    }

    public String getLogfDescripcion() {
        return logfDescripcion;
    }

    public void setLogfDescripcion(String logfDescripcion) {
        this.logfDescripcion = logfDescripcion;
    }

    public LinkedList<LogeoFallido> getColLogeoFallido() {
        return colLogeoFallido;
    }

    public void setColLogeoFallido(LinkedList<LogeoFallido> colLogeoFallido) {
        this.colLogeoFallido = colLogeoFallido;
    }
}
