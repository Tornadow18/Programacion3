import java.util.Scanner;

public class SumaParesImpares 
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Leer la cantidad de números
        System.out.println("Ingrese la cantidad de numeros: ");
        int n = scanner.nextInt();

        // Crear el array
        int[] numeros = new int[n];

        // Leer los números
        System.out.println("Ingrese los numeros: ");
        for (int i = 0; i < n; i++) 
        {
            numeros[i] = scanner.nextInt();
        }

        // Calcular la suma de pares e impares
        int sumaPares = 0;
        int sumaImpares = 0;
        for (int numero : numeros) 
        {
            if (numero % 2 == 0) 
            {
                sumaPares += numero;
            } else 
            {
                sumaImpares += numero;
            }
        }

        // Mostrar los resultados
        System.out.println("La suma de los números pares es: " + sumaPares);
        System.out.println("La suma de los números impares es: " + sumaImpares);

        scanner.close();
    }
}
