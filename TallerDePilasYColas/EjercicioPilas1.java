import java.util.Stack;

public class EjercicioPilas1  
{

    public static void main(String[] args) 
    {
        Stack<Integer> p = new Stack<>();
        int x = 4, y;
        p.add(x);
        System.out.println("\n	" + p.peek());
        y = p.pop();
        p.add(32);
        p.add(p.pop());
        do {
            System.out.println("\n	" + p.pop());
        } while (!p.empty());
    }

}