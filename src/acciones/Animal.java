package acciones;

import java.io.Serializable;

public class Animal implements Serializable {
    private String nombre;
    private int edad;
    private String especie;
    private String estadoSalud;

    public Animal(String nombre, int edad, String especie, String estadoSalud) {
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.estadoSalud = estadoSalud;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEspecie() {
        return especie;
    }

    public String getEstadoSalud() {
        return estadoSalud;
    }
}
