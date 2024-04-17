package acciones;

import acciones.Verificacion;

public class Usuario {
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String direccion;

    public Usuario(String nombre, String apellido, String cedula, String correo, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public boolean validar(){
        return Verificacion.validarNom(nombre)&&
                Verificacion.validarape(apellido)&&
                Verificacion.validarCed(cedula)&&
                Verificacion.validarCorreo(correo);

    }
}
