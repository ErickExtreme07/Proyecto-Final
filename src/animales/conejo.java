package animales;

import acciones.Animal;

public class conejo extends Animal{
    private String especie;

    public conejo(String nombre, int edad, String especie, String estadoSalud) {
        super(nombre, edad, especie, estadoSalud);
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void alimentar() {
        System.out.println(getNombre() + " El conejo ha sido alimentado.");
    }

    public void dormir() {
        System.out.println(getNombre() + " El conejo está durmiendo.");
    }

    public void saltar() {
        System.out.println(getNombre() + " El conejo está saltando en el patio.");
    }
}
