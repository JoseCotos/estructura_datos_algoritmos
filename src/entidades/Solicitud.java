package entidades;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;

public class Solicitud {
    private int idSolicitud;
    private String solTipo;
    private LocalDate solFecha;
    private String solDescripcion;
    private String solEstado; // PENDIENTE, ACEPTADO, RECHAZADO
    private int idPersona;
    private LocalDate solFechaRegistro;

    private LinkedList<Solicitud> colSolicitud;

    private final String ESTADO_PENDIENTE = "PENDIENTE";
    private final String ESTADO_ACEPTADO = "ACEPTADO";
    private final String ESTADO_RECHAZADO = "RECHAZADO";

    public Solicitud() {
    }

    public void llenarDatosIniciales(){
        colSolicitud = new LinkedList<Solicitud>();
        Solicitud solicitud;

        solicitud = new Solicitud(1,"HE",LocalDate.of(2023,11,13),"Informe para administracion","ACEPTADO",1, LocalDate.of(2023,11,13)); colSolicitud.add(solicitud);
        solicitud = new Solicitud(2,"HE",LocalDate.of(2023,11,14),"Reporte para tesoreria","ACEPTADO",1, LocalDate.of(2023,11,14)); colSolicitud.add(solicitud);
        solicitud = new Solicitud(3,"HE",LocalDate.of(2023,11,15),"informe para contabilidad","PENDIENTE",1, LocalDate.of(2023,11,15)); colSolicitud.add(solicitud);
        solicitud = new Solicitud(4,"HE",LocalDate.of(2023,11,16),"Trabajo pendiente","ACEPTADO",1, LocalDate.of(2023,11,16)); colSolicitud.add(solicitud);
        solicitud = new Solicitud(5,"HE",LocalDate.of(2023,11,13),"Informe para TIC","ACEPTADO",2, LocalDate.of(2023,11,13)); colSolicitud.add(solicitud);
        solicitud = new Solicitud(6,"HE",LocalDate.of(2023,11,14),"Reporte para tesoreria","PENDIENTE",2, LocalDate.of(2023,11,14)); colSolicitud.add(solicitud);
        solicitud = new Solicitud(7,"HE",LocalDate.of(2023,11,13),"Informe para eventos","ACEPTADO",3, LocalDate.of(2023,11,13)); colSolicitud.add(solicitud);
        solicitud = new Solicitud(8,"HE",LocalDate.of(2023,11,14),"Participar en el evento","RECHAZADO",3, LocalDate.of(2023,11,14)); colSolicitud.add(solicitud);
    }

    public Solicitud(int idSolicitud, String solTipo, LocalDate solFecha, String solDescripcion, String solEstado, int idPersona, LocalDate solFechaRegistro) {
        this.idSolicitud = idSolicitud;
        this.solTipo = solTipo;
        this.solFecha = solFecha;
        this.solDescripcion = solDescripcion;
        this.solEstado = solEstado;
        this.idPersona = idPersona;
        this.solFechaRegistro = solFechaRegistro;
    }

    public Solicitud(int idSolicitud, LocalDate solFecha, String solDescripcion, int idPersona) {
        this.idSolicitud = idSolicitud;
        this.solFecha = solFecha;
        this.solDescripcion = solDescripcion;
        this.idPersona = idPersona;
        this.solTipo = "HE";
        this.solEstado = ESTADO_PENDIENTE;
        this.solFechaRegistro = LocalDate.now();
    }

    /**
     *
     * @param tipo
     *      1: Pendientes
     *      2: Atendidos
     *      3: Rechazados
     * @return
     */
    public LinkedList<Solicitud> obtenerSolicitudes(int tipo){
        LinkedList<Solicitud> tmpSol = new LinkedList<Solicitud>();
        for (Solicitud sol : getColSolicitud()){
            if (tipo == 1 && sol.getSolEstado().equalsIgnoreCase(ESTADO_PENDIENTE)){
                tmpSol.add(sol);
            } else if (tipo == 2 && sol.getSolEstado().equalsIgnoreCase(ESTADO_ACEPTADO)){
                tmpSol.add(sol);
            } else if (tipo == 3 && sol.getSolEstado().equalsIgnoreCase(ESTADO_RECHAZADO)){
                tmpSol.add(sol);
            }
        }

        return tmpSol;
    }

    public boolean atenderSolicitud(int nroSolicitud, int condicion){
        boolean sw = false;
        String estado = "";
        if (condicion == 1) estado = ESTADO_ACEPTADO; else estado = ESTADO_RECHAZADO;
        for (Solicitud sol : getColSolicitud()){
            if (sol.getIdSolicitud() == nroSolicitud && sol.getSolEstado().equalsIgnoreCase(ESTADO_PENDIENTE)){
                sol.setSolEstado(estado);
                sw = true;
                break;
            }
        }
        return sw;
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

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "idSolicitud=" + idSolicitud +
                ", solTipo='" + solTipo + '\'' +
                ", solFecha=" + solFecha +
                ", solDescripcion='" + solDescripcion + '\'' +
                ", solEstado='" + solEstado + '\'' +
                ", idPersona=" + idPersona +
                ", solFechaRegistro=" + solFechaRegistro +
                '}';
    }
}
