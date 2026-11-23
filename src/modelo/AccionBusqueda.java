// ======================================================
// CLASE ACCION DE BUSQUEDA
// Representa una actividad que se realiza para buscar a alguien.
// ======================================================
public class AccionBusqueda {
    private int codigo;
    private int codigoCaso;
    private String actividad;
    private String zona;
    private String responsable;
    private String fechaPrevista;
    private String estado;
    private String resultado;

    public AccionBusqueda(int codigo, int codigoCaso, String actividad, String zona,
                          String responsable, String fechaPrevista) {
        this.codigo = codigo;
        this.codigoCaso = codigoCaso;
        this.actividad = actividad;
        this.zona = zona;
        this.responsable = responsable;
        this.fechaPrevista = fechaPrevista;
        this.estado = "Pendiente";
        this.resultado = "Sin resultado";
    }

    public int getCodigo() { return codigo; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setResultado(String resultado) { this.resultado = resultado; }

    public void mostrarAccion() {
        System.out.println("Codigo accion: " + codigo);
        System.out.println("Codigo caso: " + codigoCaso);
        System.out.println("Actividad: " + actividad);
        System.out.println("Zona: " + zona);
        System.out.println("Responsable: " + responsable);
        System.out.println("Fecha prevista: " + fechaPrevista);
        System.out.println("Estado: " + estado);
        System.out.println("Resultado: " + resultado);
        System.out.println("----------------------------------");
    }
}
