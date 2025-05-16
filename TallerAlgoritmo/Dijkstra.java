import java.util.Scanner;

public class Dijkstra 
{

    // Establecer el valor "infinito" para representar la ausencia de una arista
    public int[] distancia = new int[10]; // Arreglo para almacenar las distancias más cortas
    public int[][] costo = new int[10][10]; // Matriz de adyacencia para los costos

    // Método para calcular las distancias más cortas usando Dijkstra
    public void calcularRuta(int cantidadNodos, int nodoOrigen) 
    {
        int[] visitado = new int[cantidadNodos + 1]; // Marca si un nodo ha sido visitado
        int i, nodoMinimo = 1, nodoActual, contador, minimo;

        // Inicializar las distancias y marcar los nodos como no visitados
        for (i = 1; i <= cantidadNodos; i++) 
        {
            visitado[i] = 0;
            this.distancia[i] = this.costo[nodoOrigen][i]; // Inicializar con el costo directo desde el nodo fuente
        }

        contador = 2; // Comenzar desde el segundo nodo
        while (contador <= cantidadNodos) 
        {
            minimo = Integer.MAX_VALUE; // Inicializar el valor mínimo como infinito

            // Buscar el nodo con la distancia mínima que aún no ha sido visitado
            for (nodoActual = 1; nodoActual <= cantidadNodos; nodoActual++) 
            {
                if (this.distancia[nodoActual] < minimo && visitado[nodoActual] != 1)
                {
                    minimo = this.distancia[nodoActual];
                    nodoMinimo = nodoActual;
                }
            }

            visitado[nodoMinimo] = 1; // Marcar el nodo con la distancia mínima como visitado
            contador++;

            // Actualizar las distancias de los nodos vecinos
            for (nodoActual = 1; nodoActual <= cantidadNodos; nodoActual++) 
            {
                if (this.distancia[nodoMinimo] + this.costo[nodoMinimo][nodoActual] < this.distancia[nodoActual]
                    && visitado[nodoActual] != 1
                    && this.costo[nodoMinimo][nodoActual] != Integer.MAX_VALUE)
                {

                    this.distancia[nodoActual] = this.distancia[nodoMinimo] + this.costo[nodoMinimo][nodoActual];
                }
            }
        }
    }

    // Método principal
    public static void main(String args[]) 
    {
        int cantidadNodos, nodoOrigen, nodoDestino, i, j;
        Scanner entrada = new Scanner(System.in);

        // Pedir al usuario el número de nodos
        System.out.println("Ingresar el numero de nodos:");
        cantidadNodos = entrada.nextInt();

        // Crear una instancia del objeto Dijkstra
        Dijkstra algoritmo = new Dijkstra();

        // Pedir al usuario que ingrese la matriz de costos
        System.out.println("Ingresar la matriz de costos (0 si no hay arista entre los nodos):");
        for (i = 1; i <= cantidadNodos; i++) 
        {
            for (j = 1; j <= cantidadNodos; j++) 
            {
                algoritmo.costo[i][j] = entrada.nextInt();
                if (algoritmo.costo[i][j] == 0 && i != j)
                {
                    algoritmo.costo[i][j] = Integer.MAX_VALUE; // Representar la falta de arista con infinito
                }
            }
        }

        // Pedir al usuario el nodo fuente
        System.out.println("Ingresar el nodo de origen (de 1 a " + cantidadNodos + "):");
        nodoOrigen = entrada.nextInt();

        // Pedir al usuario el nodo de destino
        System.out.println("Ingresar el nodo de destino (de 1 a " + cantidadNodos + "):");
        nodoDestino = entrada.nextInt();

        // Ejecutar el algoritmo de Dijkstra
        algoritmo.calcularRuta(cantidadNodos, nodoOrigen);

        // Imprimir la distancia más corta desde el nodo fuente hasta el nodo destino
        if (algoritmo.distancia[nodoDestino] == Integer.MAX_VALUE) 
        {
            System.out.println("No hay ruta disponible entre el nodo " + nodoOrigen 
                    + " y el nodo " + nodoDestino);
        } else 
        {
            System.out.println("La distancia mas corta desde el nodo " + nodoOrigen + " al nodo "
                    + nodoDestino + " es: " + algoritmo.distancia[nodoDestino]);
        }

        entrada.close();
    }
}