package entidades;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;

public class Personal {
    private int idPersonal;
    private String perNombre;
    private String perApellido;
    private String perTipoDoc;
    private int perNroDoc;
    private int perUsuario;
    private int perClave;
    private LocalDate FecRegistro;

    private LocalDate FecIngreso;
    private LocalDate FecEgreso;

    private LinkedList<Personal> colPersonal;


    public void llenarDatosIniciales(){
        colPersonal = new LinkedList<Personal>();
        Personal personal;

        personal = new Personal(1,"José Manuel","Lescano Requena","DNI",76638828,000001,404040,LocalDate.of(2022,10,10), LocalDate.of(2022,10,10),LocalDate.of(2023,10,10)); colPersonal.add(personal);
        personal = new Personal(2,"Oscar","Salazar Rojas","DNI",76681448,000002,505050,LocalDate.of(2022,11,15), LocalDate.of(2022,11,12),LocalDate.of(2023,11,18)); colPersonal.add(personal);
        personal = new Personal(3,"Pedro","Ramos Rojas","DNI",76638828,000001,404040,LocalDate.of(2022,10,10), LocalDate.of(2022,10,13),LocalDate.of(2023,7,10)); colPersonal.add(personal);
        personal = new Personal(4,"Gianfranco","Guanilo Perez","CE",1421282,000002,505050,LocalDate.of(2022,11,15), LocalDate.of(2022,11,14),LocalDate.of(2023,8,20)); colPersonal.add(personal);
        personal = new Personal(5,"Roberto","Serna remirez","DNI",76638828,000001,704040,LocalDate.of(2022,10,10), LocalDate.of(2022,10,15),LocalDate.of(2023,9,23)); colPersonal.add(personal);
        personal = new Personal(6,"Rodrigo","Tamallo Escobar","DNI",76681448,000002,605050,LocalDate.of(2022,11,15), LocalDate.of(2022,11,16),LocalDate.of(2023,5,23)); colPersonal.add(personal);
        personal = new Personal(7,"Esther","Justo Perez","DNI",76638828,000001,804040,LocalDate.of(2022,10,10), LocalDate.of(2022,10,17),LocalDate.of(2023,4,30)); colPersonal.add(personal);
        personal = new Personal(8,"Olinda","Romero Carranza","DNI",76681448,000002,885050,LocalDate.of(2022,11,15), LocalDate.of(2022,11,18),LocalDate.of(2023,12,20)); colPersonal.add(personal);
        personal = new Personal(9,"Alvaro","Veliz Figueroa","DNI",76638828,000001,664040,LocalDate.of(2022,10,10), LocalDate.of(2022,10,10),LocalDate.of(2023,11,12)); colPersonal.add(personal);
        personal = new Personal(10,"Esteban","La Rosa Murguia","DNI",76681448,000002,775050,LocalDate.of(2022,11,15), LocalDate.of(2022,11,12),LocalDate.of(2023,3,19)); colPersonal.add(personal);


    }

    public Personal() {
    }

    public Personal(int idPersonal, String perNombre, String perApellido, String perTipoDoc, int perNroDoc, int perUsuario, int perClave, LocalDate fecRegistro, LocalDate fecIngreso, LocalDate fecEgreso) {
        this.idPersonal = idPersonal;
        this.perNombre = perNombre;
        this.perApellido = perApellido;
        this.perTipoDoc = perTipoDoc;
        this.perNroDoc = perNroDoc;
        this.perUsuario = perUsuario;
        this.perClave = perClave;
        FecRegistro = fecRegistro;
        FecIngreso = fecIngreso;
        FecEgreso = fecEgreso;
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

    public int getPerNroDoc() {
        return perNroDoc;
    }

    public void setPerNroDoc(int perNroDoc) {
        this.perNroDoc = perNroDoc;
    }

    public int getPerUsuario() {
        return perUsuario;
    }

    public void setPerUsuario(int perUsuario) {
        this.perUsuario = perUsuario;
    }

    public int getPerClave() {
        return perClave;
    }

    public void setPerClave(int perClave) {
        this.perClave = perClave;
    }

    public LocalDate getFecRegistro() {
        return FecRegistro;
    }

    public void setFecRegistro(LocalDate fecRegistro) {
        FecRegistro = fecRegistro;
    }

    public LocalDate getFecIngreso() {
        return FecIngreso;
    }

    public void setFecIngreso(LocalDate fecIngreso) {
        FecIngreso = fecIngreso;
    }

    public LocalDate getFecEgreso() {
        return FecEgreso;
    }

    public void setFecEgreso(LocalDate fecEgreso) {
        FecEgreso = fecEgreso;
    }

    public LinkedList<Personal> getColPersonal() {
        return colPersonal;
    }

    public void setColPersonal(LinkedList<Personal> colPersonal) {
        this.colPersonal = colPersonal;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "idPersonal=" + idPersonal +
                ", perNombre='" + perNombre + '\'' +
                ", perApellido='" + perApellido + '\'' +
                ", perTipoDoc='" + perTipoDoc + '\'' +
                ", perNroDoc=" + perNroDoc +
                ", perUsuario=" + perUsuario +
                ", perClave=" + perClave +
                ", FecRegistro=" + FecRegistro +
                ", FecIngreso=" + FecIngreso +
                ", FecEgreso=" + FecEgreso +
                ", colPersonal=" + colPersonal +
                '}';
    }
}
