import java.util.Scanner;

// ======================================================
// MODULO 1: GESTION Y ESTADO DE CASOS
// Responsable: Leonardo Flores Gaona.
// RF01: registrar y consultar casos.
// RF02: actualizar el estado del caso.
// ======================================================
public class ModuloCasos {
    private Caso[] casos;
    private int cantidad;
    private int siguienteCodigo;

    // Constructor del módulo.
    public ModuloCasos() {
        casos = new Caso[100];
        cantidad = 0;
        siguienteCodigo = 1;
    }

    public void menu(Scanner teclado) {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n--- MODULO 1: CASOS ---");
            System.out.println("Responsable: Leonardo Flores Gaona");
            System.out.println("1. Registrar caso");
            System.out.println("2. Consultar casos");
            System.out.println("3. Actualizar estado");
            System.out.println("4. Volver al menu principal");
            System.out.print("Opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1: registrarCaso(teclado); break;
                case 2: consultarCasos(); break;
                case 3: actualizarEstado(teclado); break;
                case 4: break;
                default: System.out.println("Opcion incorrecta.");
            }
        }
    }

    // RF01: solicita los datos y crea un objeto Caso.
    private void registrarCaso(Scanner teclado) {
        if (cantidad == casos.length) {
            System.out.println("No hay espacio para mas casos.");
            return;
        }

        System.out.print("Nombre de la persona: ");
        String nombre = teclado.nextLine();
        System.out.print("Edad: ");
        int edad = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Caracteristicas fisicas: ");
        String caracteristicas = teclado.nextLine();
        System.out.print("Fecha de desaparicion (AAAA-MM-DD): ");
        String fecha = teclado.nextLine();
        System.out.print("Ultimo lugar conocido: ");
        String lugar = teclado.nextLine();
        System.out.print("Contacto familiar: ");
        String contacto = teclado.nextLine();
        System.out.print("Provincia: ");
        String provincia = teclado.nextLine();

        // Validaciones básicas solicitadas en el documento.
        if (nombre.equals("") || edad < 0 || fecha.equals("") ||
                lugar.equals("") || provincia.equals("")) {
            System.out.println("Datos incorrectos. Revise los campos.");
            return;
        }

        casos[cantidad] = new Caso(siguienteCodigo, nombre, edad,
                caracteristicas, fecha, lugar, contacto, provincia);
        System.out.println("Caso registrado con codigo: " + siguienteCodigo);
        cantidad++;
        siguienteCodigo++;
    }

    // RF01: presenta todos los casos registrados.
    public void consultarCasos() {
        if (cantidad == 0) {
            System.out.println("Todavia no existen casos registrados.");
        } else {
            for (int i = 0; i < cantidad; i++) {
                casos[i].mostrarCaso();
            }
        }
    }

    // Busca un caso usando su código.
    public Caso buscarCaso(int codigo) {
        for (int i = 0; i < cantidad; i++) {
            if (casos[i].getCodigo() == codigo) {
                return casos[i];
            }
        }
        return null;
    }

    // RF02: cambia el estado del caso y conserva el motivo en pantalla.
    private void actualizarEstado(Scanner teclado) {
        System.out.print("Codigo del caso: ");
        int codigo = teclado.nextInt();
        teclado.nextLine();

        Caso caso = buscarCaso(codigo);
        if (caso == null) {
            System.out.println("No se encontro el caso.");
            return;
        }

        System.out.println("1. Abierto");
        System.out.println("2. En seguimiento");
        System.out.println("3. Cerrado");
        System.out.print("Nuevo estado: ");
        int opcion = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Motivo del cambio: ");
        String motivo = teclado.nextLine();

        if (opcion == 1) caso.setEstado("Abierto");
        else if (opcion == 2) caso.setEstado("En seguimiento");
        else if (opcion == 3) {
            System.out.print("¿El respaldo fue revisado por personal autorizado? (si/no): ");
            String respaldo = teclado.nextLine();
            if (!respaldo.equalsIgnoreCase("si")) {
                System.out.println("No se puede cerrar el caso sin respaldo revisado.");
                return;
            }
            caso.setEstado("Cerrado");
        } else {
            System.out.println("Estado incorrecto.");
            return;
        }

        System.out.println("Estado actualizado. Motivo registrado: " + motivo);
    }

    // Permite que el módulo de estadísticas consulte cada caso por posición.
    public Caso obtenerCaso(int posicion) {
        if (posicion >= 0 && posicion < cantidad) {
            return casos[posicion];
        }
        return null;
    }

    public int getCantidad() {
        return cantidad;
    }
}
