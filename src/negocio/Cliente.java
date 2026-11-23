package negocio;

import javax.swing.*;

public class Cliente extends Usuario{

    private boolean llavedeAcceso;

    public Cliente(String idUser, String nombre, String correo, String contrasena, boolean llavedeAcceso) {
        super(idUser, nombre, correo, contrasena);
        this.llavedeAcceso = false;
    }

    public void solicitarAcceso(){
        if (!isActivo()) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión para solicitar acceso.");
            return;
        }
        if (this.llavedeAcceso) {
            JOptionPane.showMessageDialog(null, "Ya posee llave de acceso habilitada.");
        } else {
            JOptionPane.showMessageDialog(null, "Solicitud de acceso enviada para el usuario " + getNombre() + ".");
        }
    }

    public void verEstadoSolicitud(){
        if (!isActivo()) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión para ver el estado de su solicitud.");
            return;
        }
        String estado = this.llavedeAcceso ? "APROBADA (Acceso activo)" : "PENDIENTE / SIN ACCESO";
        JOptionPane.showMessageDialog(null, "Estado de solicitud de " + getNombre() + ": " + estado);
    }

    public boolean verConsultarInformacion(){
        if (!isActivo()) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión para consultar información.");
            return false;
        }
        String idCaso = JOptionPane.showInputDialog(null, "Ingrese el ID del caso para consultar información pública:");
        if (idCaso == null || idCaso.isBlank()) {
            return false;
        }
        JOptionPane.showMessageDialog(null, "Información pública consultada para el caso #" + idCaso.trim() + ".");
        return true;
    }

    public boolean registrarAvistamiento() {
        if (!isActivo()) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión para registrar un avistamiento.");
            return false;
        }
        String detalle = JOptionPane.showInputDialog(null, "Ingrese lugar, fecha y detalle del avistamiento:");
        if (detalle == null || detalle.isBlank()) {
            JOptionPane.showMessageDialog(null, "No se registró el avistamiento: datos incompletos.");
            return false;
        }
        JOptionPane.showMessageDialog(null, "Avistamiento registrado y enviado a revisión.");
        return true;
    }

    public void solicitarAvistamiento() {
        if (!isActivo()) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión para solicitar información de avistamientos.");
            return;
        }
        String idCaso = JOptionPane.showInputDialog(null, "Ingrese el ID del caso para solicitar actualización de avistamientos:");
        if (idCaso != null && !idCaso.isBlank()) {
            JOptionPane.showMessageDialog(null, "Solicitud de avistamientos registrada para el caso #" + idCaso.trim() + ".");
        }
    }

    public boolean getLlaveDeAcceso(){
        return llavedeAcceso;
    }

}
