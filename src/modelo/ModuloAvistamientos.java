package modelo;

// Responsable de la clase y sus metodos: Gabriel Rivera.
// Modulo 2: registro, consulta y revision de avistamientos.
import java.util.Scanner;
public class ModuloAvistamientos {
    private Avistamiento[] avistamientos = new Avistamiento[100];
    private int cantidad = 0;
    public void menu(Scanner teclado, ModuloCasos casos) {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n--- MODULO 2: AVISTAMIENTOS ---");
            System.out.println("Responsable: Gabriel Rivera");
            System.out.println("1. Registrar avistamiento");
            System.out.println("2. Consultar avistamientos");
            System.out.println("3. Revisar avistamiento");
            System.out.println("4. Volver al menu principal");
            opcion = Entrada.numero(teclado, "Opcion: ");
            switch (opcion) {
                case 1: registrar(teclado, casos); break;
                case 2: consultar(); break;
                case 3: revisar(teclado); break;
                case 4: break;
                default: System.out.println("Opcion incorrecta.");
            }
        }
    }
    public void registrar(Scanner teclado, ModuloCasos casos) {
        if (cantidad >= avistamientos.length) { System.out.println("Sin espacio."); return; }
        int codigoCaso = Entrada.numero(teclado, "Codigo del caso: ");
        if (casos.buscarCaso(codigoCaso) == null) { System.out.println("El caso no existe."); return; }
        String descripcion = Entrada.texto(teclado, "Descripcion: ");
        String lugar = Entrada.texto(teclado, "Lugar: ");
        String fecha = Entrada.texto(teclado, "Fecha (AAAA-MM-DD): ");
        String hora = Entrada.texto(teclado, "Hora: ");
        String contacto = Entrada.texto(teclado, "Contacto: ");
        if (descripcion.equals("") || lugar.equals("") || fecha.equals("")) { System.out.println("Faltan datos obligatorios."); return; }
        avistamientos[cantidad] = new Avistamiento(cantidad + 1, codigoCaso, descripcion, lugar, fecha, hora, contacto);
        cantidad++;
        System.out.println("Avistamiento registrado. Codigo: " + cantidad);
    }
    public Avistamiento buscar(int codigo) {
        for (int i = 0; i < cantidad; i++) if (avistamientos[i].getCodigo() == codigo) return avistamientos[i];
        return null;
    }
    public void consultar() {
        if (cantidad == 0) System.out.println("No existen avistamientos.");
        for (int i = 0; i < cantidad; i++) avistamientos[i].mostrarAvistamiento();
    }
    public void revisar(Scanner teclado) {
        int codigo = Entrada.numero(teclado, "Codigo del avistamiento: ");
        Avistamiento a = buscar(codigo);
        if (a == null) { System.out.println("No se encontro el avistamiento."); return; }
        System.out.println("1. Pendiente\n2. Verificado\n3. Descartado");
        int opcion = Entrada.numero(teclado, "Estado: ");
        if (opcion == 1) a.setEstado("Pendiente");
        else if (opcion == 2) a.setEstado("Verificado");
        else if (opcion == 3) a.setEstado("Descartado");
        else { System.out.println("Opcion incorrecta."); return; }
        System.out.println("Avistamiento actualizado.");
    }
    public int getCantidad() { return cantidad; }
    public Avistamiento obtener(int posicion) {
        if (posicion >= 0 && posicion < cantidad) return avistamientos[posicion];
        return null;
    }
}
