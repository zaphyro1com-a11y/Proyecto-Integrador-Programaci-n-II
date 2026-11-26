package modelo;

// Responsable de la clase y sus metodos: Sebastian Paredes Pacheco.
// Modulo 3: RF05 registro y RF06 revision de evidencias.
import java.util.Scanner;
public class ModuloEvidencias {
    private GestionEvidencias gestion;
    public ModuloEvidencias(GestionEvidencias gestion) { this.gestion = gestion; }
    public void menu(Scanner teclado, ModuloCasos casos) {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n--- MODULO 3: EVIDENCIAS ---");
            System.out.println("Responsable: Sebastian Paredes Pacheco");
            System.out.println("1. Registrar evidencia");
            System.out.println("2. Consultar evidencias");
            System.out.println("3. Revisar evidencia");
            System.out.println("4. Volver al menu principal");
            opcion = Entrada.numero(teclado, "Opcion: ");
            switch (opcion) {
                case 1: registrar(teclado, casos); break;
                case 2: gestion.mostrarTodas(); break;
                case 3: revisar(teclado); break;
                case 4: break;
                default: System.out.println("Opcion incorrecta.");
            }
        }
    }
    private void registrar(Scanner teclado, ModuloCasos casos) {
        int codigoCaso = Entrada.numero(teclado, "Codigo del caso: ");
        if (casos.buscarCaso(codigoCaso) == null) { System.out.println("El caso no existe."); return; }
        String tipo = Entrada.texto(teclado, "Tipo (fotografia, documento, testimonio, video): ");
        String descripcion = Entrada.texto(teclado, "Descripcion: ");
        String procedencia = Entrada.texto(teclado, "Procedencia: ");
        String fecha = Entrada.texto(teclado, "Fecha (AAAA-MM-DD): ");
        String archivo = Entrada.texto(teclado, "Nombre o ruta del archivo (opcional): ");
        gestion.registrar(codigoCaso, tipo, descripcion, procedencia, fecha, archivo);
    }
    private void revisar(Scanner teclado) {
        int codigo = Entrada.numero(teclado, "Codigo de la evidencia: ");
        if (gestion.buscar(codigo) == null) { System.out.println("No se encontro la evidencia."); return; }
        System.out.println("1. Verificada\n2. Descartada");
        int opcion = Entrada.numero(teclado, "Nuevo estado: ");
        String estado;
        if (opcion == 1) estado = "Verificada";
        else if (opcion == 2) estado = "Descartada";
        else { System.out.println("Opcion incorrecta."); return; }
        String justificacion = Entrada.texto(teclado, "Justificacion: ");
        String revisor = Entrada.texto(teclado, "Nombre del revisor: ");
        String fecha = Entrada.texto(teclado, "Fecha de revision (AAAA-MM-DD): ");
        gestion.revisarConDatos(codigo, estado, justificacion, revisor, fecha);
    }
}
