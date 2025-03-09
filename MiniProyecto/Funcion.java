package MiniProyecto;

public class Funcion {
    private Pelicula pelicula;
    private Sala sala;
    private int franja;

    public Funcion(Pelicula peliculaFuncion, Sala salaFuncion, int franjaFuncion) {
        pelicula = peliculaFuncion;
        sala = salaFuncion;
        franja = franjaFuncion;
    }

    public Pelicula getPelicula() { return pelicula; }
    public Sala getSala() { return sala; }
    public int getFranja() { return franja; }

    public String toString() {
        return "Funcion: " + pelicula.getNombre() + " | Sala: " + sala.getNumero() + " | Franja: " + franja;
    }
}