import entidades.Feriado;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        Feriado feriado = new Feriado();
        feriado.llenarDatosIniciales();
        LinkedList<Feriado> colFeriado = feriado.getColFeriado();
        for (Feriado fer : colFeriado){
            System.out.println(fer.toString());
        }

    }
}