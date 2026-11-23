
// AUTOR: SEBASTIAN PAREDES PACHECO
// MODULO 3: ORGANIZACION Y REVISION DE EVIDENCIAS
//  REGISTRAR EVIDENCIAS
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


            if (codigoCaso > 0 && !tipo.equals("") &&
                    !descripcion.equals("") &&
                    !procedencia.equals("") &&
                    !fecha.equals("")) {


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
        }

        for (int i = 0; i < cantidad; i++) {

            evidencias[i].mostrarEvidencia();
        }
    }


    public void revisar(int codigo, String estado,
                        String observacion) {


        Evidencia encontrada = buscar(codigo);


        if (encontrada != null) {


            if (estado.equals("Verificada") ||
                    estado.equals("Descartada")) {


                if (!observacion.equals("")) {


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
}
