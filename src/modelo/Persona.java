// ======================================================
// CLASE PADRE
// Contiene los datos generales que puede tener una persona.
// ======================================================
public class Persona {
    protected String nombre;
    protected int edad;

    // Constructor de la clase Persona.
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método para mostrar los datos generales.
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }
}
