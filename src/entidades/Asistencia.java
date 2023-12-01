package entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Asistencia {
    private int idAsistencia;
    private LocalDateTime asiFecHoraEntrada;
    private LocalDateTime asiFecHoraSalida;
    private long asiMinutoTardanza = 0;
    private long asiMinutoHoraExtra = 0;
    private boolean asiSwAutoHoraExtra = false;
    private long asiMinutoTrabajado = 0;
    private int idPersona;
    private LinkedList<Asistencia> colAsistencia;

    //variable auxiliar
    private LocalDateTime fecHoraEntrada;
    private LocalDateTime fecHoraSalida;


    public Asistencia(int idAsistencia, LocalDateTime asiFecHoraEntrada, LocalDateTime asiFecHoraSalida, int asiMinutoTardanza, int asiMinutoHoraExtra, boolean asiSwAutoHoraExtra, int asiMinutoTrabajado, int idPersona) {
        this.idAsistencia = idAsistencia;
        this.asiFecHoraEntrada = asiFecHoraEntrada;
        this.asiFecHoraSalida = asiFecHoraSalida;
        this.asiMinutoTardanza = asiMinutoTardanza;
        this.asiMinutoHoraExtra = asiMinutoHoraExtra;
        this.asiSwAutoHoraExtra = asiSwAutoHoraExtra;
        this.asiMinutoTrabajado = asiMinutoTrabajado;
        this.idPersona = idPersona;
    }

    public Asistencia(int idAsistencia, LocalDateTime asiFecHoraEntrada, int idPersona){
        this.idAsistencia = idAsistencia;
        this.asiFecHoraEntrada = asiFecHoraEntrada;
        this.idPersona = idPersona;
    }

    public Asistencia() {
    }

    private void asignarTardanza(){
        long tardanza = 0;
        LocalTime horaEntrada = LocalTime.of(8,0);
        LocalTime horaMarcacion;
        Date fecha1, fecha2;
        for (Asistencia asi : colAsistencia){
            horaMarcacion = LocalTime.of(asi.getAsiFecHoraEntrada().getHour(), asi.getAsiFecHoraEntrada().getMinute());

            fecha1 = new Date();
            fecha1.setHours(horaEntrada.getHour());
            fecha1.setMinutes(horaEntrada.getMinute());

            fecha2 = new Date();
            fecha2.setHours(horaMarcacion.getHour());
            fecha2.setMinutes(horaMarcacion.getMinute());

            tardanza = getDateDiff(fecha1, fecha2, TimeUnit.MINUTES);
            if (tardanza > 0){
                asi.setAsiMinutoTardanza(tardanza);
            }
        }
    }

    private void asignarHoraExtra(){
        long hExtra = 0;
        LocalTime horaSalida = LocalTime.of(17,0);
        LocalTime horaMarcacion;
        Date fecha1, fecha2;
        for (Asistencia asi : colAsistencia){
            horaMarcacion = LocalTime.of(asi.getAsiFecHoraSalida().getHour(), asi.getAsiFecHoraSalida().getMinute());

            fecha1 = new Date();
            fecha1.setHours(horaSalida.getHour());
            fecha1.setMinutes(horaSalida.getMinute());

            fecha2 = new Date();
            fecha2.setHours(horaMarcacion.getHour());
            fecha2.setMinutes(horaMarcacion.getMinute());

            hExtra = getDateDiff(fecha1, fecha2, TimeUnit.MINUTES);
            if (asi.asiSwAutoHoraExtra){
                asi.setAsiMinutoHoraExtra(hExtra);
            }
        }
    }

    private long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public LinkedList<Asistencia> obtenerPersonasMes(int anio, int nroMes){
        LinkedList<Asistencia> colAsiPersona = new LinkedList<Asistencia>();
        for (Asistencia asi : colAsistencia){
            if (asi.getAsiFecHoraEntrada().getYear() == anio && asi.getAsiFecHoraEntrada().getMonthValue() == nroMes){
                colAsiPersona.add(asi);
            }
        }
        return colAsiPersona;
    }

    public int obtenerTardanzaPersonaTotal(int anio, int nroMes, int idPersona){
        int dato = 0;
        LinkedList<Asistencia> colTardanzaPersona = obtenerTardanzaPersona(anio,nroMes,idPersona);
        for (Asistencia asi : colTardanzaPersona){
            dato += asi.getAsiMinutoTardanza();
        }
        return dato;
    }
    public LinkedList<Asistencia> obtenerTardanzaPersona(int anio, int nroMes, int idPersona){
        LinkedList<Asistencia> colPersonasMes = obtenerPersonasMes(anio, nroMes);
        LinkedList<Asistencia> colTardanzaPersona = new LinkedList<Asistencia>();
        for (Asistencia asi : colPersonasMes){
            if (asi.getIdPersona() == idPersona && asi.getAsiMinutoTardanza() > 0){
                colTardanzaPersona.add(asi);
            }
        }
        return colTardanzaPersona;
    }


    public int obtenerHoraExtraPersonaTotal(int anio, int nroMes, int idPersona){
        int dato = 0;
        LinkedList<Asistencia> colHoraExtraPersona = obtenerHoraExtraPersona(anio, nroMes, idPersona);
        for (Asistencia asi : colHoraExtraPersona){
            dato += asi.getAsiMinutoHoraExtra();
        }
        return dato;
    }
    public LinkedList<Asistencia> obtenerHoraExtraPersona(int anio, int nroMes, int idPersona){
        LinkedList<Asistencia> colPersonasMes = obtenerPersonasMes(anio, nroMes);
        LinkedList<Asistencia> colHoraExtraPersona = new LinkedList<Asistencia>();
        for (Asistencia asi : colPersonasMes){
            if (asi.getIdPersona() == idPersona && asi.getAsiMinutoHoraExtra() > 0){
                colHoraExtraPersona.add(asi);
            }
        }
        return colHoraExtraPersona;
    }

    public int obtenerAsistenciaPersonaTotal(int anio, int nroMes, int idPersona){
        int dato = 0;
        LinkedList<Asistencia> colAsistenciaPersona = obtenerAsistenciaPersona(anio, nroMes, idPersona);
        dato = colAsistenciaPersona.size();
        return dato;
    }
    public LinkedList<Asistencia> obtenerAsistenciaPersona(int anio, int nroMes, int idPersona){
        LinkedList<Asistencia> colPersonasMes = obtenerPersonasMes(anio, nroMes);
        LinkedList<Asistencia> colAsistenciaPersona = new LinkedList<Asistencia>();
        for (Asistencia asi : colPersonasMes){
            if (asi.getIdPersona() == idPersona){
                colAsistenciaPersona.add(asi);
            }
        }
        return colAsistenciaPersona;
    }

    public void setFechaHoraEntradaSalida(){
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaEntrada = LocalTime.of(8,0);
        LocalTime horaSalida = LocalTime.of(17,30);

        fecHoraEntrada = LocalDateTime.of(fechaActual,horaEntrada);
        fecHoraSalida = LocalDateTime.of(fechaActual,horaSalida);
    }

    public boolean registrarEntrada(String dni, LinkedList<Personal> colPersonal){
        boolean sw = false;

        int idPersona = 0;
        for (Personal per : colPersonal){
            if (per.getPerNroDoc().compareToIgnoreCase(dni) == 0){
                idPersona = per.getIdPersonal();
                sw = true;
                break;
            }
        }
        System.out.println(idPersona);
        if (!sw) return sw;

        DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate fechaActual = LocalDate.now();

        for (Asistencia asi : colAsistencia){
            if (asi.getIdPersona() == idPersona){
                if (asi.getAsiFecHoraEntrada().format(isoFecha).equals(fechaActual.format(isoFecha))){
                    sw = false;
                    break;
                }
            }
        }
        if (sw){
            int idAsi = colAsistencia.get(colAsistencia.size() - 1).idAsistencia + 1;
            Asistencia asiNew = new Asistencia(idAsi,fecHoraEntrada,idPersona);
            colAsistencia.add(asiNew);
        }
        return sw;
    }

    public boolean registrarEntrada(int idPersona){
        boolean sw = true;

        DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate fechaActual = LocalDate.now();
        for (Asistencia asi : colAsistencia){
            if (asi.getIdPersona() == idPersona){
                if (asi.getAsiFecHoraEntrada().format(isoFecha).equals(fechaActual.format(isoFecha))){
                    sw = false;
                    break;
                }
            }
        }
        if (sw){
            int idAsi = colAsistencia.get(colAsistencia.size() - 1).idAsistencia + 1;
            Asistencia asiNew = new Asistencia(idAsi,fecHoraEntrada,idPersona);
            colAsistencia.add(asiNew);
        }
        return sw;
    }

    public boolean registrarSalida(int idPersona){
        boolean sw = false;

        DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate fechaActual = LocalDate.now();
        for (Asistencia asi : colAsistencia){
            if (asi.getIdPersona() == idPersona){
                if (asi.getAsiFecHoraEntrada().format(isoFecha).equals(fechaActual.format(isoFecha))){
                    sw = true;
                    asi.setAsiFecHoraSalida(fecHoraSalida);
                    break;
                }
            }
        }
        return sw;
    }


    public void llenarDatosIniciales(){
        colAsistencia = new LinkedList<Asistencia>();
        Asistencia asistencia;

        asistencia = new Asistencia(1,LocalDateTime.of(2023,11,2,8,0),LocalDateTime.of(2023,11,2,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
        asistencia = new Asistencia(2,LocalDateTime.of(2023,11,3,8,0),LocalDateTime.of(2023,11,3,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
        asistencia = new Asistencia(3,LocalDateTime.of(2023,11,6,8,0),LocalDateTime.of(2023,11,6,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
        asistencia = new Asistencia(4,LocalDateTime.of(2023,11,7,8,0),LocalDateTime.of(2023,11,7,19,0),0,0,true,0,1); colAsistencia.add(asistencia);
        asistencia = new Asistencia(5,LocalDateTime.of(2023,11,8,8,0),LocalDateTime.of(2023,11,8,18,10),0,0,true,0,1); colAsistencia.add(asistencia);
        asistencia = new Asistencia(6,LocalDateTime.of(2023,11,9,8,10),LocalDateTime.of(2023,11,9,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
        asistencia = new Asistencia(7,LocalDateTime.of(2023,11,10,8,20),LocalDateTime.of(2023,11,10,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
        asistencia = new Asistencia(8,LocalDateTime.of(2023,11,13,8,0),LocalDateTime.of(2023,11,13,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(9,LocalDateTime.of(2023,11,14,8,0),LocalDateTime.of(2023,11,14,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(10,LocalDateTime.of(2023,11,15,8,0),LocalDateTime.of(2023,11,15,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(11,LocalDateTime.of(2023,11,16,8,0),LocalDateTime.of(2023,11,16,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(12,LocalDateTime.of(2023,11,17,8,0),LocalDateTime.of(2023,11,17,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(13,LocalDateTime.of(2023,11,20,8,0),LocalDateTime.of(2023,11,20,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(14,LocalDateTime.of(2023,11,21,8,0),LocalDateTime.of(2023,11,21,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(15,LocalDateTime.of(2023,11,22,8,0),LocalDateTime.of(2023,11,22,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(16,LocalDateTime.of(2023,11,23,8,0),LocalDateTime.of(2023,11,23,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(17,LocalDateTime.of(2023,11,24,8,0),LocalDateTime.of(2023,11,24,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(18,LocalDateTime.of(2023,11,27,8,0),LocalDateTime.of(2023,11,27,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(19,LocalDateTime.of(2023,11,28,8,0),LocalDateTime.of(2023,11,28,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(20,LocalDateTime.of(2023,11,29,8,0),LocalDateTime.of(2023,11,29,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(21,LocalDateTime.of(2023,11,30,8,0),LocalDateTime.of(2023,11,30,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(22,LocalDateTime.of(2023,12,1,8,0),LocalDateTime.of(2023,12,1,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(23,LocalDateTime.of(2023,12,4,8,0),LocalDateTime.of(2023,12,4,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(24,LocalDateTime.of(2023,12,5,8,0),LocalDateTime.of(2023,12,5,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(25,LocalDateTime.of(2023,12,6,8,0),LocalDateTime.of(2023,12,6,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(26,LocalDateTime.of(2023,12,7,8,0),LocalDateTime.of(2023,12,7,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(27,LocalDateTime.of(2023,12,8,8,0),LocalDateTime.of(2023,12,8,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(28,LocalDateTime.of(2023,12,11,8,0),LocalDateTime.of(2023,12,11,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(29,LocalDateTime.of(2023,12,12,8,0),LocalDateTime.of(2023,12,12,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(30,LocalDateTime.of(2023,12,13,8,0),LocalDateTime.of(2023,12,13,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(31,LocalDateTime.of(2023,12,14,8,0),LocalDateTime.of(2023,12,14,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(32,LocalDateTime.of(2023,12,15,8,0),LocalDateTime.of(2023,12,15,17,0),0,0,false,0,1); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(33,LocalDateTime.of(2023,11,2,8,0),LocalDateTime.of(2023,11,2,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(34,LocalDateTime.of(2023,11,3,8,0),LocalDateTime.of(2023,11,3,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(35,LocalDateTime.of(2023,11,6,8,0),LocalDateTime.of(2023,11,6,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(36,LocalDateTime.of(2023,11,7,8,0),LocalDateTime.of(2023,11,7,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(37,LocalDateTime.of(2023,11,8,8,0),LocalDateTime.of(2023,11,8,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(38,LocalDateTime.of(2023,11,9,8,0),LocalDateTime.of(2023,11,9,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(39,LocalDateTime.of(2023,11,10,8,0),LocalDateTime.of(2023,11,10,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(40,LocalDateTime.of(2023,11,13,8,0),LocalDateTime.of(2023,11,13,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(41,LocalDateTime.of(2023,11,14,8,0),LocalDateTime.of(2023,11,14,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(42,LocalDateTime.of(2023,11,15,8,0),LocalDateTime.of(2023,11,15,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(43,LocalDateTime.of(2023,11,16,8,0),LocalDateTime.of(2023,11,16,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(44,LocalDateTime.of(2023,11,17,8,0),LocalDateTime.of(2023,11,17,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(45,LocalDateTime.of(2023,11,20,8,0),LocalDateTime.of(2023,11,20,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(46,LocalDateTime.of(2023,11,21,8,0),LocalDateTime.of(2023,11,21,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(47,LocalDateTime.of(2023,11,22,8,0),LocalDateTime.of(2023,11,22,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(48,LocalDateTime.of(2023,11,23,8,0),LocalDateTime.of(2023,11,23,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(49,LocalDateTime.of(2023,11,24,8,0),LocalDateTime.of(2023,11,24,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(50,LocalDateTime.of(2023,11,27,8,0),LocalDateTime.of(2023,11,27,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(51,LocalDateTime.of(2023,11,28,8,0),LocalDateTime.of(2023,11,28,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(52,LocalDateTime.of(2023,11,29,8,0),LocalDateTime.of(2023,11,29,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(53,LocalDateTime.of(2023,11,30,8,0),LocalDateTime.of(2023,11,30,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(54,LocalDateTime.of(2023,12,1,8,0),LocalDateTime.of(2023,12,1,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(55,LocalDateTime.of(2023,12,4,8,0),LocalDateTime.of(2023,12,4,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(56,LocalDateTime.of(2023,12,5,8,0),LocalDateTime.of(2023,12,5,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(57,LocalDateTime.of(2023,12,6,8,0),LocalDateTime.of(2023,12,6,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(58,LocalDateTime.of(2023,12,7,8,0),LocalDateTime.of(2023,12,7,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(59,LocalDateTime.of(2023,12,8,8,0),LocalDateTime.of(2023,12,8,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(60,LocalDateTime.of(2023,12,11,8,0),LocalDateTime.of(2023,12,11,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(61,LocalDateTime.of(2023,12,12,8,0),LocalDateTime.of(2023,12,12,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(62,LocalDateTime.of(2023,12,13,8,0),LocalDateTime.of(2023,12,13,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(63,LocalDateTime.of(2023,12,14,8,0),LocalDateTime.of(2023,12,14,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(64,LocalDateTime.of(2023,12,15,8,0),LocalDateTime.of(2023,12,15,17,0),0,0,false,0,2); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(65,LocalDateTime.of(2023,11,2,8,0),LocalDateTime.of(2023,11,2,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(66,LocalDateTime.of(2023,11,3,8,0),LocalDateTime.of(2023,11,3,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(67,LocalDateTime.of(2023,11,6,8,0),LocalDateTime.of(2023,11,6,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(68,LocalDateTime.of(2023,11,7,8,0),LocalDateTime.of(2023,11,7,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(69,LocalDateTime.of(2023,11,8,8,0),LocalDateTime.of(2023,11,8,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(70,LocalDateTime.of(2023,11,9,8,0),LocalDateTime.of(2023,11,9,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(71,LocalDateTime.of(2023,11,10,8,0),LocalDateTime.of(2023,11,10,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(72,LocalDateTime.of(2023,11,13,8,0),LocalDateTime.of(2023,11,13,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(73,LocalDateTime.of(2023,11,14,8,0),LocalDateTime.of(2023,11,14,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(74,LocalDateTime.of(2023,11,15,8,0),LocalDateTime.of(2023,11,15,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(75,LocalDateTime.of(2023,11,16,8,0),LocalDateTime.of(2023,11,16,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(76,LocalDateTime.of(2023,11,17,8,0),LocalDateTime.of(2023,11,17,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(77,LocalDateTime.of(2023,11,20,8,0),LocalDateTime.of(2023,11,20,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(78,LocalDateTime.of(2023,11,21,8,0),LocalDateTime.of(2023,11,21,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(79,LocalDateTime.of(2023,11,22,8,0),LocalDateTime.of(2023,11,22,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(80,LocalDateTime.of(2023,11,23,8,0),LocalDateTime.of(2023,11,23,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(81,LocalDateTime.of(2023,11,24,8,0),LocalDateTime.of(2023,11,24,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(82,LocalDateTime.of(2023,11,27,8,0),LocalDateTime.of(2023,11,27,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(83,LocalDateTime.of(2023,11,28,8,0),LocalDateTime.of(2023,11,28,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(84,LocalDateTime.of(2023,11,29,8,0),LocalDateTime.of(2023,11,29,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(85,LocalDateTime.of(2023,11,30,8,0),LocalDateTime.of(2023,11,30,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(86,LocalDateTime.of(2023,12,1,8,0),LocalDateTime.of(2023,12,1,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(87,LocalDateTime.of(2023,12,4,8,0),LocalDateTime.of(2023,12,4,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(88,LocalDateTime.of(2023,12,5,8,0),LocalDateTime.of(2023,12,5,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(89,LocalDateTime.of(2023,12,6,8,0),LocalDateTime.of(2023,12,6,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(90,LocalDateTime.of(2023,12,7,8,0),LocalDateTime.of(2023,12,7,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(91,LocalDateTime.of(2023,12,8,8,0),LocalDateTime.of(2023,12,8,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(92,LocalDateTime.of(2023,12,11,8,0),LocalDateTime.of(2023,12,11,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(93,LocalDateTime.of(2023,12,12,8,0),LocalDateTime.of(2023,12,12,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(94,LocalDateTime.of(2023,12,13,8,0),LocalDateTime.of(2023,12,13,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(95,LocalDateTime.of(2023,12,14,8,0),LocalDateTime.of(2023,12,14,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(96,LocalDateTime.of(2023,12,15,8,0),LocalDateTime.of(2023,12,15,17,0),0,0,false,0,3); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(97,LocalDateTime.of(2023,11,2,8,0),LocalDateTime.of(2023,11,2,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(98,LocalDateTime.of(2023,11,3,8,0),LocalDateTime.of(2023,11,3,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(99,LocalDateTime.of(2023,11,6,8,0),LocalDateTime.of(2023,11,6,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(100,LocalDateTime.of(2023,11,7,8,0),LocalDateTime.of(2023,11,7,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(101,LocalDateTime.of(2023,11,8,8,0),LocalDateTime.of(2023,11,8,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(102,LocalDateTime.of(2023,11,9,8,0),LocalDateTime.of(2023,11,9,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(103,LocalDateTime.of(2023,11,10,8,0),LocalDateTime.of(2023,11,10,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(104,LocalDateTime.of(2023,11,13,8,0),LocalDateTime.of(2023,11,13,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(105,LocalDateTime.of(2023,11,14,8,0),LocalDateTime.of(2023,11,14,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(106,LocalDateTime.of(2023,11,15,8,0),LocalDateTime.of(2023,11,15,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(107,LocalDateTime.of(2023,11,16,8,0),LocalDateTime.of(2023,11,16,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(108,LocalDateTime.of(2023,11,17,8,0),LocalDateTime.of(2023,11,17,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(109,LocalDateTime.of(2023,11,20,8,0),LocalDateTime.of(2023,11,20,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(110,LocalDateTime.of(2023,11,21,8,0),LocalDateTime.of(2023,11,21,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(111,LocalDateTime.of(2023,11,22,8,0),LocalDateTime.of(2023,11,22,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(112,LocalDateTime.of(2023,11,23,8,0),LocalDateTime.of(2023,11,23,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(113,LocalDateTime.of(2023,11,24,8,0),LocalDateTime.of(2023,11,24,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(114,LocalDateTime.of(2023,11,27,8,0),LocalDateTime.of(2023,11,27,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(115,LocalDateTime.of(2023,11,28,8,0),LocalDateTime.of(2023,11,28,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(116,LocalDateTime.of(2023,11,29,8,0),LocalDateTime.of(2023,11,29,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(117,LocalDateTime.of(2023,11,30,8,0),LocalDateTime.of(2023,11,30,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(118,LocalDateTime.of(2023,12,1,8,0),LocalDateTime.of(2023,12,1,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(119,LocalDateTime.of(2023,12,4,8,0),LocalDateTime.of(2023,12,4,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(120,LocalDateTime.of(2023,12,5,8,0),LocalDateTime.of(2023,12,5,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(121,LocalDateTime.of(2023,12,6,8,0),LocalDateTime.of(2023,12,6,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(122,LocalDateTime.of(2023,12,7,8,0),LocalDateTime.of(2023,12,7,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(123,LocalDateTime.of(2023,12,8,8,0),LocalDateTime.of(2023,12,8,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(124,LocalDateTime.of(2023,12,11,8,0),LocalDateTime.of(2023,12,11,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(125,LocalDateTime.of(2023,12,12,8,0),LocalDateTime.of(2023,12,12,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(126,LocalDateTime.of(2023,12,13,8,0),LocalDateTime.of(2023,12,13,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(127,LocalDateTime.of(2023,12,14,8,0),LocalDateTime.of(2023,12,14,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(128,LocalDateTime.of(2023,12,15,8,0),LocalDateTime.of(2023,12,15,17,0),0,0,false,0,4); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(129,LocalDateTime.of(2023,11,2,8,0),LocalDateTime.of(2023,11,2,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(130,LocalDateTime.of(2023,11,3,8,0),LocalDateTime.of(2023,11,3,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(131,LocalDateTime.of(2023,11,6,8,0),LocalDateTime.of(2023,11,6,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(132,LocalDateTime.of(2023,11,7,8,0),LocalDateTime.of(2023,11,7,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(133,LocalDateTime.of(2023,11,8,8,0),LocalDateTime.of(2023,11,8,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(134,LocalDateTime.of(2023,11,9,8,0),LocalDateTime.of(2023,11,9,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(135,LocalDateTime.of(2023,11,10,8,0),LocalDateTime.of(2023,11,10,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(136,LocalDateTime.of(2023,11,13,8,0),LocalDateTime.of(2023,11,13,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(137,LocalDateTime.of(2023,11,14,8,0),LocalDateTime.of(2023,11,14,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(138,LocalDateTime.of(2023,11,15,8,0),LocalDateTime.of(2023,11,15,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(139,LocalDateTime.of(2023,11,16,8,0),LocalDateTime.of(2023,11,16,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(140,LocalDateTime.of(2023,11,17,8,0),LocalDateTime.of(2023,11,17,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(141,LocalDateTime.of(2023,11,20,8,0),LocalDateTime.of(2023,11,20,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(142,LocalDateTime.of(2023,11,21,8,0),LocalDateTime.of(2023,11,21,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(143,LocalDateTime.of(2023,11,22,8,0),LocalDateTime.of(2023,11,22,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(144,LocalDateTime.of(2023,11,23,8,0),LocalDateTime.of(2023,11,23,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(145,LocalDateTime.of(2023,11,24,8,0),LocalDateTime.of(2023,11,24,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(146,LocalDateTime.of(2023,11,27,8,0),LocalDateTime.of(2023,11,27,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(147,LocalDateTime.of(2023,11,28,8,0),LocalDateTime.of(2023,11,28,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(148,LocalDateTime.of(2023,11,29,8,0),LocalDateTime.of(2023,11,29,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(149,LocalDateTime.of(2023,11,30,8,0),LocalDateTime.of(2023,11,30,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(150,LocalDateTime.of(2023,12,1,8,0),LocalDateTime.of(2023,12,1,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(151,LocalDateTime.of(2023,12,4,8,0),LocalDateTime.of(2023,12,4,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(152,LocalDateTime.of(2023,12,5,8,0),LocalDateTime.of(2023,12,5,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(153,LocalDateTime.of(2023,12,6,8,0),LocalDateTime.of(2023,12,6,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(154,LocalDateTime.of(2023,12,7,8,0),LocalDateTime.of(2023,12,7,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(155,LocalDateTime.of(2023,12,8,8,0),LocalDateTime.of(2023,12,8,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(156,LocalDateTime.of(2023,12,11,8,0),LocalDateTime.of(2023,12,11,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(157,LocalDateTime.of(2023,12,12,8,0),LocalDateTime.of(2023,12,12,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(158,LocalDateTime.of(2023,12,13,8,0),LocalDateTime.of(2023,12,13,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(159,LocalDateTime.of(2023,12,14,8,0),LocalDateTime.of(2023,12,14,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(160,LocalDateTime.of(2023,12,15,8,0),LocalDateTime.of(2023,12,15,17,0),0,0,false,0,5); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(161,LocalDateTime.of(2023,11,2,8,0),LocalDateTime.of(2023,11,2,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(162,LocalDateTime.of(2023,11,3,8,0),LocalDateTime.of(2023,11,3,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(163,LocalDateTime.of(2023,11,6,8,0),LocalDateTime.of(2023,11,6,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(164,LocalDateTime.of(2023,11,7,8,0),LocalDateTime.of(2023,11,7,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(165,LocalDateTime.of(2023,11,8,8,0),LocalDateTime.of(2023,11,8,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(166,LocalDateTime.of(2023,11,9,8,0),LocalDateTime.of(2023,11,9,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(167,LocalDateTime.of(2023,11,10,8,0),LocalDateTime.of(2023,11,10,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(168,LocalDateTime.of(2023,11,13,8,0),LocalDateTime.of(2023,11,13,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(169,LocalDateTime.of(2023,11,14,8,0),LocalDateTime.of(2023,11,14,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(170,LocalDateTime.of(2023,11,15,8,0),LocalDateTime.of(2023,11,15,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(171,LocalDateTime.of(2023,11,16,8,0),LocalDateTime.of(2023,11,16,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(172,LocalDateTime.of(2023,11,17,8,0),LocalDateTime.of(2023,11,17,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(173,LocalDateTime.of(2023,11,20,8,0),LocalDateTime.of(2023,11,20,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(174,LocalDateTime.of(2023,11,21,8,0),LocalDateTime.of(2023,11,21,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(175,LocalDateTime.of(2023,11,22,8,0),LocalDateTime.of(2023,11,22,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(176,LocalDateTime.of(2023,11,23,8,0),LocalDateTime.of(2023,11,23,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(177,LocalDateTime.of(2023,11,24,8,0),LocalDateTime.of(2023,11,24,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(178,LocalDateTime.of(2023,11,27,8,0),LocalDateTime.of(2023,11,27,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(179,LocalDateTime.of(2023,11,28,8,0),LocalDateTime.of(2023,11,28,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(180,LocalDateTime.of(2023,11,29,8,0),LocalDateTime.of(2023,11,29,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(181,LocalDateTime.of(2023,11,30,8,0),LocalDateTime.of(2023,11,30,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(182,LocalDateTime.of(2023,12,1,8,0),LocalDateTime.of(2023,12,1,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(183,LocalDateTime.of(2023,12,4,8,0),LocalDateTime.of(2023,12,4,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(184,LocalDateTime.of(2023,12,5,8,0),LocalDateTime.of(2023,12,5,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(185,LocalDateTime.of(2023,12,6,8,0),LocalDateTime.of(2023,12,6,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(186,LocalDateTime.of(2023,12,7,8,0),LocalDateTime.of(2023,12,7,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(187,LocalDateTime.of(2023,12,8,8,0),LocalDateTime.of(2023,12,8,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(188,LocalDateTime.of(2023,12,11,8,0),LocalDateTime.of(2023,12,11,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(189,LocalDateTime.of(2023,12,12,8,0),LocalDateTime.of(2023,12,12,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(190,LocalDateTime.of(2023,12,13,8,0),LocalDateTime.of(2023,12,13,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(191,LocalDateTime.of(2023,12,14,8,0),LocalDateTime.of(2023,12,14,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(192,LocalDateTime.of(2023,12,15,8,0),LocalDateTime.of(2023,12,15,17,0),0,0,false,0,6); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(193,LocalDateTime.of(2023,11,2,8,0),LocalDateTime.of(2023,11,2,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(194,LocalDateTime.of(2023,11,3,8,0),LocalDateTime.of(2023,11,3,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(195,LocalDateTime.of(2023,11,6,8,0),LocalDateTime.of(2023,11,6,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(196,LocalDateTime.of(2023,11,7,8,0),LocalDateTime.of(2023,11,7,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(197,LocalDateTime.of(2023,11,8,8,0),LocalDateTime.of(2023,11,8,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(198,LocalDateTime.of(2023,11,9,8,0),LocalDateTime.of(2023,11,9,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(199,LocalDateTime.of(2023,11,10,8,0),LocalDateTime.of(2023,11,10,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(200,LocalDateTime.of(2023,11,13,8,0),LocalDateTime.of(2023,11,13,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(201,LocalDateTime.of(2023,11,14,8,0),LocalDateTime.of(2023,11,14,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(202,LocalDateTime.of(2023,11,15,8,0),LocalDateTime.of(2023,11,15,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(203,LocalDateTime.of(2023,11,16,8,0),LocalDateTime.of(2023,11,16,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(204,LocalDateTime.of(2023,11,17,8,0),LocalDateTime.of(2023,11,17,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(205,LocalDateTime.of(2023,11,20,8,0),LocalDateTime.of(2023,11,20,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(206,LocalDateTime.of(2023,11,21,8,0),LocalDateTime.of(2023,11,21,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(207,LocalDateTime.of(2023,11,22,8,0),LocalDateTime.of(2023,11,22,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(208,LocalDateTime.of(2023,11,23,8,0),LocalDateTime.of(2023,11,23,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(209,LocalDateTime.of(2023,11,24,8,0),LocalDateTime.of(2023,11,24,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(210,LocalDateTime.of(2023,11,27,8,0),LocalDateTime.of(2023,11,27,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(211,LocalDateTime.of(2023,11,28,8,0),LocalDateTime.of(2023,11,28,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(212,LocalDateTime.of(2023,11,29,8,0),LocalDateTime.of(2023,11,29,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(213,LocalDateTime.of(2023,11,30,8,0),LocalDateTime.of(2023,11,30,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(214,LocalDateTime.of(2023,12,1,8,0),LocalDateTime.of(2023,12,1,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(215,LocalDateTime.of(2023,12,4,8,0),LocalDateTime.of(2023,12,4,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(216,LocalDateTime.of(2023,12,5,8,0),LocalDateTime.of(2023,12,5,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(217,LocalDateTime.of(2023,12,6,8,0),LocalDateTime.of(2023,12,6,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(218,LocalDateTime.of(2023,12,7,8,0),LocalDateTime.of(2023,12,7,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(219,LocalDateTime.of(2023,12,8,8,0),LocalDateTime.of(2023,12,8,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(220,LocalDateTime.of(2023,12,11,8,0),LocalDateTime.of(2023,12,11,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(221,LocalDateTime.of(2023,12,12,8,0),LocalDateTime.of(2023,12,12,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(222,LocalDateTime.of(2023,12,13,8,0),LocalDateTime.of(2023,12,13,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(223,LocalDateTime.of(2023,12,14,8,0),LocalDateTime.of(2023,12,14,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(224,LocalDateTime.of(2023,12,15,8,0),LocalDateTime.of(2023,12,15,17,0),0,0,false,0,7); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(225,LocalDateTime.of(2023,11,2,8,0),LocalDateTime.of(2023,11,2,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(226,LocalDateTime.of(2023,11,3,8,0),LocalDateTime.of(2023,11,3,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(227,LocalDateTime.of(2023,11,6,8,0),LocalDateTime.of(2023,11,6,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(228,LocalDateTime.of(2023,11,7,8,0),LocalDateTime.of(2023,11,7,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(229,LocalDateTime.of(2023,11,8,8,0),LocalDateTime.of(2023,11,8,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(230,LocalDateTime.of(2023,11,9,8,0),LocalDateTime.of(2023,11,9,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(231,LocalDateTime.of(2023,11,10,8,0),LocalDateTime.of(2023,11,10,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(232,LocalDateTime.of(2023,11,13,8,0),LocalDateTime.of(2023,11,13,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(233,LocalDateTime.of(2023,11,14,8,0),LocalDateTime.of(2023,11,14,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(234,LocalDateTime.of(2023,11,15,8,0),LocalDateTime.of(2023,11,15,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(235,LocalDateTime.of(2023,11,16,8,0),LocalDateTime.of(2023,11,16,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(236,LocalDateTime.of(2023,11,17,8,0),LocalDateTime.of(2023,11,17,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(237,LocalDateTime.of(2023,11,20,8,0),LocalDateTime.of(2023,11,20,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(238,LocalDateTime.of(2023,11,21,8,0),LocalDateTime.of(2023,11,21,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(239,LocalDateTime.of(2023,11,22,8,0),LocalDateTime.of(2023,11,22,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(240,LocalDateTime.of(2023,11,23,8,0),LocalDateTime.of(2023,11,23,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(241,LocalDateTime.of(2023,11,24,8,0),LocalDateTime.of(2023,11,24,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(242,LocalDateTime.of(2023,11,27,8,0),LocalDateTime.of(2023,11,27,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(243,LocalDateTime.of(2023,11,28,8,0),LocalDateTime.of(2023,11,28,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(244,LocalDateTime.of(2023,11,29,8,0),LocalDateTime.of(2023,11,29,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(245,LocalDateTime.of(2023,11,30,8,0),LocalDateTime.of(2023,11,30,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(246,LocalDateTime.of(2023,12,1,8,0),LocalDateTime.of(2023,12,1,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(247,LocalDateTime.of(2023,12,4,8,0),LocalDateTime.of(2023,12,4,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(248,LocalDateTime.of(2023,12,5,8,0),LocalDateTime.of(2023,12,5,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(249,LocalDateTime.of(2023,12,6,8,0),LocalDateTime.of(2023,12,6,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(250,LocalDateTime.of(2023,12,7,8,0),LocalDateTime.of(2023,12,7,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(251,LocalDateTime.of(2023,12,8,8,0),LocalDateTime.of(2023,12,8,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(252,LocalDateTime.of(2023,12,11,8,0),LocalDateTime.of(2023,12,11,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(253,LocalDateTime.of(2023,12,12,8,0),LocalDateTime.of(2023,12,12,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(254,LocalDateTime.of(2023,12,13,8,0),LocalDateTime.of(2023,12,13,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(255,LocalDateTime.of(2023,12,14,8,0),LocalDateTime.of(2023,12,14,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(256,LocalDateTime.of(2023,12,15,8,0),LocalDateTime.of(2023,12,15,17,0),0,0,false,0,8); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(257,LocalDateTime.of(2023,11,2,8,0),LocalDateTime.of(2023,11,2,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(258,LocalDateTime.of(2023,11,3,8,0),LocalDateTime.of(2023,11,3,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(259,LocalDateTime.of(2023,11,6,8,0),LocalDateTime.of(2023,11,6,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(260,LocalDateTime.of(2023,11,7,8,0),LocalDateTime.of(2023,11,7,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(261,LocalDateTime.of(2023,11,8,8,0),LocalDateTime.of(2023,11,8,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(262,LocalDateTime.of(2023,11,9,8,0),LocalDateTime.of(2023,11,9,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(263,LocalDateTime.of(2023,11,10,8,0),LocalDateTime.of(2023,11,10,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(264,LocalDateTime.of(2023,11,13,8,0),LocalDateTime.of(2023,11,13,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(265,LocalDateTime.of(2023,11,14,8,0),LocalDateTime.of(2023,11,14,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(266,LocalDateTime.of(2023,11,15,8,0),LocalDateTime.of(2023,11,15,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(267,LocalDateTime.of(2023,11,16,8,0),LocalDateTime.of(2023,11,16,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(268,LocalDateTime.of(2023,11,17,8,0),LocalDateTime.of(2023,11,17,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(269,LocalDateTime.of(2023,11,20,8,0),LocalDateTime.of(2023,11,20,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(270,LocalDateTime.of(2023,11,21,8,0),LocalDateTime.of(2023,11,21,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(271,LocalDateTime.of(2023,11,22,8,0),LocalDateTime.of(2023,11,22,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(272,LocalDateTime.of(2023,11,23,8,0),LocalDateTime.of(2023,11,23,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(273,LocalDateTime.of(2023,11,24,8,0),LocalDateTime.of(2023,11,24,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(274,LocalDateTime.of(2023,11,27,8,0),LocalDateTime.of(2023,11,27,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(275,LocalDateTime.of(2023,11,28,8,0),LocalDateTime.of(2023,11,28,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(276,LocalDateTime.of(2023,11,29,8,0),LocalDateTime.of(2023,11,29,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(277,LocalDateTime.of(2023,11,30,8,0),LocalDateTime.of(2023,11,30,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(278,LocalDateTime.of(2023,12,1,8,0),LocalDateTime.of(2023,12,1,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(279,LocalDateTime.of(2023,12,4,8,0),LocalDateTime.of(2023,12,4,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(280,LocalDateTime.of(2023,12,5,8,0),LocalDateTime.of(2023,12,5,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(281,LocalDateTime.of(2023,12,6,8,0),LocalDateTime.of(2023,12,6,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(282,LocalDateTime.of(2023,12,7,8,0),LocalDateTime.of(2023,12,7,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(283,LocalDateTime.of(2023,12,8,8,0),LocalDateTime.of(2023,12,8,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(284,LocalDateTime.of(2023,12,11,8,0),LocalDateTime.of(2023,12,11,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(285,LocalDateTime.of(2023,12,12,8,0),LocalDateTime.of(2023,12,12,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(286,LocalDateTime.of(2023,12,13,8,0),LocalDateTime.of(2023,12,13,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(287,LocalDateTime.of(2023,12,14,8,0),LocalDateTime.of(2023,12,14,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(288,LocalDateTime.of(2023,12,15,8,0),LocalDateTime.of(2023,12,15,17,0),0,0,false,0,9); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(289,LocalDateTime.of(2023,11,2,8,0),LocalDateTime.of(2023,11,2,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(290,LocalDateTime.of(2023,11,3,8,0),LocalDateTime.of(2023,11,3,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(291,LocalDateTime.of(2023,11,6,8,0),LocalDateTime.of(2023,11,6,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(292,LocalDateTime.of(2023,11,7,8,0),LocalDateTime.of(2023,11,7,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(293,LocalDateTime.of(2023,11,8,8,0),LocalDateTime.of(2023,11,8,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(294,LocalDateTime.of(2023,11,9,8,0),LocalDateTime.of(2023,11,9,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(295,LocalDateTime.of(2023,11,10,8,0),LocalDateTime.of(2023,11,10,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(296,LocalDateTime.of(2023,11,13,8,0),LocalDateTime.of(2023,11,13,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(297,LocalDateTime.of(2023,11,14,8,0),LocalDateTime.of(2023,11,14,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(298,LocalDateTime.of(2023,11,15,8,0),LocalDateTime.of(2023,11,15,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(299,LocalDateTime.of(2023,11,16,8,0),LocalDateTime.of(2023,11,16,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(300,LocalDateTime.of(2023,11,17,8,0),LocalDateTime.of(2023,11,17,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(301,LocalDateTime.of(2023,11,20,8,0),LocalDateTime.of(2023,11,20,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(302,LocalDateTime.of(2023,11,21,8,0),LocalDateTime.of(2023,11,21,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(303,LocalDateTime.of(2023,11,22,8,0),LocalDateTime.of(2023,11,22,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(304,LocalDateTime.of(2023,11,23,8,0),LocalDateTime.of(2023,11,23,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(305,LocalDateTime.of(2023,11,24,8,0),LocalDateTime.of(2023,11,24,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(306,LocalDateTime.of(2023,11,27,8,0),LocalDateTime.of(2023,11,27,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(307,LocalDateTime.of(2023,11,28,8,0),LocalDateTime.of(2023,11,28,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(308,LocalDateTime.of(2023,11,29,8,0),LocalDateTime.of(2023,11,29,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(309,LocalDateTime.of(2023,11,30,8,0),LocalDateTime.of(2023,11,30,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(310,LocalDateTime.of(2023,12,1,8,0),LocalDateTime.of(2023,12,1,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(311,LocalDateTime.of(2023,12,4,8,0),LocalDateTime.of(2023,12,4,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(312,LocalDateTime.of(2023,12,5,8,0),LocalDateTime.of(2023,12,5,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(313,LocalDateTime.of(2023,12,6,8,0),LocalDateTime.of(2023,12,6,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(314,LocalDateTime.of(2023,12,7,8,0),LocalDateTime.of(2023,12,7,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(315,LocalDateTime.of(2023,12,8,8,0),LocalDateTime.of(2023,12,8,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(316,LocalDateTime.of(2023,12,11,8,0),LocalDateTime.of(2023,12,11,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(317,LocalDateTime.of(2023,12,12,8,0),LocalDateTime.of(2023,12,12,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(318,LocalDateTime.of(2023,12,13,8,0),LocalDateTime.of(2023,12,13,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(319,LocalDateTime.of(2023,12,14,8,0),LocalDateTime.of(2023,12,14,17,0),0,0,false,0,10); colAsistencia.add(asistencia);
//        asistencia = new Asistencia(320,LocalDateTime.of(2023,12,15,8,0),LocalDateTime.of(2023,12,15,17,0),0,0,false,0,10); colAsistencia.add(asistencia);

        asignarTardanza();
        asignarHoraExtra();
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public LocalDateTime getAsiFecHoraEntrada() {
        return asiFecHoraEntrada;
    }

    public void setAsiFecHoraEntrada(LocalDateTime asiFecHoraEntrada) {
        this.asiFecHoraEntrada = asiFecHoraEntrada;
    }

    public LocalDateTime getAsiFecHoraSalida() {
        return asiFecHoraSalida;
    }

    public void setAsiFecHoraSalida(LocalDateTime asiFecHoraSalida) {
        this.asiFecHoraSalida = asiFecHoraSalida;
    }

    public long getAsiMinutoTardanza() {
        return asiMinutoTardanza;
    }

    public void setAsiMinutoTardanza(long asiMinutoTardanza) {
        this.asiMinutoTardanza = asiMinutoTardanza;
    }

    public long getAsiMinutoHoraExtra() {
        return asiMinutoHoraExtra;
    }

    public void setAsiMinutoHoraExtra(long asiMinutoHoraExtra) {
        this.asiMinutoHoraExtra = asiMinutoHoraExtra;
    }

    public boolean isAsiSwAutoHoraExtra() {
        return asiSwAutoHoraExtra;
    }

    public void setAsiSwAutoHoraExtra(boolean asiSwAutoHoraExtra) {
        this.asiSwAutoHoraExtra = asiSwAutoHoraExtra;
    }

    public long getAsiMinutoTrabajado() {
        return asiMinutoTrabajado;
    }

    public void setAsiMinutoTrabajado(long asiMinutoTrabajado) {
        this.asiMinutoTrabajado = asiMinutoTrabajado;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public LinkedList<Asistencia> getColAsistencia() {
        return colAsistencia;
    }

    public void setColAsistencia(LinkedList<Asistencia> colAsistencia) {
        this.colAsistencia = colAsistencia;
    }

    public LocalDateTime getFecHoraEntrada() {
        return fecHoraEntrada;
    }

    public void setFecHoraEntrada(LocalDateTime fecHoraEntrada) {
        this.fecHoraEntrada = fecHoraEntrada;
    }

    public LocalDateTime getFecHoraSalida() {
        return fecHoraSalida;
    }

    public void setFecHoraSalida(LocalDateTime fecHoraSalida) {
        this.fecHoraSalida = fecHoraSalida;
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "idAsistencia=" + idAsistencia +
                ", asiFecHoraEntrada=" + asiFecHoraEntrada +
                ", asiFecHoraSalida=" + asiFecHoraSalida +
                ", asiMinutoTardanza=" + asiMinutoTardanza +
                ", asiMinutoHoraExtra=" + asiMinutoHoraExtra +
                ", asiSwAutoHoraExtra=" + asiSwAutoHoraExtra +
                ", asiMinutoTrabajado=" + asiMinutoTrabajado +
                ", idPersona=" + idPersona +
                '}';
    }
}
