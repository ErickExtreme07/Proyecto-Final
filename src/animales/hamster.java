package animales;

import acciones.Animal;

public class hamster extends Animal{
    private String especie;

    public hamster(String nombre, int edad, String especie, String estadoSalud) {
        super(nombre, edad, especie, estadoSalud);
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void alimentar() {
        System.out.println(getNombre() + "ha sido alimentado.");
    }

    public void dormir() {
        System.out.println(getNombre() + "está durmiendo.");
    }

    public void jugar() {
        System.out.println(getNombre() + "está corriendo en su rueda.");
    }
     public void asustar() {
        System.out.println(getNombre() + "se asusto.");
    }
     public void chillar () {
        System.out.println(getNombre() + "está chillando.");
    }
    
}
