import java.util.ArrayDeque;
import java.util.Deque;

public class EjercicioColas2 {
       public static void main(String[] args) {
        Deque<Integer> cola = new ArrayDeque<>();

        cola.addLast(10);
        cola.addLast(20);
        cola.addLast(30);

        cola.addFirst(5);

        System.out.println("Contenido de la Cola: " + cola);

        Integer firstElement = cola.removeFirst();
        System.out.println("Elemento eliminado del principio: " + firstElement);

        Integer lastElement = cola.removeLast();
        System.out.println("Elemento eliminado del final: " + lastElement);

        System.out.println("Contenido de la Cola despues de eliminar los elementos: " + cola);
    }
}
