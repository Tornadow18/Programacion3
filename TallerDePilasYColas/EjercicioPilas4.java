import java.util.Scanner;
import java.util.Stack;

public class EjercicioPilas4 {
      public static void main(String[] args) 
      {
        Scanner scanner = new Scanner(System.in);

        double[] secuencia = new double[10];

        System.out.println("Ingrese 10 numeros reales:");
        for (int i = 0; i < secuencia.length; i++) 
        {
            System.out.print("Numero " + (i + 1) + ": ");
            secuencia[i] = scanner.nextDouble();
        }

        Stack<Double> pila = new Stack<>();

        // Poner los elementos en la pila
        for (double numero : secuencia) 
        {
            pila.push(numero);
        }

        System.out.println("\nSecuencia original:");
        for (double numero : secuencia) 
        {
            System.out.print(numero+ "," + " ");
        }

        System.out.println("\n\nPila:");
        while (!pila.isEmpty()) 
        {
            System.out.println(pila.pop());
        }

        scanner.close();
    }
}
