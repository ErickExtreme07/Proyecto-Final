package animales;

import acciones.Animal;

public class perico extends Animal{
    private String especie;

    public perico(String nombre, int edad, String especie, String estadoSalud) {
        super(nombre, edad, especie, estadoSalud);
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void alimentar() {
        System.out.println(getNombre() + " El perico ha sido alimentado.");
    }

    public void dormir() {
        System.out.println(getNombre() + " El perico está durmiendo.");
    }

    public void volar() {
        System.out.println(getNombre() + " El perico está volando dentro de su jaula.");
    }
}
