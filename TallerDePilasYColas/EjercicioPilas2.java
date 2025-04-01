import java.util.Stack;

public class EjercicioPilas2 {
        public static void mostrarPila(Stack<String> pila) {
        Stack<String> pilaAuxiliar = new Stack<>();
        
        while (!pila.isEmpty()) {
            String elemento = pila.pop();
            System.out.println(elemento);
            pilaAuxiliar.push(elemento);
        }
        
        while (!pilaAuxiliar.isEmpty()) {
            pila.push(pilaAuxiliar.pop());
        }
    }
    
    public static void main(String[] args) 
    {
        Stack<String> pila = new Stack<>();
        
        pila.push("Elemento 1");
        pila.push("Elemento 2");
        pila.push("Elemento 3");
        
        mostrarPila(pila);
        
        System.out.println("La pila original: " + pila);
    }
}
