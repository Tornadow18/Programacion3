import java.util.ArrayList;
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

        ArrayList<Integer> negativos = new ArrayList<>();
        ArrayList<Integer> ceros = new ArrayList<>();
        ArrayList<Integer> positivos = new ArrayList<>();

        for (int elemento : arregloA) {
            if (elemento < 0) {
                negativos.add(elemento);
            } else if (elemento == 0) {
                ceros.add(elemento);
            } else {
                positivos.add(elemento);
            }
        }

        int[] arregloNegativos = new int[negativos.size()];
        int[] arregloCeros = new int[ceros.size()];
        int[] arregloPositivos = new int[positivos.size()];

        for (int i = 0; i < negativos.size(); i++) {
            arregloNegativos[i] = negativos.get(i);
        }
        for (int i = 0; i < ceros.size(); i++) {
            arregloCeros[i] = ceros.get(i);
        }
        for (int i = 0; i < positivos.size(); i++) {
            arregloPositivos[i] = positivos.get(i);
        }

        System.out.println("Arreglo de números negativos:");
        imprimirArreglo(arregloNegativos);
        System.out.println("Arreglo de números ceros:");
        imprimirArreglo(arregloCeros);
        System.out.println("Arreglo de números positivos:");
        imprimirArreglo(arregloPositivos);

        scanner.close();
    }
}
