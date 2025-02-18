import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NegativosCerosPositivos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de elementos del arreglo:");
        int n = scanner.nextInt();
        int[] arregloA = new int[n];
        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            arregloA[i] = scanner.nextInt();
        }

        // Usamos ArrayList para almacenar los números separados
        ArrayList<Integer> negativos = new ArrayList<>();
        ArrayList<Integer> ceros = new ArrayList<>();
        ArrayList<Integer> positivos = new ArrayList<>();

        // Clasificamos los números en el arreglo original
        for (int elemento : arregloA) {
            if (elemento < 0) {
                negativos.add(elemento);
            } else if (elemento == 0) {
                ceros.add(elemento);
            } else {
                positivos.add(elemento);
            }
        }

        int[] arregloNegativos = negativos.stream().mapToInt(i -> i).toArray();
        int[] arregloCeros = ceros.stream().mapToInt(i -> i).toArray();
        int[] arregloPositivos = positivos.stream().mapToInt(i -> i).toArray();

        System.out.println("Arreglo de números negativos: " + Arrays.toString(arregloNegativos));
        System.out.println("Arreglo de números ceros: " + Arrays.toString(arregloCeros));
        System.out.println("Arreglo de números positivos: " + Arrays.toString(arregloPositivos));

        scanner.close();
    }
}