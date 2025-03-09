package MiniProyecto;

public class Pelicula {
    private String nombre;
    private String idioma;
    private String tipo;
    private int duracion;

    public Pelicula(String nombrePelicula, String idiomaPelicula, String tipoPelicula, int duracionPelicula) {
        nombre = nombrePelicula;
        idioma = idiomaPelicula;
        tipo = tipoPelicula;
        duracion = duracionPelicula;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }

    public String toString() {
        return "Pelicula: " + nombre + " | Idioma: " + idioma + " | Tipo: " + tipo + " | Duracion: " + duracion + " min";
    }
}
