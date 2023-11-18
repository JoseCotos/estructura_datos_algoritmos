package entidades;

import java.time.LocalDate;
import java.util.LinkedList;

public class Planilla {
    private int idPlanilla;
    private LocalDate plaAlMesAnio;
    private int idPersona;
    private int plaDiasTrabajado;
    private double plaSueldoBasico;
    private double plaAsignacionFamiliar;
    private long plaTotalMinutoHoraExtra;
    private double plaImporteHoraExtra;
    private double plaGratificacion;
    private String plaNombreAFP;
    private double plaAporteFondo;
    private double plaPrimaSeguro;
    private double plaComision;
    private long plaTotalMinutoTardanza;
    private double plaDescuentoTardanza;
    private double plaQuintaCategoria;
    private double plaEsSalud;

    //otras variables
    private double remuneracionMV = 1025;

    private LinkedList<Planilla> colPlanilla;

    public Planilla(int idPlanilla, LocalDate plaAlMesAnio, int idPersona, int plaDiasTrabajado, double plaSueldoBasico, double plaAsignacionFamiliar, long plaTotalMinutoHoraExtra, double plaImporteHoraExtra, double plaGratificacion, String plaNombreAFP, double plaAporteFondo, double plaPrimaSeguro, double plaComision, long plaTotalMinutoTardanza, double plaDescuentoTardanza, double plaQuintaCategoria, double plaEsSalud) {
        this.idPlanilla = idPlanilla;
        this.plaAlMesAnio = plaAlMesAnio;
        this.idPersona = idPersona;
        this.plaDiasTrabajado = plaDiasTrabajado;
        this.plaSueldoBasico = plaSueldoBasico;
        this.plaAsignacionFamiliar = plaAsignacionFamiliar;
        this.plaTotalMinutoHoraExtra = plaTotalMinutoHoraExtra;
        this.plaImporteHoraExtra = plaImporteHoraExtra;
        this.plaGratificacion = plaGratificacion;
        this.plaNombreAFP = plaNombreAFP;
        this.plaAporteFondo = plaAporteFondo;
        this.plaPrimaSeguro = plaPrimaSeguro;
        this.plaComision = plaComision;
        this.plaTotalMinutoTardanza = plaTotalMinutoTardanza;
        this.plaDescuentoTardanza = plaDescuentoTardanza;
        this.plaQuintaCategoria = plaQuintaCategoria;
        this.plaEsSalud = plaEsSalud;
    }

    public Planilla() {
    }


    public void generarPlanilla(Personal personals, Asistencia asistencias, int anio, int nroMes){
        colPlanilla = new LinkedList<Planilla>();
        Planilla planilla;

        LocalDate tmpPlaAlMesAnio = LocalDate.of(anio,nroMes,1);
        int tmpDiasTrabajado = 0;
        double tmpAsiFamiliar = 0;
        long tmpTotalMinHE = 0;
        double tmpMontoMinHoraExtra = ((personals.getPerSueldoBasico()/30)/8)/60;
        double tmpMontoHE = 0;
        double tmpGratificacion = 0;


        for(Personal per : personals.getColPersonal()){
            tmpDiasTrabajado = asistencias.obtenerAsistenciaPersonaTotal(anio,nroMes,per.getIdPersonal());
            if (per.getPerNroHijos() > 0) tmpAsiFamiliar = remuneracionMV * 0.10;
            tmpMontoHE = tmpMontoMinHoraExtra * asistencias.getAsiMinutoHoraExtra();
            if(nroMes == 7 || nroMes == 12) tmpGratificacion = per.getPerSueldoBasico();

//                    planilla = new Planilla(1,getPlaAlMesAnio(),per.getIdPersonal(),tmpDiasTrabajado,per.getPerSueldoBasico(),tmpAsiFamiliar,tmpTotalMinHE,tmpMontoHE,tmpGratificacion,
//                            per.getPerNombreAFP(),0,1.84 * per.getPerSueldoBasico(),); colPlanilla.add(planilla);

        }

    }

    public int getIdPlanilla() {
        return idPlanilla;
    }

    public void setIdPlanilla(int idPlanilla) {
        this.idPlanilla = idPlanilla;
    }

    public LocalDate getPlaAlMesAnio() {
        return plaAlMesAnio;
    }

