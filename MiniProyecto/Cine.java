package MiniProyecto;

public class Cine {
    private Sala[] salas;
    private Pelicula[] peliculas;
    private int numSalas;
    private int numPeliculas;

    public Cine() {
        salas = new Sala[3];
        peliculas = new Pelicula[20];
        numSalas = 0;
        numPeliculas = 0;
    }

    public void agregarSala(Sala salaAgregar) {
        if (numSalas < salas.length) {
            salas[numSalas] = salaAgregar;
            numSalas++;
        }
    }

    public void agregarPelicula(Pelicula peliculaAgregar) {
        if (numPeliculas < peliculas.length) {
            peliculas[numPeliculas] = peliculaAgregar;
            numPeliculas++;
        }
    }

    public void mostrarPeliculas() {
    System.out.println("\n--- Peliculas Registradas ---");
    if (numPeliculas == 0) {
        System.out.println("No hay peliculas registradas.");
        return;
    }
    for (int i = 0; i < numPeliculas; i++) {
        System.out.println(peliculas[i].getNombre() + " | " + peliculas[i].getTipo());
    }
}


    public Sala obtenerSala(int numero) {
        for (int i = 0; i < numSalas; i++) {
            if (salas[i].getNumero() == numero) {
                return salas[i];
            }
        }
        return null;
    }

    public Pelicula obtenerPelicula(String nombre) {
        for (int i = 0; i < numPeliculas; i++) {
            if (peliculas[i].getNombre().equalsIgnoreCase(nombre)) {
                return peliculas[i];
            }
        }
        return null;
    }

    public void asignarFuncion(Sala sala, Pelicula pelicula, int franja) {
        if (sala.getEs3D() && !pelicula.getTipo().equals("3D")) {
            System.out.println("Error: La sala 3 solo admite peliculas 3D.");
            return;
        }
        if (!sala.getEs3D() && pelicula.getTipo().equals("3D")) {
            System.out.println("Error: Las salas 1 y 2 no admiten peliculas 3D.");
            return;
        }
        if (sala.getFuncion(franja) != null) {
            System.out.println("Error: La franja horaria ya está ocupada en esta sala.");
            return;
        }

        sala.asignarFuncion(new Funcion(pelicula, sala, franja));
        System.out.println("Funcion asignada con exito.");
    }

    public void mostrarFunciones() {
        System.out.println("\n--- Funciones Programadas ---");
        for (int i = 0; i < numSalas; i++) {
            for (int j = 0; j < 3; j++) {
                Funcion funcion = salas[i].getFuncion(j);
                if (funcion != null) {
                    System.out.println("Sala " + salas[i].getNumero() + " | " + funcion.getPelicula().getNombre() + " | Franja: " + (j + 1));
                }
            }
        }
    }
}