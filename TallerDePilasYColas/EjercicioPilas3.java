import java.util.Stack;

public class EjercicioPilas3 {
    
       public static int precedencia(char op) {
        switch (op) 
        {
            case '+':
            case '-':
                return 1;  // Suma y resta tienen 1 en prioridad
            case '*':
            case '/':
                return 2;  // Multiplicación y división tienen 2 en prioridad
            case '^':
                return 3;  // Exponentes tienen 3 en prioridad
            default:
                return -1;
        } 
    }

    public static String infijaApostfija(String expresion) 
    {
        Stack<Character> pila = new Stack<>();  // Se crea la Pila para los operadores
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < expresion.length(); i++) 
        {
            char actual = expresion.charAt(i);

            if (Character.isLetterOrDigit(actual)) 
            {
                resultado.append(actual);
            }
            // Si es un paréntesis de apertura '(', lo agregamos a la pila
            else if (actual == '(') 
            {
                pila.push(actual);
            }
            // Si es un paréntesis de cierre ')', vaciamos la pila hasta encontrar el '('
            else if (actual == ')') 
            {
                while (!pila.isEmpty() && pila.peek() != '(') 
                {
                    resultado.append(pila.pop());
                }
                pila.pop();  // Eliminamos el '(' de la pila
            }
            // Si es un operador, lo agregamos según su precedencia
            else if (actual == '+' || actual == '-' || actual == '*' || actual == '/' || actual == '^') 
            {
                while (!pila.isEmpty() && precedencia(pila.peek()) >= precedencia(actual)) 
                {
                    resultado.append(pila.pop());
                }
                pila.push(actual);  // Agregamos el operador actual a la pila
            }
        }

        // Al final de la expresión, vaciamos la pila y agregamos los operadores restantes al resultado
        while (!pila.isEmpty()) 
        {
            resultado.append(pila.pop());
        }

        return resultado.toString();  // Devolvemos la expresión postfija
    }

    public static void main(String[] args) 
    {
        String expresionInfija = "(x-y)/(z+w)-(z+y)^x";
        
        String expresionPostfija = infijaApostfija(expresionInfija);
        
        System.out.println("Expresion infija: " + expresionInfija);
        System.out.println("Expresion postfija: " + expresionPostfija);
    }
}
