package entidades;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;

public class Solicitud {
    private int idSolicitud;
    private String solTipo;
    private LocalDate solFecha;
    private String solDescripcion;
    private String solEstado;

    private LinkedList<Solicitud> colSolicitud;

    public Solicitud() {
    }


    public void llenarDatosIniciales(){
        colSolicitud = new LinkedList<Solicitud>();
        Solicitud solicitud;

        solicitud = new Solicitud(1,"Justificacion de tarzanda",LocalDate.of(2022,10,10),"Cita médica","Aceptado"); colSolicitud.add(solicitud);
        solicitud = new Solicitud(2,"Justificacion de falta",LocalDate.of(2022,11,10),"Descanso médico","Aceptado"); colSolicitud.add(solicitud);
        solicitud = new Solicitud(3,"Justificacion de tarzanda",LocalDate.of(2022,11,11),"Cita médica","Aceptado"); colSolicitud.add(solicitud);
        solicitud = new Solicitud(4,"Justificacion de falta",LocalDate.of(2022,11,12),"Descanso médico","Aceptado"); colSolicitud.add(solicitud);
        solicitud = new Solicitud(5,"Justificacion de tarzanda",LocalDate.of(2022,11,13),"Cita médica","Aceptado"); colSolicitud.add(solicitud);
        solicitud = new Solicitud(6,"Justificacion de falta",LocalDate.of(2022,11,14),"Descanso médico","Aceptado"); colSolicitud.add(solicitud);
        solicitud = new Solicitud(7,"Justificacion de tarzanda",LocalDate.of(2022,11,15),"Cita médica","Aceptado"); colSolicitud.add(solicitud);
        solicitud = new Solicitud(8,"Justificacion de falta",LocalDate.of(2022,11,16),"Descanso médico","Aceptado"); colSolicitud.add(solicitud);
    }

    public Solicitud(int idSolicitud, String solTipo, LocalDate solFecha, String solDescripcion, String solEstado) {
        this.idSolicitud = idSolicitud;
        this.solTipo = solTipo;
        this.solFecha = solFecha;
        this.solDescripcion = solDescripcion;
        this.solEstado = solEstado;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getSolTipo() {
        return solTipo;
    }

    public void setSolTipo(String solTipo) {
        this.solTipo = solTipo;
    }

    public LocalDate getSolFecha() {
        return solFecha;
    }

    public void setSolFecha(LocalDate solFecha) {
        this.solFecha = solFecha;
    }

    public String getSolDescripcion() {
        return solDescripcion;
    }

    public void setSolDescripcion(String solDescripcion) {
        this.solDescripcion = solDescripcion;
    }

    public String getSolEstado() {
        return solEstado;
    }

    public void setSolEstado(String solEstado) {
        this.solEstado = solEstado;
    }

    public LinkedList<Solicitud> getColSolicitud() {
        return colSolicitud;
    }

    public void setColSolicitud(LinkedList<Solicitud> colSolicitud) {
        this.colSolicitud = colSolicitud;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "idSolicitud=" + idSolicitud +
                ", solTipo='" + solTipo + '\'' +
                ", solFecha=" + solFecha +
                ", solDescripcion='" + solDescripcion + '\'' +
                ", solEstado='" + solEstado + '\'' +
                '}';
    }
}
