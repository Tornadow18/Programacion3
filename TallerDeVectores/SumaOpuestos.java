import java.util.Scanner;
public class SumaOpuestos {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de elementos del arreglo:");
        int n = scanner.nextInt();
        int[] arregloA = new int[n];
        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) 
        {
            arregloA[i] = scanner.nextInt();
        }

        if (arregloA.length % 2 != 0) 
        {
            System.out.println("El arreglo debe tener un número par de elementos para calcular la suma de opuestos.");
            return;
        }

        int[] arregloB = new int[arregloA.length / 2];

        for (int i = 0; i < arregloA.length / 2; i++) 
        {
            arregloB[i] = arregloA[i] + arregloA[arregloA.length - 1 - i];
        }

        System.out.println("Arreglo resultante (B):");
        imprimirArreglo(arregloB);

        scanner.close();
    }

    static void imprimirArreglo(int[] arreglo) 
    {
        if (arreglo.length == 0) 
        {
            System.out.println("El arreglo está vacío.");
        } else {
            for (int elemento : arreglo) 
            {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }

    }
}