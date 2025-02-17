import java.util.Scanner;

public class GananciasVivienda {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la cantidad de viviendas
        System.out.println("Ingrese la cantidad de viviendas: ");
        int n = scanner.nextInt();

        // Crear los arreglos
        double[] alquileres = new double[n];
        double[] porcentajesGanancia = new double[n];
        double[] ganancias = new double[n];

        // Leer los datos de las viviendas
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese el alquiler de la vivienda " + (i + 1) + ": ");
            alquileres[i] = scanner.nextDouble();
            System.out.println("Ingrese el porcentaje de ganancia de la vivienda " + (i + 1) + ": ");
            porcentajesGanancia[i] = scanner.nextDouble();
        }

        // Calcular las ganancias por vivienda
        for (int i = 0; i < n; i++) {
            ganancias[i] = alquileres[i] * (porcentajesGanancia[i] / 100);
        }

        // Mostrar los resultados
        System.out.println("Ganancias por vivienda:");
        for (int i = 0; i < n; i++) {
            System.out.println("Vivienda " + (i + 1) + ": " + ganancias[i]);
        }

        scanner.close();
    }
}
