package animales;

import acciones.Animal;

public class conejo extends Animal{
    private String especie;

    public conejo (String nombre, int edad, String especie, String estadoSalud) {
        super(nombre, edad, especie, estadoSalud);
        this.especie = especie;
}

    public String getEspecie(){
        return especie;
    }

    public void alimentar() {
        System.out.println(getNombre() + " Esta comiendo zanahoria. ");
    }
    
    public void invernar() {
        System.out.println(getNombre() + " Hace su madriguera. ");
    }

    public void jugar() {
        System.out.println(getNombre() + " Juega con la pelota. ");
    }
   
   public void dormir() {
        System.out.println(getNombre() + " Duerme en su madriguera. ");
   }

    public void saltar() {
        System.out.println(getNombre() + " Salta en el patio. ");
    }
    
    public void buscarComida() {
        System.out.println(getNombre() + " está buscando comida en el jardín.");
    }

}
