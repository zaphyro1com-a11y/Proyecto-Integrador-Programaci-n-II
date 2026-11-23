package negocio;

import javax.swing.*;

public class Usuario {

    private String idUser; //Identificador Unico del usuario
    private String nombre; //Nombre del usuario
    private String correo; // Correo utilizado para iniciar sesion
    private String contrasena; // Contraseña del usuario para que pueda ingresar
    private boolean activo; // Saber si la cuenta esta activa o no

    public Usuario(String idUser, String nombre, String correo, String contrasena) {
        this.idUser = idUser;
        setNombre(nombre);
        setCorreo(correo);
        setContrasena(contrasena);
        this.activo = false;
    }

    public boolean iniciarSesion(String correo, String contrasena){
        if (this.correo.equals(correo) && this.contrasena.equals(contrasena)){
            this.activo = true;
            return true;
        }

        return false;
    }
    public void cerrarSesion(){
        this.activo = false;
        JOptionPane.showMessageDialog(null,"Se ha cerrado sesion exitosamente");
    }
    public void consultarCaso(){
        //Pendiente de implementar
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdUser() {
        return idUser;
    }

    public boolean isActivo(){
        return activo;
    }

    public void setNombre(String nombre) {
        String res = nombre;
        if (nombre == null || nombre.isBlank())
            res = "INDEFINIDO";

        this.nombre = res;
    }

    public void setCorreo(String correo) {
        String res = correo;
        if (correo == null || correo.isBlank())
            res = "INDEFINIDO";

        this.correo = res;
    }

    public void setContrasena(String contrasena) {
        String res = contrasena;
        if (contrasena == null || contrasena.isBlank())
            res = "INDEFINIDO";

        this.contrasena = res;
    }
}
