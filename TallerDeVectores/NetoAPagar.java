import java.util.Scanner;

public class NetoAPagar 
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de empleados: ");
        int n = scanner.nextInt();
        double[] sueldos = new double[n];
        double[] asignaciones = new double[n];
        double[] deducciones = new double[n];
        double[] netos = new double[n];

        for(int i = 0; i < n; i++) 
        {
            System.out.println("Ingrese el sueldo del empleado"+ (i + 1) + ": ");
            sueldos[i] = scanner.nextDouble();
            System.out.println("Ingrese las asignaciones del empleado "+ (i + 1)+ ":" );
            asignaciones[i] = scanner.nextDouble();
            System.out.println("Ingrese las deducciones del empleado "+ (i + 1)+ ":" );
            deducciones[i] = scanner.nextDouble();

        }
        for (int i = 0; i < n; i++) 
        {
            netos[i] = sueldos[i] + asignaciones[i] - deducciones[i];
        }
    System.out.println("Neto a pagar por empleado:");
    for (int i = 0; i < n; i++) 
    {
        System.out.println("Empleado " + (i + 1) + ": " + netos[i]);
    }
    scanner.close();
    }
}
