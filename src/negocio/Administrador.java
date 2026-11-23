package negocio;

import javax.swing.JOptionPane;

public class Administrador extends Usuario {

    private int numerodeSolicitudesUsuarios;

    public Administrador(String idUser, String nombre, String correo, String contrasena, int numerodeSolicitudesUsuarios) {
        super(idUser, nombre, correo, contrasena);
        this.numerodeSolicitudesUsuarios = Math.max(0, numerodeSolicitudesUsuarios);
    }

    public void validarSolicitud() {
        if (!isActivo()) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión como administrador para validar solicitudes.");
            return;
        }
        if (this.numerodeSolicitudesUsuarios <= 0) {
            JOptionPane.showMessageDialog(null, "No hay solicitudes pendientes por validar.");
            return;
        }
        this.numerodeSolicitudesUsuarios--;
        JOptionPane.showMessageDialog(null,
                "Solicitud validada correctamente. Solicitudes pendientes: " + this.numerodeSolicitudesUsuarios);
    }

    public void rechazarSolicitud() {
        if (!isActivo()) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión como administrador para rechazar solicitudes.");
            return;
        }
        if (this.numerodeSolicitudesUsuarios <= 0) {
            JOptionPane.showMessageDialog(null, "No hay solicitudes pendientes por rechazar.");
            return;
        }
        this.numerodeSolicitudesUsuarios--;
        JOptionPane.showMessageDialog(null,
                "Solicitud rechazada. Solicitudes pendientes: " + this.numerodeSolicitudesUsuarios);
    }

    public void gestionarCasos() {
        if (!isActivo()) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión como administrador para gestionar casos.");
            return;
        }
        String opcion = JOptionPane.showInputDialog(null,
                "Gestión de casos:\n1. Registrar caso\n2. Actualizar estado\nIngrese una opción:");
        if (opcion != null && !opcion.isBlank()) {
            JOptionPane.showMessageDialog(null, "Operación de casos (" + opcion.trim() + ") ejecutada.");
        }
    }

    public void gestionarEvidencias() {
        if (!isActivo()) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión como administrador para gestionar evidencias.");
            return;
        }
        String idEvidencia = JOptionPane.showInputDialog(null, "Ingrese el ID de la evidencia a evaluar:");
        if (idEvidencia != null && !idEvidencia.isBlank()) {
            JOptionPane.showMessageDialog(null, "Evidencia #" + idEvidencia.trim() + " gestionada.");
        }
    }

    public void gestionarAccionesBusqueda() {
        if (!isActivo()) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión como administrador para gestionar acciones de búsqueda.");
            return;
        }
        String accion = JOptionPane.showInputDialog(null, "Ingrese la acción o zona de búsqueda a actualizar:");
        if (accion != null && !accion.isBlank()) {
            JOptionPane.showMessageDialog(null, "Acción de búsqueda '" + accion.trim() + "' actualizada.");
        }
    }

    public void gestionarPermisos() {
        if (!isActivo()) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión como administrador para gestionar permisos.");
            return;
        }
        String usuarioId = JOptionPane.showInputDialog(null, "Ingrese el ID del usuario para actualizar permisos:");
        if (usuarioId != null && !usuarioId.isBlank()) {
            JOptionPane.showMessageDialog(null, "Permisos actualizados para el usuario [" + usuarioId.trim() + "].");
        }
    }

    public void consultarHistorial() {
        if (!isActivo()) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión como administrador para consultar el historial.");
            return;
        }
        JOptionPane.showMessageDialog(null,
                "Consultando historial del sistema.\nSolicitudes de usuarios registradas: " + this.numerodeSolicitudesUsuarios);
    }
}