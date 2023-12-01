package entidades;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;

public class Personal {
    private int idPersonal;
    private String perNombre;
    private String perApellido;
    private String perTipoDoc;
    private String perNroDoc;
    private int perPerfil;
    private String perUsuario;
    private String perClave;
    private LocalDate perFecIngreso;
    private int perNroHijos;
    private double perSueldoBasico;
    private String perCargo;
    private String perNombreAFP;

    private LinkedList<Personal> colPersonal;


    public Personal(int idPersonal, String perNombre, String perApellido, String perTipoDoc, String perNroDoc, int perPerfil, String perUsuario, String perClave, LocalDate perFecIngreso, int perNroHijos, double perSueldoBasico, String perCargo, String perNombreAFP) {
        this.idPersonal = idPersonal;
        this.perNombre = perNombre;
        this.perApellido = perApellido;
        this.perTipoDoc = perTipoDoc;
        this.perNroDoc = perNroDoc;
        this.perPerfil = perPerfil;
        this.perUsuario = perUsuario;
        this.perClave = perClave;
        this.perFecIngreso = perFecIngreso;
        this.perNroHijos = perNroHijos;
        this.perSueldoBasico = perSueldoBasico;
        this.perCargo = perCargo;
        this.perNombreAFP = perNombreAFP;
    }

    public Personal() {
    }

    public void llenarDatosIniciales(){
        colPersonal = new LinkedList<Personal>();
        Personal personal;

        personal = new Personal(1,"Jose","Cotos Conde",          "DNI","40041899",1,"user1" ,"505050",LocalDate.of(2022,11,15),2,5500,"DBA Oracle","Integra"); colPersonal.add(personal);
        personal = new Personal(2,"Manuel","Lescano Requena",    "DNI","76638828",2,"user2" ,"404040",LocalDate.of(2022,10,10),0,4500,"Programador Senior","Prima"); colPersonal.add(personal);
        personal = new Personal(3,"Pedro","Ramos Rojas",         "DNI","76638828",2,"user3" ,"404040",LocalDate.of(2022,10,10),2,4500,"Analista Funcional","Prima"); colPersonal.add(personal);
        personal = new Personal(4,"Gianfranco","Guanilo Perez",  "CE" ,"14212821",2,"user4" ,"505050",LocalDate.of(2022,11,15),0,3500,"Progrmador Semi-Senior","Integra"); colPersonal.add(personal);
        personal = new Personal(5,"Roberto","Serna remirez",     "DNI","76638828",2,"user5" ,"404040",LocalDate.of(2022,10,10),2,2500,"Soporte Técnico","Prima"); colPersonal.add(personal);
        personal = new Personal(6,"Rodrigo","Tamallo Escobar",   "DNI","76681448",2,"user6" ,"505050",LocalDate.of(2022,11,15),0,2500,"Soporte Técnico","Integra"); colPersonal.add(personal);
        personal = new Personal(7,"Esther","Justo Perez",        "DNI","76638828",2,"user7" ,"404040",LocalDate.of(2022,10,10),2,2500,"WebMaster","Prima"); colPersonal.add(personal);
        personal = new Personal(8,"Olinda","Romero Carranza",    "DNI","76681448",2,"user8" ,"505050",LocalDate.of(2022,11,15),0,2000,"Secretaria Ejecutiva","Integra"); colPersonal.add(personal);
        personal = new Personal(9,"Alvaro","Veliz Figueroa",     "DNI","76638828",2,"user9" ,"404040",LocalDate.of(2022,10,10),2,1500,"Ejecutiva Ventas","Prima"); colPersonal.add(personal);
        personal = new Personal(10,"Esteban","Rosa Murguia",     "DNI","76681448",2,"user10","505050",LocalDate.of(2022,11,15),0,1500,"Ejecutiva Ventas","Integra"); colPersonal.add(personal);
    }

    public Personal obtenerIdPersona(String usuario, String pwd){
        Personal tmpPer = null;
        for (Personal per : colPersonal){
            if (per.getPerUsuario().compareToIgnoreCase(usuario) == 0){
                if (per.getPerClave().compareToIgnoreCase(pwd) == 0){
                    tmpPer = per;
                    break;
                }
            }
        }
        return tmpPer;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public String getPerTipoDoc() {
        return perTipoDoc;
    }

    public void setPerTipoDoc(String perTipoDoc) {
        this.perTipoDoc = perTipoDoc;
    }

    public String getPerNroDoc() {
        return perNroDoc;
    }

    public void setPerNroDoc(String perNroDoc) {
        this.perNroDoc = perNroDoc;
    }

    public String getPerUsuario() {
        return perUsuario;
    }

    public void setPerUsuario(String perUsuario) {
        this.perUsuario = perUsuario;
    }

    public String getPerClave() {
        return perClave;
    }

    public void setPerClave(String perClave) {
        this.perClave = perClave;
    }

    public LocalDate getPerFecIngreso() {
        return perFecIngreso;
    }

    public void setPerFecIngreso(LocalDate perFecIngreso) {
        this.perFecIngreso = perFecIngreso;
    }

    public int getPerNroHijos() {
        return perNroHijos;
    }

    public void setPerNroHijos(int perNroHijos) {
        this.perNroHijos = perNroHijos;
    }

    public double getPerSueldoBasico() {
        return perSueldoBasico;
    }

    public void setPerSueldoBasico(double perSueldoBasico) {
        this.perSueldoBasico = perSueldoBasico;
    }

    public String getPerCargo() {
        return perCargo;
    }

    public void setPerCargo(String perCargo) {
        this.perCargo = perCargo;
    }

    public String getPerNombreAFP() {
        return perNombreAFP;
    }

    public void setPerNombreAFP(String perNombreAFP) {
        this.perNombreAFP = perNombreAFP;
    }

    public LinkedList<Personal> getColPersonal() {
        return colPersonal;
    }

    public void setColPersonal(LinkedList<Personal> colPersonal) {
        this.colPersonal = colPersonal;
    }

    public int getPerPerfil() {
        return perPerfil;
    }

    public void setPerPerfil(int perPerfil) {
        this.perPerfil = perPerfil;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "idPersonal=" + idPersonal +
                ", perNombre='" + perNombre + '\'' +
                ", perApellido='" + perApellido + '\'' +
                ", perTipoDoc='" + perTipoDoc + '\'' +
                ", perNroDoc='" + perNroDoc + '\'' +
                ", perUsuario='" + perUsuario + '\'' +
                ", perClave='" + perClave + '\'' +
                ", perFecIngreso=" + perFecIngreso +
                ", perNroHijos=" + perNroHijos +
                ", perSueldoBasico=" + perSueldoBasico +
                ", perCargo='" + perCargo + '\'' +
                ", perNombreAFP='" + perNombreAFP + '\'' +
                '}';
    }
}
