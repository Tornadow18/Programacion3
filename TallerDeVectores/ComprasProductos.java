import java.util.Scanner;
public class ComprasProductos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de productos: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        double[] preciosUnitarios = new double[n];
        int[] cantidadesCompradas = new int[n];
        String[] descripciones = new String[n];
        double[] totalesGastados = new double[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese la descripción del producto " + (i + 1) + ": ");
            descripciones[i] = scanner.nextLine();
            System.out.println("Ingrese el precio unitario del producto " + (i + 1) + ": ");
            preciosUnitarios[i] = scanner.nextDouble();
            System.out.println("Ingrese la cantidad comprada del producto " + (i + 1) + ": ");
            cantidadesCompradas[i] = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
        }

        for (int i = 0; i < n; i++) {
            totalesGastados[i] = preciosUnitarios[i] * cantidadesCompradas[i];
        }

        // Calcular el total general de todas las compras
        double totalGeneral = 0;
        for (double total : totalesGastados) {
            totalGeneral += total;
        }

        int indiceMayorGasto = 0;
        for (int i = 1; i < n; i++) {
            if (totalesGastados[i] > totalesGastados[indiceMayorGasto]) {
                indiceMayorGasto = i;
            }
        }

        System.out.println("Total gastado por producto:");
        for (int i = 0; i < n; i++) {
            System.out.println(descripciones[i] + ": " + totalesGastados[i]);
        }
        System.out.println("Total general de todas las compras: " + totalGeneral);
        System.out.println("Producto con mayor gasto: " + descripciones[indiceMayorGasto] + " (" + totalesGastados[indiceMayorGasto] + ")");

        scanner.close();
    }
}
