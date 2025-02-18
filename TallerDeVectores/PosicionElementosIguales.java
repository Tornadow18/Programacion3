import java.util.ArrayList;
import java.util.Scanner;


public class PosicionElementosIguales {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de elementos del arreglo:");
        int n = scanner.nextInt();
        int[] arreglo = new int[n];
        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            arreglo[i] = scanner.nextInt();
        }

        System.out.println("Ingrese el valor x:");
        int x = scanner.nextInt();


        ArrayList<Integer> posiciones = new ArrayList<>();
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == x) {
                posiciones.add(i);
            }
        }

        int[] arregloResultante = new int[posiciones.size()];
        for (int i = 0; i < posiciones.size(); i++) {
            arregloResultante[i] = posiciones.get(i);
        }

        System.out.println("Arreglo resultante (B):");
        for (int posicion : arregloResultante) {
            System.out.print(posicion + " ");
        }
        System.out.println();

        scanner.close();
    }
}

