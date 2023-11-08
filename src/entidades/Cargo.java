package entidades;

import java.util.LinkedList;

public class Cargo {
    private int idCargo;
    private String carNombre;

    private LinkedList<Cargo> colCargo;

    public Cargo(int idCargo, String carNombre) {
        this.idCargo = idCargo;
        this.carNombre = carNombre;
    }

    public Cargo() {
    }

    public void llenarDatosIniciales(){
        colCargo = new LinkedList<Cargo>();
        Cargo cargo;

        cargo = new Cargo(1,"Administrativo"); colCargo.add(cargo);
        cargo = new Cargo(2,"Recursos Humanos"); colCargo.add(cargo);
        cargo = new Cargo(3,"Administrador"); colCargo.add(cargo);
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "idCargo=" + idCargo +
                ", carNombre='" + carNombre + '\'' +
                ", colCargo=" + colCargo +
                '}';
    }

    public LinkedList<Cargo> getColCargo() {
        return colCargo;
    }

    public void setColCargo(LinkedList<Cargo> colCargo) {
        this.colCargo = colCargo;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getCarNombre() {
        return carNombre;
    }

    public void setCarNombre(String carNombre) {
        this.carNombre = carNombre;
    }
}
