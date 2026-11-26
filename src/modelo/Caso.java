package modelo;

// ======================================================
// CLASE HIJA: CASO
// Utiliza extends para heredar nombre y edad de Persona.
// ======================================================
public class Caso extends Persona {
    private int codigo;
    private String caracteristicas;
    private String fechaDesaparicion;
    private String lugar;
    private String contactoFamiliar;
    private String provincia;
    private String estado;

    // Constructor de Caso. super llama al constructor de Persona.
    public Caso(int codigo, String nombre, int edad, String caracteristicas,
                String fechaDesaparicion, String lugar,
                String contactoFamiliar, String provincia) {
        super(nombre, edad);
        this.codigo = codigo;
        this.caracteristicas = caracteristicas;
        this.fechaDesaparicion = fechaDesaparicion;
        this.lugar = lugar;
        this.contactoFamiliar = contactoFamiliar;
        this.provincia = provincia;
        this.estado = "Abierto";
    }

    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getFechaDesaparicion() { return fechaDesaparicion; }
    public String getLugar() { return lugar; }
    public String getProvincia() { return provincia; }
    public String getEstado() { return estado; }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Muestra la información completa del caso.
    public void mostrarCaso() {
        System.out.println("----------------------------------");
        System.out.println("Codigo: " + codigo);
        super.mostrarDatos();
        System.out.println("Caracteristicas: " + caracteristicas);
        System.out.println("Fecha: " + fechaDesaparicion);
        System.out.println("Lugar: " + lugar);
        System.out.println("Contacto familiar: " + contactoFamiliar);
        System.out.println("Provincia: " + provincia);
        System.out.println("Estado: " + estado);
    }
}
