import java.util.ArrayList;
import java.util.Scanner;


public class MayoresMenoresMedia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de elementos del arreglo:");
        int n = scanner.nextInt();
        int[] arregloA = new int[n];
        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            arregloA[i] = scanner.nextInt();
        }

        double media = calcularMedia(arregloA);

        ArrayList<Integer> mayores = new ArrayList<>();
        ArrayList<Integer> menores = new ArrayList<>();

        for (int elemento : arregloA) {
            if (elemento > media) {
                mayores.add(elemento);
            } else if (elemento < media) {
                menores.add(elemento);
            }
        }

        int[] arregloMayores = new int[mayores.size()];
        int[] arregloMenores = new int[menores.size()];

        for (int i = 0; i < mayores.size(); i++) {
            arregloMayores[i] = mayores.get(i);
        }
        for (int i = 0; i < menores.size(); i++) {
            arregloMenores[i] = menores.get(i);
        }
        System.out.println("Arreglo de números mayores que la media:");
        imprimirArreglo(arregloMayores);
        System.out.println("Arreglo de números menores que la media:");
        imprimirArreglo(arregloMenores);

        scanner.close();
    }

    static double calcularMedia(int[] arreglo) {
        double suma = 0;
        for (int elemento : arreglo) {
            suma += elemento;
        }
        return suma / arreglo.length;
    }

    static void imprimirArreglo(int[] arreglo) {
        if (arreglo.length == 0) {
            System.out.println("El arreglo está vacío.");
        } else {
            for (int elemento : arreglo) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }

}
