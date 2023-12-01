import entidades.Asistencia;
import entidades.Personal;
import entidades.Planilla;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static Asistencia asistencia = new Asistencia();
    private static Personal personal = new Personal();
    private static Planilla planilla = new Planilla();

    public static void main(String[] args) {
        llenarDatosIniciales();
        mostrarOpcionesMenu();
    }
    private static void llenarDatosIniciales(){
        asistencia.setFechaHoraEntradaSalida();
        asistencia.llenarDatosIniciales();

        asistencia.llenarDatosIniciales();
        personal.llenarDatosIniciales();
    }
    private static void mostrarOpcionesMenu(){
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("BIENVENIDO AL SISTEMA DE PLANILLAS");
        System.out.println("==================================");
        System.out.println();
        System.out.println("OPCIONES DE MENU PRINCIPAL");
        System.out.println("0 - Salir");
        System.out.println("1 - Registro de asistencia");
        System.out.println("2 - Ingreso al Sistema de Planilla");
        System.out.println("3 - Ver datos iniciales");

        System.out.print("Ingrese la opción de menú donde desea ingresar: ");
        int opc = sc.nextInt();

        if (opc == 0) return;
        if (opc == 1) registrarAsistencia();
        if (opc == 2) ingresoSistema();
        if (opc == 3) pruebaListaAsistencia();
    }

    private static void registrarAsistencia(){
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("BIENVENIDO AL REGISTRO DE SU ASISTENCIA");
        System.out.println("=======================================");
        System.out.println();
        System.out.println("OPCIONES DE MENU");
        System.out.println("----------------");
        System.out.println("0 - Regresar");
        System.out.println();

        System.out.print("Ingrese su DNI:");
        String dni = sc.next();
        if (dni.length() == 1 && dni.compareToIgnoreCase("0") == 0) {
            mostrarOpcionesMenu();
            return;
        }

        if (asistencia.registrarEntrada(dni,personal.getColPersonal())){
            System.out.println("Su asistencia se registró con éxito!");
            registrarAsistencia();
        } else {
            System.out.println("No se pudo registrar su asistencia, intentelo nuevamente");
            registrarAsistencia();
        }
    }
    private static void ingresoSistema(){
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("BIENVENIDO AL SISTEMA DE PLANILLAS");
        System.out.println("==================================");
        System.out.println();
        System.out.println("OPCIONES DE MENU");
        System.out.println("----------------");
        System.out.println("0 - Regresar");
        System.out.println();

        System.out.print("Ingrese su usuario de acceso: ");
        String usu = sc.next();
        if (usu.length() == 1 && usu.compareToIgnoreCase("0") == 0) {
            mostrarOpcionesMenu();
            return;
        }
        System.out.printf("Ingrese su contraseña de acceso: ");
        String pwd = sc.next();

        Personal tmpPer;
        tmpPer = personal.obtenerIdPersona(usu,pwd);
        if (tmpPer == null){
            System.out.println("Sus datos de accesos no son válidos, intentar nuevamente");
            ingresoSistema();
        } else {
            if (tmpPer.getPerPerfil() == 1){ //administrador
                menuAdministrador(usu, tmpPer.getPerNombre() + " " + tmpPer.getPerApellido());
            }
            if (tmpPer.getPerPerfil() == 2){ //usuario
                menuUsuario(usu, tmpPer.getPerNombre() + " " + tmpPer.getPerApellido());
            }
        }
    }

    private static void menuAdministrador(String usu, String nomUsuario){
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("BIENVENIDO AL SISTEMA DE PLANILLAS (INTRANET)");
        System.out.println("=============================================");
        System.out.println();
        System.out.println("Usuario: " + usu + "      :: Apellidos y Nombres: " + nomUsuario);
        System.out.println();
        System.out.println("OPCIONES DE MENU");
        System.out.println("----------------");
        System.out.println("0 - Regresar");
        System.out.println();

        System.out.print("Ingrese la opción de menú donde desea ingresar: ");
        int opc = sc.nextInt();

        if (opc == 0) mostrarOpcionesMenu();
    }

    private static void menuUsuario(String usu, String nomUsuario){
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("BIENVENIDO AL SISTEMA DE PLANILLAS (INTRANET)");
        System.out.println("=============================================");
        System.out.println();
        System.out.println("Usuario: " + usu + "      :: Apellidos y Nombres: " + nomUsuario);
        System.out.println();
        System.out.println("OPCIONES DE MENU");
        System.out.println("----------------");
        System.out.println("0 - Regresar");
        System.out.println();

        System.out.print("Ingrese la opción de menú donde desea ingresar: ");
        int opc = sc.nextInt();

        if (opc == 0) mostrarOpcionesMenu();
    }



    /*
    METODOS DE PRUEBA QUE AYUDAN A PROBAR LA FUNCIONALIDAD
     */
    private static void pruebaListaAsistencia(){
        LinkedList<Asistencia> colAsistencia = asistencia.getColAsistencia();
        for (Asistencia asi : colAsistencia){
            System.out.println(asi.toString());
        }
        mostrarOpcionesMenu();
    }
    private static void pruebaPlanilla(){
        planilla.generarPlanilla(personal, asistencia, 2023,11);
        for (Planilla pla : planilla.getColPlanilla()){
            System.out.println(pla.toString());
        }
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