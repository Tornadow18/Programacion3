import java.util.Scanner;
public class SumaArreglo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de numeros (del vector):");
        int n = scanner.nextInt();
        int[] numeros = new int[n];
        System.out.println("Ingrese los "+ n +" numeros");
        for (int i = 0; i < n; i++) {
            numeros[i] = scanner.nextInt();
        }
        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma +=numeros[i];
        }
        System.out.println("La suma de los "+ n +"numeros es: "+suma);
        
        scanner.close();

    }
}