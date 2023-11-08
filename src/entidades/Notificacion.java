package entidades;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;

public class Notificacion {
    private int idNotificacion;
    private String notMensaje;
    private LocalDate notFecEnvio;
    private LocalDate notFecLectura;

    private LinkedList<Notificacion> colNotificacion;

    public Notificacion() {
    }

    public void llenarDatosIniciales(){
        colNotificacion = new LinkedList<Notificacion>();
        Notificacion notificacion;

        notificacion = new Notificacion(1,"Justificacion de falta", LocalDate.of(2022,10,10),LocalDate.of(2022,10,13)); colNotificacion.add(notificacion);
        notificacion = new Notificacion(2,"Tardanza", LocalDate.of(2022,10,11),LocalDate.of(2022,10,12)); colNotificacion.add(notificacion);
        notificacion = new Notificacion(3,"Emision de boleta de pago", LocalDate.of(2022,10,16),LocalDate.of(2022,10,18)); colNotificacion.add(notificacion);
        notificacion = new Notificacion(4,"Registro de horas extras", LocalDate.of(2022,10,17),LocalDate.of(2022,10,19)); colNotificacion.add(notificacion);
        notificacion = new Notificacion(5,"Justificacion de tardanza", LocalDate.of(2022,10,18),LocalDate.of(2022,10,20)); colNotificacion.add(notificacion);
        notificacion = new Notificacion(6,"Tardanza", LocalDate.of(2022,10,19),LocalDate.of(2022,10,20)); colNotificacion.add(notificacion);
        notificacion = new Notificacion(7,"Justificacion", LocalDate.of(2022,10,20),LocalDate.of(2022,10,22)); colNotificacion.add(notificacion);
        notificacion = new Notificacion(8,"Tardanza", LocalDate.of(2022,10,21),LocalDate.of(2022,10,23)); colNotificacion.add(notificacion);
        notificacion = new Notificacion(9,"Justificacion", LocalDate.of(2022,10,22),LocalDate.of(2022,10,12)); colNotificacion.add(notificacion);
        notificacion = new Notificacion(10,"Tardanza", LocalDate.of(2022,10,23),LocalDate.of(2022,10,15)); colNotificacion.add(notificacion);

    }
    public Notificacion(int idNotificacion, String notMensaje, LocalDate notFecEnvio, LocalDate notFecLectura) {
        this.idNotificacion = idNotificacion;
        this.notMensaje = notMensaje;
        this.notFecEnvio = notFecEnvio;
        this.notFecLectura = notFecLectura;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getNotMensaje() {
        return notMensaje;
    }

    public void setNotMensaje(String notMensaje) {
        this.notMensaje = notMensaje;
    }

    public LocalDate getNotFecEnvio() {
        return notFecEnvio;
    }

    public void setNotFecEnvio(LocalDate notFecEnvio) {
        this.notFecEnvio = notFecEnvio;
    }

    public LocalDate getNotFecLectura() {
        return notFecLectura;
    }

    public void setNotFecLectura(LocalDate notFecLectura) {
        this.notFecLectura = notFecLectura;
    }

    public LinkedList<Notificacion> getColNotificacion() {
        return colNotificacion;
    }

    public void setColNotificacion(LinkedList<Notificacion> colNotificacion) {
        this.colNotificacion = colNotificacion;
    }

    @Override
    public String toString() {
        return "Notificacion{" +
                "idNotificacion=" + idNotificacion +
                ", notMensaje='" + notMensaje + '\'' +
                ", notFecEnvio=" + notFecEnvio +
                ", notFecLectura=" + notFecLectura +
                '}';
    }
}
