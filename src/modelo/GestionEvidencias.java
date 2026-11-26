
package modelo;

// AUTOR: SEBASTIAN PAREDES PACHECO
// MODULO 3: ORGANIZACION Y REVISION DE EVIDENCIAS
// REGISTRAR EVIDENCIAS
// REVISAR EVIDENCIAS

public class GestionEvidencias {

    private Evidencia[] evidencias;
    private int cantidad;

    public GestionEvidencias() {
        evidencias = new Evidencia[20];
        cantidad = 0;
    }

    public void registrar(int codigoCaso, String tipo,
                          String descripcion, String procedencia,
                          String fecha, String archivo) {

        if (cantidad < 20) {

            if (codigoCaso > 0 && tipo != null && !tipo.equals("") &&
                    descripcion != null && !descripcion.equals("") &&
                    procedencia != null && !procedencia.equals("") &&
                    fecha != null && !fecha.equals("")) {

                Evidencia nueva = new Evidencia(
                        cantidad + 1,
                        codigoCaso,
                        tipo,
                        descripcion,
                        procedencia,
                        fecha,
                        archivo
                );

                evidencias[cantidad] = nueva;
                cantidad++;

                System.out.println("Evidencia registrada correctamente.");

            } else {
                System.out.println("Faltan datos de la evidencia.");
            }

        } else {
            System.out.println("No hay espacio para mas evidencias.");
        }
    }

    public Evidencia buscar(int codigo) {

        for (int i = 0; i < cantidad; i++) {

            if (evidencias[i].getCodigo() == codigo) {
                return evidencias[i];
            }
        }

        return null;
    }

    public void mostrarTodas() {

        if (cantidad == 0) {
            System.out.println("No hay evidencias registradas.");
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            evidencias[i].mostrarEvidencia();
        }
    }

    public void revisar(int codigo, String estado,
                        String observacion) {

        Evidencia encontrada = buscar(codigo);

        if (encontrada != null) {

            if (estado != null &&
                    (estado.equals("Verificada") ||
                            estado.equals("Descartada"))) {

                if (observacion != null && !observacion.equals("")) {

                    encontrada.setEstado(estado);
                    encontrada.setObservacion(observacion);

                    System.out.println("Evidencia revisada correctamente.");

                } else {
                    System.out.println("Debes escribir una observacion.");
                }

            } else {
                System.out.println("Estado incorrecto.");
            }

        } else {
            System.out.println("No se encontro la evidencia.");
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void revisarConDatos(int codigo, String estado,
                                String justificacion, String revisor,
                                String fecha) {

        Evidencia encontrada = buscar(codigo);

        if (encontrada != null) {

            if (estado != null &&
                    (estado.equals("Verificada") ||
                            estado.equals("Descartada"))) {

                if (justificacion != null && !justificacion.equals("") &&
                        revisor != null && !revisor.equals("") &&
                        fecha != null && !fecha.equals("")) {

                    encontrada.setEstado(estado);

                    encontrada.setObservacion(
                            justificacion + " | Revisor: " +
                                    revisor + " | Fecha: " + fecha
                    );

                    System.out.println("Evidencia revisada correctamente.");

                } else {
                    System.out.println("Faltan datos para la revision.");
                }

            } else {
                System.out.println("Estado incorrecto.");
            }

        } else {
            System.out.println("No se encontro la evidencia.");
        }
    }

    public Evidencia obtenerEvidencia(int i) {

        if (i >= 0 && i < cantidad) {
            return evidencias[i];
        }

        return null;
    }
}
