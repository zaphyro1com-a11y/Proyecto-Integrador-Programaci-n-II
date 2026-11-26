package modelo;

// Responsable de la clase y sus metodos: Matheo Cañarejo.
// Modulo 4: seguimiento de acciones de busqueda.
import java.util.Scanner;
public class ModuloAcciones {
    private AccionBusqueda[] acciones = new AccionBusqueda[100];
    private int cantidad = 0;
    public void menu(Scanner teclado, ModuloCasos casos) {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n--- MODULO 4: ACCIONES DE BUSQUEDA ---");
            System.out.println("Responsable: Matheo Cañarejo");
            System.out.println("1. Registrar accion\n2. Consultar acciones\n3. Actualizar accion\n4. Volver al menu principal");
            opcion = Entrada.numero(teclado, "Opcion: ");
            switch (opcion) {
                case 1: registrar(teclado, casos); break;
                case 2: consultar(); break;
                case 3: actualizar(teclado); break;
                case 4: break;
                default: System.out.println("Opcion incorrecta.");
            }
        }
    }
    public void registrar(Scanner teclado, ModuloCasos casos) {
        if (cantidad >= acciones.length) { System.out.println("Sin espacio."); return; }
        int codigoCaso = Entrada.numero(teclado, "Codigo del caso: ");
        if (casos.buscarCaso(codigoCaso) == null) { System.out.println("El caso no existe."); return; }
        String actividad = Entrada.texto(teclado, "Actividad: ");
        String zona = Entrada.texto(teclado, "Zona: ");
        String responsable = Entrada.texto(teclado, "Responsable de la actividad: ");
        String fecha = Entrada.texto(teclado, "Fecha prevista: ");
        if (actividad.equals("") || zona.equals("") || responsable.equals("") || fecha.equals("")) { System.out.println("Faltan datos."); return; }
        acciones[cantidad] = new AccionBusqueda(cantidad + 1, codigoCaso, actividad, zona, responsable, fecha);
        cantidad++;
        System.out.println("Accion registrada. Codigo: " + cantidad);
    }
    public AccionBusqueda buscar(int codigo) {
        for (int i = 0; i < cantidad; i++) if (acciones[i].getCodigo() == codigo) return acciones[i];
        return null;
    }
    public void consultar() {
        if (cantidad == 0) System.out.println("No existen acciones.");
        for (int i = 0; i < cantidad; i++) acciones[i].mostrarAccion();
    }
    public void actualizar(Scanner teclado) {
        int codigo = Entrada.numero(teclado, "Codigo de la accion: ");
        AccionBusqueda a = buscar(codigo);
        if (a == null) { System.out.println("No se encontro la accion."); return; }
        System.out.println("1. Pendiente\n2. En proceso\n3. Finalizada");
        int opcion = Entrada.numero(teclado, "Estado: ");
        if (opcion == 1) a.setEstado("Pendiente");
        else if (opcion == 2) a.setEstado("En proceso");
        else if (opcion == 3) a.setEstado("Finalizada");
        else { System.out.println("Opcion incorrecta."); return; }
        String resultado = Entrada.texto(teclado, "Resultado o avance: ");
        if (!resultado.equals("")) a.setResultado(resultado);
        System.out.println("Accion actualizada.");
    }
    public int getCantidad() { return cantidad; }
}
