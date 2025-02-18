import java.util.Random;

public class NumeroRepetido {
    public static void main(String[] args) {
        int[] numeros = new int[30];
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            numeros[i] = random.nextInt(100) + 1;
        }
        int mayor = numeros[0];
        int menor = numeros[0];
        for(int numero : numeros) {
          if (numero > mayor) {
            mayor = numero;
          }
          if (numero < menor) {
            menor = numero;
          }
        }
        int mayorRepetido = 0;
        int menorRepetido = 0;
        for(int numero : numeros) {
            if (numero == mayor) {
                mayorRepetido++;
            }
            if (numero == menor) {
                menorRepetido++;
                
            }
        }
        System.out.println("Numeros generados: ");
       for(int numero : numeros) {
        System.out.println(numero + " ");
       }
       System.out.println();

       System.out.println("Numero mayor: "+ mayor );
       System.out.println("Se repite: "+ mayorRepetido + "veces" );
       System.out.println("numero menor: "+ menor );
       System.out.println("numero mayor: "+ menorRepetido + "veces");
        }
    }