    public void setPlaAlMesAnio(LocalDate plaAlMesAnio) {
        this.plaAlMesAnio = plaAlMesAnio;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getPlaDiasTrabajado() {
        return plaDiasTrabajado;
    }

    public void setPlaDiasTrabajado(int plaDiasTrabajado) {
        this.plaDiasTrabajado = plaDiasTrabajado;
    }

    public double getPlaSueldoBasico() {
        return plaSueldoBasico;
    }

    public void setPlaSueldoBasico(double plaSueldoBasico) {
        this.plaSueldoBasico = plaSueldoBasico;
    }

    public double getPlaAsignacionFamiliar() {
        return plaAsignacionFamiliar;
    }

    public void setPlaAsignacionFamiliar(double plaAsignacionFamiliar) {
        this.plaAsignacionFamiliar = plaAsignacionFamiliar;
    }

    public long getPlaTotalMinutoHoraExtra() {
        return plaTotalMinutoHoraExtra;
    }

    public void setPlaTotalMinutoHoraExtra(long plaTotalMinutoHoraExtra) {
        this.plaTotalMinutoHoraExtra = plaTotalMinutoHoraExtra;
    }

    public double getPlaImporteHoraExtra() {
        return plaImporteHoraExtra;
    }

    public void setPlaImporteHoraExtra(double plaImporteHoraExtra) {
        this.plaImporteHoraExtra = plaImporteHoraExtra;
    }

    public double getPlaGratificacion() {
        return plaGratificacion;
    }

    public void setPlaGratificacion(double plaGratificacion) {
        this.plaGratificacion = plaGratificacion;
    }

    public String getPlaNombreAFP() {
        return plaNombreAFP;
    }

    public void setPlaNombreAFP(String plaNombreAFP) {
        this.plaNombreAFP = plaNombreAFP;
    }

    public double getPlaAporteFondo() {
        return plaAporteFondo;
    }

    public void setPlaAporteFondo(double plaAporteFondo) {
        this.plaAporteFondo = plaAporteFondo;
    }

    public double getPlaPrimaSeguro() {
        return plaPrimaSeguro;
    }

    public void setPlaPrimaSeguro(double plaPrimaSeguro) {
        this.plaPrimaSeguro = plaPrimaSeguro;
    }

    public double getPlaComision() {
        return plaComision;
    }

    public void setPlaComision(double plaComision) {
        this.plaComision = plaComision;
    }

    public long getPlaTotalMinutoTardanza() {
        return plaTotalMinutoTardanza;
    }

    public void setPlaTotalMinutoTardanza(long plaTotalMinutoTardanza) {
        this.plaTotalMinutoTardanza = plaTotalMinutoTardanza;
    }

    public double getPlaDescuentoTardanza() {
        return plaDescuentoTardanza;
    }

    public void setPlaDescuentoTardanza(double plaDescuentoTardanza) {
        this.plaDescuentoTardanza = plaDescuentoTardanza;
    }

    public double getPlaQuintaCategoria() {
        return plaQuintaCategoria;
    }

    public void setPlaQuintaCategoria(double plaQuintaCategoria) {
        this.plaQuintaCategoria = plaQuintaCategoria;
    }

    public double getPlaEsSalud() {
        return plaEsSalud;
    }

    public void setPlaEsSalud(double plaEsSalud) {
        this.plaEsSalud = plaEsSalud;
    }

    public LinkedList<Planilla> getColPlanilla() {
        return colPlanilla;
    }

    public void setColPlanilla(LinkedList<Planilla> colPlanilla) {
        this.colPlanilla = colPlanilla;
    }

    @Override
    public String toString() {
        return "Planilla{" +
                "idPlanilla=" + idPlanilla +
                ", plaAlMesAnio=" + plaAlMesAnio +
                ", idPersona=" + idPersona +
                ", plaDiasTrabajado=" + plaDiasTrabajado +
                ", plaSueldoBasico=" + plaSueldoBasico +
                ", plaAsignacionFamiliar=" + plaAsignacionFamiliar +
                ", plaTotalMinutoHoraExtra=" + plaTotalMinutoHoraExtra +
                ", plaImporteHoraExtra=" + plaImporteHoraExtra +
                ", plaGratificacion=" + plaGratificacion +
                ", plaNombreAFP='" + plaNombreAFP + '\'' +
                ", plaAporteFondo=" + plaAporteFondo +
                ", plaPrimaSeguro=" + plaPrimaSeguro +
                ", plaComision=" + plaComision +
                ", plaTotalMinutoTardanza=" + plaTotalMinutoTardanza +
                ", plaDescuentoTardanza=" + plaDescuentoTardanza +
                ", plaQuintaCategoria=" + plaQuintaCategoria +
                ", plaEsSalud=" + plaEsSalud +
                '}';
    }
}
