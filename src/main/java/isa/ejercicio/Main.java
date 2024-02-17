package isa.ejercicio;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Definir la matriz de ventas (5 filas x 12 columnas)
        int[][] ventas = new int[5][12];

        // Generar valores aleatorios para las ventas
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                ventas[i][j] = new Random().nextInt(10000) + 1; // Ventas entre 1 y 10000
            }
        }

        // Imprimir la matriz por filas usando forEach
        System.out.println("Matriz de ventas:");
        Arrays.stream(ventas).forEach(fila -> {
            Arrays.stream(fila).forEach(venta -> System.out.printf("%8d ", venta));
            System.out.println();
        });

        // Ordenar los elementos de una matriz por columna
        for (int i = 0; i < ventas[0].length; i++) {
            // Convertir la columna a un array
            int finalI = i;
            int[] columna = Arrays.stream(ventas).mapToInt(fila -> fila[finalI]).toArray();

            // Ordenar la columna
            Arrays.sort(columna);

            // Escribir la columna ordenada en la matriz
            for (int j = 0; j < ventas.length; j++) {
                ventas[j][i] = columna[j];
            }
        }

        // Imprimir la matriz ordenada
        System.out.println("Matriz ordenada por columna:");
        Arrays.stream(ventas).forEach(fila -> {
            Arrays.stream(fila).forEach(venta -> System.out.printf("%8d ", venta));
            System.out.println();
        });

        // Filtrar elementos de una matriz por un criterio
        System.out.println("Ventas mayores a 5000:");
        Arrays.stream(ventas)
                .flatMapToInt(fila -> Arrays.stream(fila))
                .filter(venta -> venta > 5000)
                .forEach(venta -> System.out.printf("%8d ", venta));
        System.out.println();
    }
}
