package modelo;

// Responsable: integracion grupal.
// Metodos de lectura compartidos por los cinco modulos.
import java.util.Scanner;
public class Entrada {
    public static int numero(Scanner teclado, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = teclado.nextLine();
            try { return Integer.parseInt(texto.trim()); }
            catch (NumberFormatException e) { System.out.println("Ingrese un numero valido."); }
        }
    }
    public static String texto(Scanner teclado, String mensaje) {
        System.out.print(mensaje);
        return teclado.nextLine().trim();
    }
}
