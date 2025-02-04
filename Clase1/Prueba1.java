Public class Prueba1 {

    public static String void main(String[] args)
    {
        int[] a = [2,5,8,3,1,10,11];
        system.out.println(sumaParesImparesArreglo(a));
    }

    Public static String sumaParesImparesArreglo(int[] a)
    {
        int sumapares = 0, sumaImpares = 0;
        String cad="";
        for(int i =  0; i < a.length; i++)
        {
            if(a[i]%2 == 0)
            {
                sumapares += a[i];
                else
                {
                    sumaImpares += a[i];
                }

            cad = "La suma de los números pares ="+sumapares+"Suma de los números impares = "+sumaImpares;
            return cad;
            }
        }
    }
}