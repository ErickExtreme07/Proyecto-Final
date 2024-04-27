package animales;


public class gato extends Animal{
    private String especie;

    public gato(String nombre,int edad, String especie, String estadoSalud) {
        super(nombre, edad, especie, estadoSalud);
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void alimentar() {
        System.out.println(getNombre() + " Ha sido alimentado. ");
    }

    public void ayuda() {
        System.out.println(getNombre() + " Te ayuda con traumas emocionales. ");
    }
    
    public void dormir() {
        System.out.println(getNombre() + " Está durmiendo.");
    }

     public void orientacion() {
        System.out.println(getNombre() + " Ve en la oscuridad.");
    }

    public void jugar() {
        System.out.println(getNombre() + " Está jugando con su juguete.");
    }

    public void ronronear() {
        System.out.println(getNombre() + " está ronroneando... ¡Purrr!");
    }

}
