package acciones;



public class Verificacion {

    public Verificacion(String nom, String ape, String ced, String email) {

    }

    public static boolean validarNom(String nom) {
        return nom.matches("^[A-Z][a-zA-Z ]{1,19}$");
    }

    public static boolean validarape(String ape) {
        return ape.matches("^[A-Z][a-zA-Z ]{1,19}$");
    }

    public static boolean validarCed(String ced){
        return ced.matches("^[A-Z]-[0-9]{1,5}-[0-9]{1,6}-*[0-9]{0,5}|[0-9]{1,5}-[0-9]{1,5}-[0-9]{1,5}$");
    }

    public static boolean validarCorreo (String correo) {
        return correo.matches("^[A-Za-z0-9._%+-]+@[(G-gmail|H-hotmail|O-outlook|]+.[A-Z|a-z]{2,}$");
    }
}