package animales;

import acciones.Animal;

public class gato extends Animal{
    private String especie;

    public gato(String nombre, int edad, String especie, String estadoSalud) {
        super(nombre, edad, especie, estadoSalud);
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void alimentar() {
        System.out.println(getNombre() + " El gato ha sido alimentado.");
    }

    public void dormir() {
        System.out.println(getNombre() + " El gato está durmiendo.");
    }

    public void jugar() {
        System.out.println(getNombre() + " El gato está jugando con su juguete.");
    }
}
