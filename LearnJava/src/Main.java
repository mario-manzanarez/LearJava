public class Main {
    private static final int totalAlumnos = 15;
    private static final int totalMaterias = 5;
    private static final double[] promedioAlumnos = new double[totalAlumnos];
    private static final String[] nombreAlumnos = {"Mario", "Luis", "Andrés", "Carlos", "Javier",
            "Fernando", "Ricardo", "Santiago", "Daniel", "Roberto",
            "Alejandra", "Mariana", "Sofía", "Valeria", "Gabriela"};
    private static final double[] promedioMaterias = new double[totalMaterias];
    private static final String[] nombresMaterias = {"Álgebra", "Historia", "Informática", "Español", "Geografía"};
    private static final double[] calificacionesAlgebra = new double[totalAlumnos];
    private static final double[] calificacionesHistoria = new double[totalAlumnos];
    private static final double[] calificacionesInformatica = new double[totalAlumnos];
    private static final double[] calificacionesEspanol = new double[totalAlumnos];
    private static final double[] calificacionesGeografia = new double[totalAlumnos];

    /**
     * Método principal
     *
     * @param args args
     * @author Mario Manzanarez
     * @since 07/02/2025
     */
    public static void main(String[] args) {
        inicializarMaterias();
        System.out.println("====================== ALUMNOS ======================");
        orquestadorCalificacionesAlumnos();
        System.out.println("====================== MATERIAS ======================");
        orquestadorCalificacionesMaterias();
        System.out.println("====================== GENERAL ======================");
        orquestadorPromedioGeneral();

    }

    /**
     * Orquesta tdo lo relacionado a los promedios de los alumnos
     *
     * @author Mario Manzanarez
     * @since 07/02/2025
     */
    private static void orquestadorCalificacionesAlumnos() {
        for (int i = 0; i < totalAlumnos; i++) {
            double[] calificacionesTemporal = {
                    calificacionesAlgebra[i],
                    calificacionesHistoria[i],
                    calificacionesInformatica[i],
                    calificacionesEspanol[i],
                    calificacionesGeografia[i]
            };
            double promedioTemp = calcularPromedio(totalMaterias, calificacionesTemporal);
            promedioAlumnos[i] = promedioTemp;
        }
        for (int i = 0; i < totalAlumnos; i++) {
            String mensaje = "para el alumno " + nombreAlumnos[i] + ": ";
            imprimirValoresConNota(promedioAlumnos[i], mensaje);
        }
    }

    /**
     * Orquesta tdo lo relacionado con los promedios de las materias
     *
     * @author Mario Manzanarez
     * @since 07/02/2025
     */
    private static void orquestadorCalificacionesMaterias() {
        promedioMaterias[0] = calcularPromedio(totalAlumnos, calificacionesAlgebra);
        promedioMaterias[1] = calcularPromedio(totalAlumnos, calificacionesHistoria);
        promedioMaterias[2] = calcularPromedio(totalAlumnos, calificacionesInformatica);
        promedioMaterias[3] = calcularPromedio(totalAlumnos, calificacionesEspanol);
        promedioMaterias[4] = calcularPromedio(totalAlumnos, calificacionesGeografia);

        for (int i = 0; i < totalMaterias; i++) {
            String mensaje = "para la materia " + nombresMaterias[i] + ": ";
            imprimirValoresConNota(promedioMaterias[i], mensaje);
        }
    }

    /**
     * Orquesta lo relacionado con el promedio general del grupo
     *
     * @author Mario Manzanarez
     * @since 07/02/2025
     */
    private static void orquestadorPromedioGeneral() {
        double promedioGeneral = calcularPromedio(totalAlumnos, promedioAlumnos);
        String mensaje = "para el grupo : ";
        imprimirValoresConNota(promedioGeneral, mensaje);
    }

    /**
     * Calcula el promedio a partir de un vector obtenido
     *
     * @param tamano         tamaño del vector
     * @param calificaciones vector con las calificaciones
     * @return promedio de ese vector
     * @author Mario Manzanarez
     * @since 07/02/2025
     */
    private static double calcularPromedio(int tamano, double[] calificaciones) {
        double acumulador = 0.0;
        double promedio;
        for (int i = 0; i < tamano; i++)
            acumulador = acumulador + calificaciones[i];
        promedio = (acumulador / tamano);
        return promedio;
    }

    /**
     * Llena un vector con números aleatorios entre 50 y 100
     *
     * @param vectorCalificaciones vector a ser llenado
     * @author Mario Manzanarez
     * @since 07/02/2025
     */
    private static void generarCalificacionAleatoria(double[] vectorCalificaciones) {
        for (int i = 0; i < totalAlumnos; i++)
            vectorCalificaciones[i] = (Math.random() * 51) + 50;
    }

    /**
     * Imprime un valor con un mensaje otorgado y le concatena un mensaje generado de acuerdo a la nota obtenida
     *
     * @param calificacion calificación promedio
     * @param mensaje 
     * @author Mario Manzanarez
     * @since 07/02/2025
     */
    private static void imprimirValoresConNota(double calificacion, String mensaje) {
        String nota;
        if (calificacion == 100) {
            nota = "EXCELENTE";
        } else if (calificacion >= 91) {
            nota = "SOBRESALIENTE";
        } else if (calificacion >= 81) {
            nota = "BUENO";
        } else if (calificacion >= 70) {
            nota = "REGULAR";
        } else {
            nota = "REPROBADO";
        }
        System.out.println("Calificacion " + mensaje + " " + calificacion + " " + nota);
    }

    private static void inicializarMaterias() {
        generarCalificacionAleatoria(calificacionesAlgebra);
        generarCalificacionAleatoria(calificacionesHistoria);
        generarCalificacionAleatoria(calificacionesInformatica);
        generarCalificacionAleatoria(calificacionesEspanol);
        generarCalificacionAleatoria(calificacionesGeografia);
    }

}