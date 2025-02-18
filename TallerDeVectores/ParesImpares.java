public class ParesImpares {
    public static void main(String[] args) {
        int[] arregloA = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int cantidadPares = 0;
        int cantidadImpares = 0;
        for (int numero : arregloA) {
            if (numero % 2 == 0) {
                cantidadPares++;
            } else {
               cantidadImpares++; 
            }
        }
        int[] pares = new int[cantidadPares];
        int[] impares = new int[cantidadImpares];

        int indicepar = 0;
        int indiceImpar = 0;
        for (int numero : arregloA) {
            if (numero % 2 == 0) {
                pares [indicepar++] = numero;
            } else {
                impares[indiceImpar++] = numero;
            }
        }
        System.out.println(" Los numeros pares son: ");
        for (int numero : pares) {
            System.out.print(numero + " ");
        }
        System.out.println();

        System.out.println("Los numeros impares son: ");
        for (int numero : impares) {
            System.out.print(numero + " ");
        }
        System.out.println();

}
}