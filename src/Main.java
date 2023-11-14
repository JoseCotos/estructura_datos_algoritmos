import entidades.Asistencia;

import java.util.LinkedList;

public class Main {
    private static Asistencia asistencia = new Asistencia();
    public static void main(String[] args) {
        llenarDatosIniciales();
        pruebaTardanza();
        pruebaHoraExtra();
        pruebaAsistencia();
    }

    private static void llenarDatosIniciales(){
        asistencia.setFechaHoraEntradaSalida();
        asistencia.llenarDatosIniciales();

        asistencia.llenarDatosIniciales();
    }

    public static void pruebaTardanza(){
        LinkedList<Asistencia> colAsiPersona = asistencia.obtenerTardanzaPersona(2023,11,1);
        System.out.println("Total minutos tardanza: " + asistencia.obtenerTardanzaPersonaTotal(2023,11,1));
        for(Asistencia asi : colAsiPersona){
            System.out.println(asi.toString());
        }
        System.out.println();
    }

    public static void pruebaHoraExtra(){
        LinkedList<Asistencia> colAsiPersona = asistencia.obtenerHoraExtraPersona(2023,11,1);
        System.out.println("Total minutos hora extra: " + asistencia.obtenerHoraExtraPersonaTotal(2023,11,1));
        for(Asistencia asi : colAsiPersona){
            System.out.println(asi.toString());
        }
        System.out.println();
    }

    public static void pruebaAsistencia(){
        LinkedList<Asistencia> colAsiPersona;
        colAsiPersona = asistencia.obtenerAsistenciaPersona(2023,11,1);
        System.out.println("Total de asistencias: " + asistencia.obtenerAsistenciaPersonaTotal(2023,11,1));
        for(Asistencia asi : colAsiPersona){
            System.out.println(asi.toString());
        }
        System.out.println();

        asistencia.registrarEntrada(1);
        asistencia.registrarSalida(1);
        System.out.println("Registro de marcación entrada y salida");
        System.out.println();

        colAsiPersona = asistencia.obtenerAsistenciaPersona(2023,11,1);
        System.out.println("Total de asistencias: " + asistencia.obtenerAsistenciaPersonaTotal(2023,11,1));
        for(Asistencia asi : colAsiPersona){
            System.out.println(asi.toString());
        }
        System.out.println();
    }

    public static void pruebaCarga(){
        //Para pruebas de datos cargado
        // ============================


//        Compensacion compensacion = new Compensacion();
//        compensacion.llenarDatosIniciales();
//        LinkedList<Compensacion> colCompensacion = compensacion.getColCompensacion();
//        for (Compensacion com : colCompensacion){
//            System.out.println(com.toString());
//        }

//        LogeoFallido logeoFallido = new LogeoFallido();
//        logeoFallido.llenarDatosIniciales();
//        LinkedList<LogeoFallido> colLogeoFallido = logeoFallido.getColLogeoFallido();
//        for (LogeoFallido log : colLogeoFallido){
//            System.out.println(log.toString());
//        }

        // Autor Jose Cotos
//        Feriado feriado = new Feriado();
//        feriado.llenarDatosIniciales();
//        LinkedList<Feriado> colFeriado = feriado.getColFeriado();
//        for (Feriado fer : colFeriado){
//            System.out.println(fer.toString());
//        }

//        Asistencia asistencia = new Asistencia();
//        asistencia.llenarDatosIniciales();
//        LinkedList<Asistencia> colAsistencia = asistencia.getColAsistencia();
//        for (Asistencia asi : colAsistencia){
//            System.out.println(asi.toString());
//        }

//        Cargo cargo = new Cargo();
//        cargo.llenarDatosIniciales();
//        LinkedList<Cargo> colCargo = cargo.getColCargo();
//        for (Cargo car : colCargo){
//            System.out.println(car.toString());
//        }
//
//        Notificacion notificacion = new Notificacion();
//        notificacion.llenarDatosIniciales();
//        LinkedList<Notificacion> colNotificacion = notificacion.getColNotificacion();
//        for (Notificacion not : colNotificacion){
//            System.out.println(not.toString());
//        }
//        Solicitud solicitud = new Solicitud();
//        solicitud.llenarDatosIniciales();
//        LinkedList<Solicitud> colSolicitud = solicitud.getColSolicitud();
//        for (Solicitud sol : colSolicitud){
//            System.out.println(sol.toString());
//
//        }
//        Personal personal = new Personal();
//        personal.llenarDatosIniciales();
//        LinkedList<Personal> colPersonal = personal.getColPersonal();
//        for (Personal per : colPersonal){
//            System.out.println(per.toString());
//        }
    }
    
}