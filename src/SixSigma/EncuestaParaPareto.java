package SixSigma;
import java.util.Random;

public class EncuestaParaPareto {
    public static void main(String[] args) {
        // Número de preguntas y encuestados
        int numPreguntas = 8;
        int numEncuestados = 10;

        // Generador de números aleatorios
        Random rand = new Random();

        // Matriz para almacenar la frecuencia de respuestas por pregunta (de 0 a 5)
        int[][] frecuenciaRespuestasPorPregunta = new int[numPreguntas][6]; // índices de 0 a 5

        // Total de respuestas generadas
        int totalRespuestasGeneradas = 0;

        // Generar respuestas aleatorias y contar la frecuencia
        for (int i = 0; i < numEncuestados; i++) {
            // Generar un número aleatorio de requerimientos para el cliente
            int numRequerimientos = rand.nextInt(30) + 1; // Generar número aleatorio entre 1 y 10

            // Contador de respuestas distintas de 0 para el cliente actual
            int totalRespuestasDistintasDeCeroCliente = 0;

            for (int req = 0; req < numRequerimientos; req++) {
                for (int j = 0; j < numPreguntas; j++) {
                    int respuesta = rand.nextInt(6); // Generar número aleatorio entre 0 y 5
                    frecuenciaRespuestasPorPregunta[j][respuesta]++; // Incrementar la frecuencia de esa respuesta
                    if (respuesta != 0) {
                        totalRespuestasDistintasDeCeroCliente++;
                    }
                }
            }

            // Mostrar información del cliente
            System.out.println("Cliente " + (i + 1) + ":");
            System.out.println("  Cantidad de Requerimientos: " + numRequerimientos);
            System.out.println("  Cantidad de Respuestas Distintas de 0: " + totalRespuestasDistintasDeCeroCliente);

            // Sumar respuestas generadas por este cliente al total
            totalRespuestasGeneradas += numRequerimientos * numPreguntas;

            // Mostrar la frecuencia de respuestas por pregunta para el cliente actual
            for (int j = 0; j < numPreguntas; j++) {
                System.out.println("  Pregunta " + (j + 1) + ":");
                int totalRespuestasDistintasDeCero = 0;
                for (int respuesta = 1; respuesta < 6; respuesta++) { // Empezamos desde 1 para excluir la respuesta 0
                    totalRespuestasDistintasDeCero += frecuenciaRespuestasPorPregunta[j][respuesta];
                    System.out.println("    Respuesta " + respuesta + ": " + frecuenciaRespuestasPorPregunta[j][respuesta]);
                }
                System.out.println("    Total Respuestas Distintas de 0: " + totalRespuestasDistintasDeCero);
            }

            System.out.println(); // Separador entre clientes
        }

        // Totalizador de frecuencia de respuestas distintas de 0 por pregunta
        System.out.println("Totalizador de Frecuencia de Respuestas Distintas de 0 por Pregunta:");
        for (int j = 0; j < numPreguntas; j++) {
            int totalRespuestasDistintasDeCero = 0;
            for (int respuesta = 1; respuesta < 6; respuesta++) { // Empezamos desde 1 para excluir la respuesta 0
                totalRespuestasDistintasDeCero += frecuenciaRespuestasPorPregunta[j][respuesta];
            }
            System.out.println("  Pregunta " + (j + 1) + ": " + totalRespuestasDistintasDeCero + " errores");
        }

        // Mostrar el total de respuestas generadas
        System.out.println("\nTotal de Respuestas Generadas: " + totalRespuestasGeneradas);
    }
}
