import java.util.ArrayDeque;
import java.util.Queue;

public class EjercicioColas1 {
     public static void main(String[] args) {
      Queue<Integer> cola = new ArrayDeque<>();

        cola.add(10);
        cola.add(20);
        cola.add(30);
        
        System.out.println("Frente de la cola: " + cola.peek()); // 10
        System.out.println("Tamanno de la cola: " + cola.size()); // 3
        
        System.out.println("Elemento removido: " + cola.poll()); // 10
        System.out.println("Tamanno de la cola despues de desencolar: " + cola.size()); // 2
    }
}
