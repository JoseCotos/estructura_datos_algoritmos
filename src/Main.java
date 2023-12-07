import entidades.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

        if (asistencia.registrarAsistencia(dni,personal.getColPersonal())){
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
        System.out.println("ACCESO AL SISTEMA");
        System.out.println("==================");
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
        System.out.println("1 - Revisar Solicitudes");
        System.out.println("2 - Revisar Personal");
        System.out.println("3 - Proceso de planilla");
        System.out.println();

        System.out.print("Ingrese la opción de menú donde desea ingresar: ");
        int opc = sc.nextInt();

        if (opc == 0) mostrarOpcionesMenu();
        if (opc == 1) revisarSolicitud(objPersonal);
        if (opc == 2) revisarPersonal(objPersonal);
        if (opc == 3) procesoPlanilla(objPersonal);
    }
    private static void revisarSolicitud(Personal objPersonal){
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("BIENVENIDO A LAS SOLICITUDES");
        System.out.println("=============================");
        System.out.println();
        System.out.println("OPCIONES DE MENU");
        System.out.println("-----------------");
        System.out.println("0 - Retornar");
        System.out.println("1 - Atender solicitudes pendientes");
        System.out.println("2 - Ver solicitudes atendidos");
        System.out.println("3 - Ver solicitudes rechazados");

        System.out.print("Ingrese la opción de menú donde desea ingresar: ");
        int opc = sc.nextInt();

        if (opc == 0) menuAdministrador(objPersonal);
        if (opc == 1) atenderSolicitudesPendientes(objPersonal);
        if (opc == 2) {verSolicitudes(2); revisarSolicitud(objPersonal);}
        if (opc == 3) {verSolicitudes(3); revisarSolicitud(objPersonal);}
    }
    public static void atenderSolicitudesPendientes(Personal objpersonal){
        verSolicitudes(1);
        if (solicitud.obtenerSolicitudes(1).size() == 0) {revisarSolicitud(objpersonal); return;}

        Scanner sc = new Scanner(System.in);

        int nroSol = 0, condicion = 0;
        try {
            System.out.print("Ingrese el Nro Solicitud a atender: ");
            nroSol = sc.nextInt();
            System.out.print("Ingrese 1 para aceptar y 0 para rechazar la solicitud: ");
            condicion = sc.nextInt();

            if (nroSol == 0){
                revisarSolicitud(objpersonal);
            } else {
                if (solicitud.atenderSolicitud(nroSol, condicion)){
                    System.out.println("Se atendió la solicitud: " + nroSol);
                } else {
                    System.out.println("Error, no se atendió intente nuevamente");
                }
                atenderSolicitudesPendientes(objpersonal);
            }

        } catch (Exception ex){
            System.out.println("Error, ingrese nuevamente el Nro Solicitud");
            atenderSolicitudesPendientes(objpersonal);
        }
    }
    private static void verSolicitudes(int tipo){
        LinkedList<Solicitud> tmpSol = new LinkedList<Solicitud>();
        tmpSol = solicitud.obtenerSolicitudes(tipo);// tipo:1 -> Pendiente
        System.out.println("Nro Solicitud :: Fecha Solicitud :: Descripcion");
        System.out.println("=======================================================================");
        for (Solicitud sol : tmpSol){
            System.out.println(sol.getIdSolicitud() + "          :: " + sol.getSolFecha() + " :: " + sol.getSolDescripcion());
        }
        System.out.println();
    }

    private static void revisarPersonal(Personal objPersonal){
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("BIENVENIDO A LA GESTION DE PERSONAL");
        System.out.println("====================================");
        System.out.println();
        System.out.println("OPCIONES DE MENU");
        System.out.println("-----------------");
        System.out.println("0 - Retornar");
        System.out.println("1 - Listar al Personal");
        System.out.println("2 - Registro de nuevo Personal");
        System.out.println("3 - Actualizacion de un Personal");

        System.out.print("Ingrese la opción de menú donde desea ingresar: ");
        int opc = sc.nextInt();

        if (opc == 0) menuAdministrador(objPersonal);
        if (opc == 1) listarPersonal(objPersonal);
        if (opc == 2) registroPersonal(objPersonal);
        if (opc == 3) actualizacionPersonal(objPersonal);
    }
    private static void listarPersonal(Personal objPersonal){
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("LISTADO DE PERSONAL");
        System.out.println("====================");
        System.out.println();
        System.out.println("OPCIONES DE MENU");
        System.out.println("-----------------");
        System.out.println("0 - Retornar");
        System.out.println("1 - Listar asistencia de todo el Personal");
        System.out.println("2 - Listar asistencia del personal con tardanza del mes actual");
        System.out.println("3 - Listar asistencia del personal con horas extras del mes actual");

        System.out.print("Ingrese la opción de menú donde desea ingresar: ");
        int opc = sc.nextInt();
        System.out.print("Ingrese el numero de mes a consultar?: ");
        int nroMes = sc.nextInt();

        if (opc == 0) revisarPersonal(objPersonal);
        if (opc == 1) listarTodoPersonal(objPersonal, 1, nroMes);
        if (opc == 2) listarTodoPersonal(objPersonal, 2, nroMes);
        if (opc == 3) listarTodoPersonal(objPersonal, 3, nroMes);
    }
    private static void listarTodoPersonal(Personal objPersonal, int tipo, int nroMes){
        LinkedList<Asistencia> tmpColAsistencia = new LinkedList<Asistencia>();

        int regNoEncontrado = 0;
        for (Personal per : personal.getColPersonal()){
            if (tipo == 1){
                tmpColAsistencia = asistencia.obtenerAsistenciaPersona(LocalDate.now().getYear(),nroMes,per.getIdPersonal());
            } else if(tipo == 2){
                tmpColAsistencia = asistencia.obtenerTardanzaPersona(LocalDate.now().getYear(),nroMes,per.getIdPersonal());
            } else if (tipo == 3) {
                tmpColAsistencia = asistencia.obtenerHoraExtraPersona(LocalDate.now().getYear(),nroMes,per.getIdPersonal());
            }

            if (tmpColAsistencia.size() > 0){
                System.out.println(per.getPerNombre() + " " + per.getPerApellido() + " :: " + per.getPerCargo());

                System.out.println(" Hora entrada    | Hora salida      | Minutos Tardanza | Minutos Horas Extras");
                System.out.println("---------------------------------------------------------------------------------");
                for (Asistencia asi : tmpColAsistencia){
                    System.out.println(asi.getAsiFecHoraEntrada().toString().replace("T", " ") + " | " + asi.getAsiFecHoraSalida().toString().replace("T"," ") +
                            " | " + asi.getAsiMinutoTardanza() + "               | " + asi.getAsiMinutoHoraExtra());
                }
                System.out.println();
            } else {
                regNoEncontrado++;
            }
        }
        if (regNoEncontrado == personal.getColPersonal().size()) System.out.println("-- No se encontraron registros --");

        System.out.println();
        listarPersonal(objPersonal);
    }

    private static void registroPersonal(Personal objPersonal){
        Scanner sc = new Scanner(System.in);

        String nombre, apellido, dni, usu, pwd, cargo, nomSeguroAFP, hijos;
        double sueldoBasico;
        try {
            System.out.println();
            System.out.println("REGISTRO DE NUEVO PERSONAL");
            System.out.println("===========================");
            System.out.println();
            System.out.print("Ingrese su nombre: ");
            nombre = sc.next();
            System.out.print("Ingrese su apellido: ");
            apellido = sc.next();
            System.out.print("Ingrese su numero de DNI: ");
            dni = sc.next();
            System.out.print("Ingrese el cargo: ");
            cargo = sc.next();
            System.out.print("Ingrese nro de hijos: ");
            hijos = sc.next();
            System.out.print("Ingrese sueldo basico: ");
            sueldoBasico = sc.nextDouble();
            System.out.print("Ingrese nombre del seguro AFP: ");
            nomSeguroAFP = sc.next();
            System.out.print("Ingrese su usuario de logeo: ");
            usu = sc.next();
            System.out.print("Ingrese su clave de logeo: ");
            pwd = sc.next();

            Personal tmpPer = new Personal(personal.getColPersonal().size() + 1,nombre, apellido,"DNI",dni, 2, usu, pwd, LocalDate.now(), Integer.parseInt(hijos), sueldoBasico, cargo, nomSeguroAFP);
            personal.getColPersonal().add(tmpPer);
            System.out.println();
            System.out.println("Registro del nuevo personal exitoso");

        } catch (Exception e){
            System.out.println("ERROR: ingresando datos, intentelo nuevamente");
        }
        revisarPersonal(objPersonal);
    }
    private static void actualizacionPersonal(Personal objPersonal){
        System.out.println("Pantalla en mantenimiento!");
        revisarPersonal(objPersonal);
    }

    private static void procesoPlanilla(Personal objPersonal){
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("PROCESO DE PLANILLA");
        System.out.println("====================");
        System.out.println();
        System.out.println("OPCIONES DE MENU");
        System.out.println("-----------------");
        System.out.println("0 - Retornar");
        System.out.println("1 - Generar planilla");
        System.out.println("2 - Emitir boleta de pago");

        System.out.print("Ingrese la opción de menú donde desea ingresar: ");
        int opc = sc.nextInt();

        if (opc == 0) menuAdministrador(objPersonal);
        if (opc == 1) generarPlanilla(objPersonal);
        if (opc == 2) emitirBoleta(objPersonal);
    }
    private static void generarPlanilla(Personal objPersonal){
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println();
            System.out.print("Indicar el número de mes que se generará la planilla: ");
            int nroMes = sc.nextInt();

            planilla.generarPlanilla(personal, asistencia, LocalDate.now().getYear(), nroMes);
            System.out.println("Planilla generado con éxito");
        } catch (Exception e){
            System.out.println("ERROR: ingrese nuevamente los datos");
        }
        procesoPlanilla(objPersonal);
    }
    private static void emitirBoleta(Personal objPersonal){
        Scanner sc = new Scanner(System.in);

        try{
            if (planilla.getColPlanilla().size() > 0){
                System.out.println();
                System.out.println("EMISIÓN DE PLANILLA DEL PERSONAL");
                System.out.println("=================================");
                System.out.println();

                System.out.print("Ingrese el código del personal para la emisión de su boleta de pago: ");
                int idPersonal = sc.nextInt();

                Planilla tmpPla = planilla.obtenerBoletaPago(idPersonal);
                imprimirBoleta(tmpPla);
            }else{
                System.out.println("SIN DATOS: para ver datos debe generar la planilla");
            }
        } catch (Exception e){
            System.out.println("ERROR: intentelo nuevamente");
        }
        procesoPlanilla(objPersonal);
    }
    private static void imprimirBoleta(Planilla objPlanilla){
        Personal tmpPer = personal.obtenerPersonal(objPlanilla.getIdPersona());

        System.out.println();
//        System.out.println(objPlanilla.toString());
        System.out.println("                       BOLETA DE PAGO NOVIEMBRE 2023");
        System.out.println("                       ==============================");
        System.out.println("Trabajador: " + tmpPer.getPerNombre() + " " + tmpPer.getPerApellido() + "              Periodo: " + objPlanilla.getPlaAlMesAnio());
        System.out.println("DNI: " + tmpPer.getPerNroDoc() + "           Sueldo básico: " + tmpPer.getPerSueldoBasico());
        System.out.println("Dias trabajados: " + objPlanilla.getPlaDiasTrabajado() + " ");

        double tmpTotalIngreso = tmpPer.getPerSueldoBasico() + objPlanilla.getPlaAsignacionFamiliar() + objPlanilla.getPlaImporteHoraExtra() + objPlanilla.getPlaGratificacion();
        double tmpTotalEgreso = objPlanilla.getPlaAporteFondo() + objPlanilla.getPlaPrimaSeguro() + objPlanilla.getPlaComision() + objPlanilla.getPlaDescuentoTardanza() + objPlanilla.getPlaQuintaCategoria();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("CONCEPTOS");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("INGRESOS:");
        System.out.println("Sueldo básico:                                                    " + tmpPer.getPerSueldoBasico());
        System.out.println("Asignación familiar:                                              " + objPlanilla.getPlaAsignacionFamiliar());
        System.out.println("Horas extras:                                                     " + objPlanilla.getPlaImporteHoraExtra());
        System.out.println("Gratificación:                                                    " + objPlanilla.getPlaGratificacion());
        System.out.println("TOTAL INGRESOS:                                                   " + tmpTotalIngreso);
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("EGRESOS:");
        System.out.println("Aporte fondo:                                                     " + objPlanilla.getPlaAporteFondo());
        System.out.println("Prima seguro:                                                     " + objPlanilla.getPlaPrimaSeguro());
        System.out.println("Comisión:                                                         " + objPlanilla.getPlaComision());
        System.out.println("Tardanza:                                                         " + objPlanilla.getPlaDescuentoTardanza());
        System.out.println("Quinta categoría:                                                 " + objPlanilla.getPlaQuintaCategoria());
        System.out.println("TOTAL EGRESO:                                                     " + tmpTotalEgreso);
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Essalud:                                                          " + objPlanilla.getPlaEsSalud());
        System.out.println();
        System.out.println("=============================================================================================");
        System.out.println("Neto a pagar:                                                     " + convertirDecimal(tmpTotalIngreso - tmpTotalEgreso));
    }

    public static String convertirDecimal(double valor){
        double tmpValor = ((int)(valor * 100))/100.0;
        return String.valueOf(tmpValor);
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
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("REGISTRO DE SOLICITUD DE HORA EXTRA");
        System.out.println("===================================");
        System.out.println();
        System.out.println("OPCIONES DE MENU");
        System.out.println("----------------");
        System.out.println("0 - Regresar");
        System.out.println(); // public Solicitud(int idSolicitud, LocalDate solFecha, String solDescripcion, int idPersona) {

        System.out.print("Ingresar para que fecha desea asistir extraordinariamente (DD/MM/YYYY): ");
        String fecha = sc.next();
        System.out.print("Ingrese el motivo de asistir extraordinariamente: ");
        String desc = sc.next();

        LocalDate fechaHE = LocalDate.now();
        try {
            System.out.println(fecha.substring(6) + " :: " + fecha.substring(3,5) + " :: " + fecha.substring(0,2));
            fechaHE = LocalDate.of(Integer.parseInt(fecha.substring(6)), Integer.parseInt(fecha.substring(3,5)),
                    Integer.parseInt(fecha.substring(0,2)));

            Solicitud sol = new Solicitud(solicitud.getColSolicitud().size() + 1, fechaHE, desc, objPersonal.getIdPersonal());
            solicitud.getColSolicitud().add(sol);
            System.out.println("Solicitud ingresado exitosamente");

            menuUsuario(objPersonal);
        } catch (Exception ex){
            System.out.println("Formato de fecha mal ingresada, intente nuevamente");
            registrarSolicitud(objPersonal);
        }
    }
    private static void verAsistencia(Personal objPersonal){
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("REPORTE DE ASISTENCIA");
        System.out.println("======================");
        System.out.println();

        int anio = 0, nroMes = 0;
        try {
            System.out.print("Ingrese un año: ");
            anio = sc.nextInt();
            System.out.print("Ingrese un mes: ");
            nroMes = sc.nextInt();
        } catch (Exception ex){
            System.out.println("Error ingresando datos, intente nuevamente");
            verAsistencia(objPersonal);
        }

        LinkedList<Asistencia> tmpAsi = asistencia.obtenerAsistenciaPersona(anio, nroMes, objPersonal.getIdPersonal());

        System.out.println();
        System.out.println("Fecha de Impresión: " + LocalDateTime.now());
        System.out.println("HORA ENTRADA     ::: HORA SALIDA");
        System.out.println("======================================");
        for(Asistencia asi : tmpAsi){
            System.out.println(asi.getAsiFecHoraEntrada() + " ::: " + asi.getAsiFecHoraSalida());
        }
        System.out.println("======================================");
        System.out.println("Impreso por el área de TIC");


        menuUsuario(objPersonal);
    }
    private static void verBoletaPago(Personal objPersonal){
        Planilla tmpPla = planilla.obtenerBoletaPago(objPersonal.getIdPersonal());
        imprimirBoleta(tmpPla);
    }

    private static void cabeceraIngresoSistema(Personal objPersonal){
        String perfil = "";
        if (objPersonal.getPerPerfil() == 1) perfil = "ADMINISTRADOR";
        if (objPersonal.getPerPerfil() == 2) perfil = "USUARIO";

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