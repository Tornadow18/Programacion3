import java.util.Scanner;

public class MayorValor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de personas: ");
        int n = scanner.nextInt();

        int[] edades1 = new int[n];
        int[] edades2 = new int[n];

        System.out.println("Ingrese las edades del primer grupo:");
        for (int i = 0; i < n; i++) {
            edades1[i] = scanner.nextInt();
        }
        System.out.println("Ingrese las edades del segundo grupo:");
        for (int i = 0; i < n; i++) {
            edades2[i] = scanner.nextInt();
        }

        int mayorValor = 0;
        for (int edad : edades1) {
            if (edad > mayorValor) {
                mayorValor = edad;
            }
        }
        for (int edad : edades2) {
            if (edad > mayorValor) {
                mayorValor = edad;
            }
        }

        System.out.println("El mayor valor encontrado en ambos arreglos es: " + mayorValor);

        scanner.close();
    }
}
