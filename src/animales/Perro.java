package animales;

import acciones.Animal;

public class Perro extends Animal{
    private String especie;

    public Perro(String nombre, int edad, String especie, String estadoSalud) {
        super(nombre, edad, especie, estadoSalud);
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void alimentar() {
        System.out.println(getNombre() + " El perro ha sido alimentado.");
    }

    public void dormir() {
        System.out.println(getNombre() + " El perro está durmiendo.");
    }

    public void jugar() {
        System.out.println(getNombre() + " El perro está jugando con su pelota.");
    }
}

