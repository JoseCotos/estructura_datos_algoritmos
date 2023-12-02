import entidades.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static Asistencia asistencia = new Asistencia();
    private static Personal personal = new Personal();
    private static Planilla planilla = new Planilla();
    private static Feriado feriado = new Feriado();
    private static LogeoFallido logeoFallido = new LogeoFallido();
    private static Notificacion notificacion = new Notificacion();
    private static Solicitud solicitud = new Solicitud();

    public static void main(String[] args) {
        llenarDatosIniciales();
        mostrarOpcionesMenu();
    }
    private static void llenarDatosIniciales(){
        asistencia.setFechaHoraEntradaSalida();

        asistencia.llenarDatosIniciales();
        personal.llenarDatosIniciales();
        feriado.llenarDatosIniciales();
        logeoFallido.llenarDatosIniciales();
        notificacion.llenarDatosIniciales();
        solicitud.llenarDatosIniciales();
        planilla.llenarDatosIniciales();
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
        System.out.println("3 - Ver datos de tablas");

        System.out.print("Ingrese la opción de menú donde desea ingresar: ");
        int opc = sc.nextInt();

        if (opc == 0) return;
        if (opc == 1) registrarAsistencia();
        if (opc == 2) ingresoSistema();
        if (opc == 3) verDatosTablas();
    }

    /*
    OPCION 1 ================================================================================
    =========================================================================================
     */
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

    /*
    OPCION 2 ================================================================================
    =========================================================================================
     */
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
                menuAdministrador(tmpPer);
            }
            if (tmpPer.getPerPerfil() == 2){ //usuario
                menuUsuario(tmpPer);
            }
        }
    }

    private static void menuAdministrador(Personal objPersonal){
        Scanner sc = new Scanner(System.in);

        cabeceraIngresoSistema(objPersonal);
        System.out.println("OPCIONES DE MENU");
        System.out.println("----------------");
        System.out.println("0 - Regresar");
        System.out.println("1 - Atender Solicitudes");
        System.out.println("2 - Revisar Personal");
        System.out.println("3 - Emitir Boletas");
        System.out.println();

        System.out.print("Ingrese la opción de menú donde desea ingresar: ");
        int opc = sc.nextInt();

        if (opc == 0) mostrarOpcionesMenu();
        if (opc == 1) atenderSolicitud();
        if (opc == 2) revisarPersonal();
        if (opc == 3) emitirBoleta();
    }
    private static void atenderSolicitud(){

    }
    private static void revisarPersonal(){

    }
    private static void emitirBoleta(){

    }

    private static void menuUsuario(Personal objPersonal){
        Scanner sc = new Scanner(System.in);

        cabeceraIngresoSistema(objPersonal);
        System.out.println("OPCIONES DE MENU");
        System.out.println("----------------");
        System.out.println("0 - Regresar");
        System.out.println("1 - Registrar Solicitud");
        System.out.println("2 - Ver Asistencia");
        System.out.println("3 - Ver Boleta de Pago");
        System.out.println();

        System.out.print("Ingrese la opción de menú donde desea ingresar: ");
        int opc = sc.nextInt();

        if (opc == 0) mostrarOpcionesMenu();
        if (opc == 1) registrarSolicitud(objPersonal);
        if (opc == 2) verAsistencia(objPersonal);
        if (opc == 3) verBoletaPago(objPersonal);

    }
    private static void registrarSolicitud(Personal objPersonal){

    }
    private static void verAsistencia(Personal objPersonal){

    }
    private static void verBoletaPago(Personal objPersonal){

    }

    private static void cabeceraIngresoSistema(Personal objPersonal){
        String perfil = "";
        if (objPersonal.getPerPerfil() == 1) perfil = "ADMINISTRADOR";
        if (objPersonal.getPerPerfil() == 1) perfil = "USUARIO";

        System.out.println();
        System.out.println("BIENVENIDO AL SISTEMA DE PLANILLAS (INTRANET)");
        System.out.println("=============================================");
        System.out.println(perfil + " ::: " + objPersonal.getPerUsuario() + " ::: " +
                objPersonal.getPerNombre() + " " + objPersonal.getPerApellido());
        System.out.println();
    }

    /*
    OPCION 3 ================================================================================
    =========================================================================================
     */
    private static void verDatosTablas(){
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("BIENVENIDO A LA VISUALIZACION DE TABLAS");
        System.out.println("=======================================");
        System.out.println();
        System.out.println("OPCIONES DE MENU");
        System.out.println("----------------");
        System.out.println("0 - Regresar");
        System.out.println("1 - Personal");
        System.out.println("2 - Asistencia");
        System.out.println("3 - Feriado");
        System.out.println("4 - Logeo Fallido");
        System.out.println("5 - Notificacion");
        System.out.println("6 - Solicitud");
        System.out.println("7 - Planilla");
        System.out.println();

        System.out.print("Ingrese la opción de menú donde desea ingresar: ");
        int opc = sc.nextInt();

        if (opc == 0) mostrarOpcionesMenu();
        if (opc == 1) verTablaPersonal();
        if (opc == 2) verTablaAsistencia();
        if (opc == 3) verTablaFeriado();
        if (opc == 4) verTablaLogeoFallido();
        if (opc == 5) verTablaNotificacion();
        if (opc == 6) verTablaSolicitud();
        if (opc == 7) verTablaPlanilla();
    }

    private static void verTablaPersonal(){
        System.out.println();
        System.out.println("Tabla: PERSONAL");
        System.out.println("===============");
        LinkedList<Personal> colObjeto = personal.getColPersonal();
        for (Personal obj : colObjeto){
            System.out.println(obj.toString());
        }
        verDatosTablas();
    }
    private static void verTablaSolicitud(){
        System.out.println();
        System.out.println("Tabla: SOLICITUD");
        System.out.println("===============");
        LinkedList<Solicitud> colObjeto = solicitud.getColSolicitud();
        for (Solicitud obj : colObjeto){
            System.out.println(obj.toString());
        }
        verDatosTablas();
    }
    private static void verTablaNotificacion(){
        System.out.println();
        System.out.println("Tabla: NOTIFICACION");
        System.out.println("====================");
        LinkedList<Notificacion> colObjeto = notificacion.getColNotificacion();
        for (Notificacion obj : colObjeto){
            System.out.println(obj.toString());
        }
        verDatosTablas();
    }
    private static void verTablaFeriado(){
        System.out.println();
        System.out.println("Tabla: FERIADO");
        System.out.println("===============");
        LinkedList<Feriado> colObjeto = feriado.getColFeriado();
        for (Feriado obj : colObjeto){
            System.out.println(obj.toString());
        }
        verDatosTablas();
    }
    private static void verTablaLogeoFallido(){
        System.out.println();
        System.out.println("Tabla: LOGEO FALLIDO");
        System.out.println("====================");
        LinkedList<LogeoFallido> colObjeto = logeoFallido.getColLogeoFallido();
        for (LogeoFallido obj : colObjeto){
            System.out.println(obj.toString());
        }
        verDatosTablas();
    }
    private static void verTablaPlanilla(){
        System.out.println();
        System.out.println("Tabla: PLANILLA");
        System.out.println("===============");
        LinkedList<Planilla> colObjeto = planilla.getColPlanilla();
        for (Planilla obj : colObjeto){
            System.out.println(obj.toString());
        }
        verDatosTablas();
    }
    private static void verTablaAsistencia(){
        System.out.println();
        System.out.println("Tabla: ASISTENCIA");
        System.out.println("==================");
        LinkedList<Asistencia> colObjeto = asistencia.getColAsistencia();
        for (Asistencia obj : colObjeto){
            System.out.println(obj.toString());
        }
        verDatosTablas();
    }

    /*
    METODOS DE PRUEBA QUE AYUDAN A PROBAR LA FUNCIONALIDAD
     */

}