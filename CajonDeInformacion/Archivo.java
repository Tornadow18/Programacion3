package CajonDeInformacion;

import java.time.LocalDateTime;

public class Archivo {
     
 // Nombre del archivo
 private String nombre;
 // Ruta de almacenamiento original del archivo
private String ruta;
// Tamaño del archivo en MB
private float tamaño;
 // Tipo o extensión del archivo (por ejemplo, .pdf, .docx)
private String tipo;
 // Fecha en la que el archivo expirará (por defecto, 30 días después del respaldo)
private LocalDateTime fechaRespaldo;
// Constructor principal que inicializa todos los atributos y calcula la fecha de expiración
private LocalDateTime fechaExpiracion;

// Constructor principal que inicializa todos los atributos y calcula la fecha de expiración
public Archivo(String nombre, String ruta, float tamaño, String tipo) {
    this.nombre = nombre;
    this.ruta = ruta;
    this.tamaño = tamaño;
    this.tipo = tipo;
    this.fechaRespaldo = LocalDateTime.now();
    this.fechaExpiracion = fechaRespaldo.plusDays(30); // Expira en 30 días
}
 
// Constructor vacío que inicializa solo las fechas
public Archivo() {
    this.fechaRespaldo = LocalDateTime.now();
    this.fechaExpiracion = fechaRespaldo.plusDays(30);
}

// Métodos getter y setter para los atributos
public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getRuta() {
    return ruta;
}

public void setRuta(String ruta) {
    this.ruta = ruta;
}

public float getTamaño() {
    return tamaño;
}

public void setTamaño(float tamaño) {
    this.tamaño = tamaño;
}

public String getTipo() {
    return tipo;
}

public void setTipo(String tipo) {
    this.tipo = tipo;
}

public LocalDateTime getFechaRespaldo() {
    return fechaRespaldo;
}

public void setFechaRespaldo(LocalDateTime fechaRespaldo) {
    this.fechaRespaldo = fechaRespaldo;
}

public LocalDateTime getFechaExpiracion() {
    return fechaExpiracion;
}

public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
    this.fechaExpiracion = fechaExpiracion;
}

// Método para marcar el archivo como seleccionado
public void seleccionar() {
    System.out.println(" Archivo seleccionado: " + nombre);
}


// Método que simula la restauración del archivo
public void restaurar() {
    System.out.println(" Archivo restaurado desde: " + ruta);
}

  // Método que simula la eliminación del archivo
public void eliminar() {
    System.out.println("️ Archivo eliminado: " + nombre);
}


// Representación textual del archivo para mostrarlo por consola
@Override
public String toString() {
    return "Archivo [nombre=" + nombre + ", ruta=" + ruta + ", tamaño=" + tamaño
            + ", tipo=" + tipo + ", respaldo=" + fechaRespaldo
            + ", expiración=" + fechaExpiracion + "]";
}
}
