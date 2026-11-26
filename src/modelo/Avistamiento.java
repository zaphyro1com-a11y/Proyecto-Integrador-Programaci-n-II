package modelo;
// ======================================================
// CLASE AVISTAMIENTO
// Representa un reporte ciudadano relacionado con un caso.
// ======================================================
public class Avistamiento {
    private int codigo;
    private int codigoCaso;
    private String descripcion;
    private String lugar;
    private String fecha;
    private String hora;
    private String contacto;
    private String estado;

    public Avistamiento(int codigo, int codigoCaso, String descripcion,
                        String lugar, String fecha, String hora, String contacto) {
        this.codigo = codigo;
        this.codigoCaso = codigoCaso;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
        this.contacto = contacto;
        this.estado = "Pendiente";
    }

    public int getCodigo() { return codigo; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public void mostrarAvistamiento() {
        System.out.println("Codigo reporte: " + codigo);
        System.out.println("Codigo del caso: " + codigoCaso);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Lugar: " + lugar);
        System.out.println("Fecha y hora: " + fecha + " " + hora);
        System.out.println("Contacto: " + contacto);
        System.out.println("Estado: " + estado);
        System.out.println("----------------------------------");
    }
}
