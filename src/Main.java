import entidades.*;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        //Para pruebas de datos cargado
        // ============================


        Compensacion compensacion = new Compensacion();
        compensacion.llenarDatosIniciales();
        LinkedList<Compensacion> colCompensacion = compensacion.getColCompensacion();
        for (Compensacion com : colCompensacion){
            System.out.println(com.toString());
        }


//        LogeoFallido logeoFallido = new LogeoFallido();
//        logeoFallido.llenarDatosIniciales();
//        LinkedList<LogeoFallido> colLogeoFallido = logeoFallido.getColLogeoFallido();
//        for (LogeoFallido log : colLogeoFallido){
//            System.out.println(log.toString());
//        }


//        Asistencia asistencia = new Asistencia();
//        asistencia.llenarDatosIniciales();
//        LinkedList<Asistencia> colAsiPersona = asistencia.buscarAsistenciaPersona(2);
//        for(Asistencia asi : colAsiPersona){
//            System.out.println(asi.toString());
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