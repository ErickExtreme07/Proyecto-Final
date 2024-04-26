package acciones;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class Refugio implements Serializable {
    private List<Animal> listaAnimales;

    public Refugio() {
        listaAnimales = new ArrayList<>();
    }

    public void agregarAnimal(Animal animal) {
        listaAnimales.add(animal);
    }

    public void eliminarAnimal(Animal animal) {
        listaAnimales.remove(animal);
    }

    public List<Animal> getListaAnimales() {
        return listaAnimales;
    }

    public void mostrarAnimales() {
        System.out.println("Lista de animales disponibles en el refugio:");
        if (listaAnimales.isEmpty()) {
            System.out.println("No hay animales registrados en el refugio.");
        } else {
            for (Animal animal : listaAnimales) {
                System.out.println(animal.getNombre() + " es un " + animal.getEspecie() + " | Edad " + animal.getEdad());

            }

        }

    }

    public void setListaAnimales(List<Animal> listaAnimales) {
        this.listaAnimales = listaAnimales;
    }
}
