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
        System.out.println(getNombre() + " El pez ha sido alimentado.");
    }

    public void dormir() {
        System.out.println(getNombre() + " El pez está durmiendo.");
    }

    public void nadar() {
        System.out.println(getNombre() + " El pez nada en su pecera.");
    }
}
