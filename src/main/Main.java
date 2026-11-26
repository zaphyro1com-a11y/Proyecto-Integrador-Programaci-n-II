package main;

import modelo.*;

// Responsable: integracion grupal de los cinco modulos.
// Punto de entrada del Sistema de Gestion de Busqueda de Personas.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ModuloCasos casos = new ModuloCasos();
        ModuloAvistamientos avistamientos = new ModuloAvistamientos();
        GestionEvidencias gestionEvidencias = new GestionEvidencias();
        ModuloEvidencias evidencias = new ModuloEvidencias(gestionEvidencias);
        ModuloAcciones acciones = new ModuloAcciones();
        ModuloEstadisticas estadisticas = new ModuloEstadisticas();
        casos.conectarEvidencias(gestionEvidencias);
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("\n===== SISTEMA DE BUSQUEDA DE PERSONAS =====");
            System.out.println("1. Casos - Leonardo Flores Gaona");
            System.out.println("2. Avistamientos - Gabriel Rivera");
            System.out.println("3. Evidencias - Sebastian Paredes Pacheco");
            System.out.println("4. Acciones de busqueda - Matheo Cañarejo");
            System.out.println("5. Estadisticas - Rut Cuvi");
            System.out.println("6. Salir");
            opcion = Entrada.numero(teclado, "Opcion: ");
            switch (opcion) {
                case 1: casos.menu(teclado); break;
                case 2: avistamientos.menu(teclado, casos); break;
                case 3: evidencias.menu(teclado, casos); break;
                case 4: acciones.menu(teclado, casos); break;
                case 5: estadisticas.menu(teclado, casos, avistamientos, gestionEvidencias, acciones); break;
                case 6: System.out.println("Hasta luego."); break;
                default: System.out.println("Opcion incorrecta.");
            }
        }
        teclado.close();
    }
}
