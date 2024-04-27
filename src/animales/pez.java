package animales;

import acciones.Animal;

public class pez extends Animal{
    private String especie;

    public pez(String nombre, int edad, String especie, String estadoSalud) {
        super(nombre, edad, especie, estadoSalud);
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void alimentar() {
        System.out.println(getNombre() + " Ha sido alimentado.");
    }

    public void jugar() {
        System.out.println(getNombre() + " Juega al escondite.");
    }

    public void dormir() {
        System.out.println(getNombre() + " Duerme en su arrecife.");
    }

    public void nadar() {
        System.out.println(getNombre() + " Nada en su pecera.");
    }
}
