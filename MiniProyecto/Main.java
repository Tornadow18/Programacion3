package MiniProyecto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cine cine = new Cine();

        Sala sala1 = new Sala(1, 6, 12, false, true);
        Sala sala2 = new Sala(2, 6, 12, false, true);
        Sala sala3 = new Sala(3, 6, 12, true, false); 
        cine.agregarSala(sala1);
        cine.agregarSala(sala2);
        cine.agregarSala(sala3);

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Creacion de peliculas");
            System.out.println("2. Mostrar peliculas registradas");
            System.out.println("3. Asignacion de funciones");
            System.out.println("4. Mostrar funciones programadas");
            System.out.println("5. Ventas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearPelicula(cine, scanner);
                    break;
                case 2:
                    cine.mostrarPeliculas();
                    break;
                case 3:
                    asignarFuncion(cine, scanner);
                    break;
                case 4:
                    cine.mostrarFunciones();
                    break;
                case 5:
                    venderEntradas(cine, scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
        scanner.close();
    }

    public static void crearPelicula(Cine cine, Scanner scanner) {
        System.out.println("\n--- Creacion de Peliculas ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Idioma: ");
        String idioma = scanner.nextLine();
        System.out.print("Tipo (2D/3D): ");
        String tipo = scanner.nextLine();
        System.out.print("Duracion (minutos): ");
        int duracion = scanner.nextInt();
        scanner.nextLine();

        Pelicula pelicula = new Pelicula(nombre, idioma, tipo, duracion);
        cine.agregarPelicula(pelicula);
        System.out.println("Pelicula creada con exito.");
    }

    public static void asignarFuncion(Cine cine, Scanner scanner) {
        System.out.println("\n--- Asignacion de Funciones ---");
        System.out.print("Numero de sala: ");
        int numeroSala = scanner.nextInt();
        scanner.nextLine();

        Sala sala = cine.obtenerSala(numeroSala);
        if (sala == null) {
            System.out.println("Sala no encontrada.");
            return;
        }

        System.out.print("Nombre de la pelicula: ");
        String nombrePelicula = scanner.nextLine();
        Pelicula pelicula = cine.obtenerPelicula(nombrePelicula);
        if (pelicula == null) {
            System.out.println("Pelicula no encontrada.");
            return;
        }

        System.out.print("Seleccione franja horaria (1: 14:00-16:30, 2: 16:30-19:00, 3: 19:00-21:00): ");
        int franja = scanner.nextInt() - 1;
        scanner.nextLine();

        if (franja < 0 || franja > 2) {
            System.out.println("Franja horaria invalida.");
            return;
        }

        cine.asignarFuncion(sala, pelicula, franja);
    }

    public static void venderEntradas(Cine cine, Scanner scanner) {
        System.out.println("\n--- Venta de Entradas ---");
        System.out.print("Numero de sala: ");
        int numeroSala = scanner.nextInt();
        scanner.nextLine();

        Sala sala = cine.obtenerSala(numeroSala);
        if (sala == null) {
            System.out.println("Sala no encontrada.");
            return;
        }

        System.out.print("Seleccione franja horaria (1: 14:00-16:30, 2: 16:30-19:00, 3: 19:00-21:00): ");
        int franja = scanner.nextInt() - 1;
        scanner.nextLine();

        if (franja < 0 || franja > 2 || sala.getFuncion(franja) == null) {
            System.out.println("Franja horaria invalida o funcion no programada.");
            return;
        }

        Funcion funcion = sala.getFuncion(franja);
        System.out.println("\n--- Sala " + numeroSala + " - Franja " + (franja + 1) + " - Película: " + funcion.getPelicula().getNombre() + " ---");
        sala.mostrarDisponibilidadAsientos();

        System.out.print("¿Cuantas entradas desea comprar?: ");
        int cantidadEntradas = scanner.nextInt();
        scanner.nextLine();

        double totalPagar = 0;
        for (int i = 0; i < cantidadEntradas; i++) {
            System.out.print("Seleccione asiento (Ej: A1, G5 para preferencial en salas 1 y 2): ");
            String asientoStr = scanner.nextLine().toUpperCase();
            char filaChar = asientoStr.charAt(0);
            int numeroAsiento = Integer.parseInt(asientoStr.substring(1));

            Asiento asiento = sala.encontrarAsiento(filaChar, numeroAsiento);
            if (asiento == null) {
                System.out.println("Asiento invalido. Intente nuevamente.");
                i--; 
                continue;
            }

            if (asiento.isOcupado()) {
                System.out.println("Asiento no disponible. Intente nuevamente.");
                i--; 
                continue;
            }

            asiento.ocupar();
            double precioEntrada;
            if (sala.getEs3D()) {
                precioEntrada = 10000; 
            } else if (asiento.isPreferencial()) {
                precioEntrada = 12000; 
            } else {
                precioEntrada = 8000;  
            }
            totalPagar += precioEntrada;
            System.out.println("Asiento " + asientoStr + " reservado.");
        }

        System.out.println("\n--- Resumen de Venta ---");
        System.out.println("Total a pagar: $" + totalPagar);
        System.out.println("Venta de entradas completada.");
    }
}