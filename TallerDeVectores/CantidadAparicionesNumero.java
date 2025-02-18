import java.util.Random;
import java.util.Scanner;

public class CantidadAparicionesNumero {

    public static void main(String[] args) {
        int[] arreglo = new int[20];
        Random random = new Random();
        System.out.println("Arreglo generado: ");

        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] =random.nextInt(100);
            System.out.print(arreglo[i] + " ");

        }
        System.out.println();

         Scanner scanner = new Scanner(System.in);
         System.out.print("Ingrese el numero que quiere buscar: ");
         int numeroBuscado = scanner.nextInt();
         int contador = 0;
        for (int numero : arreglo) {
            if (numero == numeroBuscado) {
                contador++;
            }
        
        }
        if (contador > 0) {
            System.out.println("El número " + numeroBuscado + " aparece " + contador + " veces en el arreglo.");
        } else {
            System.out.println("El número " + numeroBuscado + " no se encuentra en el arreglo.");
        }
    }

}