import java.util.Scanner;

public class GananciasVivienda {
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de viviendas: ");
        int n = scanner.nextInt();

        double[] alquileres = new double[n];
        double[] porcentajesGanancia = new double[n];
        double[] ganancias = new double[n];

        for (int i = 0; i < n; i++) 
        {
            System.out.println("Ingrese el alquiler de la vivienda " + (i + 1) + ": ");
            alquileres[i] = scanner.nextDouble();
            System.out.println("Ingrese el porcentaje de ganancia de la vivienda " + (i + 1) + ": ");
            porcentajesGanancia[i] = scanner.nextDouble();
        }

        for (int i = 0; i < n; i++) {
            ganancias[i] = alquileres[i] * (porcentajesGanancia[i] / 100);
        }

        System.out.println("Ganancias por vivienda:");
        for (int i = 0; i < n; i++) {
            System.out.println("Vivienda " + (i + 1) + ": " + ganancias[i]);
        }

        scanner.close();
    }
}
