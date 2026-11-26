package modelo;
// AUTOR: SEBASTIAN PAREDES PACHECO
// MODULO 3: ORGANIZACION Y REVISION DE EVIDENCIAS
//REGISTRAR EVIDENCIAS
// REVISAR EVIDENCIAS

public class Evidencia {


    private int codigo;
    private int codigoCaso;
    private String tipo;
    private String descripcion;
    private String procedencia;
    private String fecha;
    private String archivo;
    private String estado;
    private String observacion;


    public Evidencia(int codigo, int codigoCaso, String tipo,
                     String descripcion, String procedencia,
                     String fecha, String archivo) {

        this.codigo = codigo;
        this.codigoCaso = codigoCaso;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.procedencia = procedencia;
        this.fecha = fecha;
        this.archivo = archivo;


        this.estado = "Pendiente";
        this.observacion = "Sin observacion";
    }


    public int getCodigo() {
        return codigo;
    }


    public int getCodigoCaso() {
        return codigoCaso;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }


    public void mostrarEvidencia() {

        System.out.println("Codigo evidencia: " + codigo);
        System.out.println("Codigo caso: " + codigoCaso);
        System.out.println("Tipo: " + tipo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Procedencia: " + procedencia);
        System.out.println("Fecha: " + fecha);
        System.out.println("Archivo: " + archivo);
        System.out.println("Estado: " + estado);
        System.out.println("Observacion: " + observacion);
        System.out.println("----------------------------");
    }

    protected String getEvidencia(){
        return estado;
    }
}
