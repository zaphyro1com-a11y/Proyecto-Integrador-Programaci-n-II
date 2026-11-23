package modelo;

// Responsable de la clase y sus metodos: Rut Cuvi.
// Modulo 5: estadisticas y reportes basicos.
import java.util.Scanner;

public class ModuloEstadisticas {

    public void menu(Scanner teclado, ModuloCasos casos, ModuloAvistamientos avistamientos,
                     GestionEvidencias evidencias, ModuloAcciones acciones) {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n--- MODULO 5: ESTADISTICAS ---");
            System.out.println("Responsable: Rut Cuvi");
            System.out.println("1. Resumen general");
            System.out.println("2. Casos por estado");
            System.out.println("3. Evidencias por estado");
            System.out.println("4. Volver al menu principal");
            opcion = Entrada.numero(teclado, "Opcion: ");
            switch (opcion) {
                case 1:
                    System.out.println("Casos: " + casos.getCantidad());
                    System.out.println("Avistamientos: " + avistamientos.getCantidad());
                    System.out.println("Evidencias: " + evidencias.getCantidad());
                    System.out.println("Acciones de busqueda: " + acciones.getCantidad());
                    break;
                case 2:
                    int abiertos = 0, seguimiento = 0, cerrados = 0;
                    for (int i = 0; i < casos.getCantidad(); i++) {
                        String estado = casos.obtenerCaso(i).getEstado();
                        if (estado.equals("Abierto")) abiertos++;
                        else if (estado.equals("En seguimiento")) seguimiento++;
                        else if (estado.equals("Cerrado")) cerrados++;
                    }
                    System.out.println("Abiertos: " + abiertos + " | En seguimiento: " + seguimiento + " | Cerrados: " + cerrados);
                    break;
                case 3:
                    int pendientes = 0, verificadas = 0, descartadas = 0;
                    for (int i = 0; i < evidencias.getCantidad(); i++) {
                        String estado = evidencias.obtenerEvidencia(i).getEstado();
                        if (estado.equals("Pendiente")) pendientes++;
                        else if (estado.equals("Verificada")) verificadas++;
                        else if (estado.equals("Descartada")) descartadas++;
                    }
                    System.out.println("Pendientes: " + pendientes + " | Verificadas: " + verificadas + " | Descartadas: " + descartadas);
                    break;
                case 4: break;
                default: System.out.println("Opcion incorrecta.");
            }
        }
    }
}
