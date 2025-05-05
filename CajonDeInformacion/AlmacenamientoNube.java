package CajonDeInformacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlmacenamientoNube {
    // Espacio total disponible en MB
    private float espacioTotal;
    // Espacio actualmente usado en MB
    private float espacioUsado;
    // Espacio restante disponible en MB
    private float espacioDisponible;
     // Momento en que se inicializó el almacenamiento
    private LocalDateTime tiempoAlmacenado;
    // Lista de archivos actualmente almacenados
    private List<Archivo> archivosAlmacenados;
    
    // Constructor que inicializa el almacenamiento con un espacio total dado
    public AlmacenamientoNube(float espacioTotalMB) {
        this.espacioTotal = espacioTotalMB;
        this.espacioUsado = 0;
        this.espacioDisponible = espacioTotalMB;
        this.tiempoAlmacenado = LocalDateTime.now();
        this.archivosAlmacenados = new ArrayList<>();
    }
    
    
    // Método para almacenar un archivo si hay suficiente espacio
    public boolean almacenamientoArchivo(Archivo archivo) {
        if (archivo.getTamaño() <= espacioDisponible) {
            archivosAlmacenados.add(archivo);
            espacioUsado += archivo.getTamaño();
            calcularEspacioDisponible();
            System.out.println(" Archivo almacenado: " + archivo.getNombre());
            return true;
        } else {
             // Notifica al usuario si no hay suficiente espacio
            notificarUsuario(" No hay suficiente espacio para almacenar el archivo: " + archivo.getNombre());
            return false;
        }
    }
    
    // Método para eliminar archivos cuya fecha de expiración ha pasado
    public void gestionarTiempoAlmacenamiento() {
        LocalDateTime ahora = LocalDateTime.now();
        Iterator<Archivo> iterator = archivosAlmacenados.iterator();

        while (iterator.hasNext()) {
            Archivo archivo = iterator.next();
            if (archivo.getFechaExpiracion().isBefore(ahora)) {
                espacioUsado -= archivo.getTamaño();// libera espacio
                System.out.println("️ Archivo expirado eliminado: " + archivo.getNombre());
                iterator.remove();// elimina archivo expirado
            }
        }

        calcularEspacioDisponible(); // actualiza espacio disponible
    }
    
    
    // Método para notificar al usuario con un mensaje
    public boolean notificarUsuario(String mensaje) {
        System.out.println(" Notificación al usuario: " + mensaje);
        return true;
    }
    
    
    // Calcula el espacio disponible restando el usado del total
    public float calcularEspacioDisponible() {
        espacioDisponible = espacioTotal - espacioUsado;
        return espacioDisponible;
    }
   
    
    // Muestra los archivos almacenados actualmente
    public void mostrarArchivos() {
        if (archivosAlmacenados.isEmpty()) {
            System.out.println("\n No hay archivos almacenados.");
            return;
        }

        System.out.println("\n Archivos en el almacenamiento:");
        for (Archivo archivo : archivosAlmacenados) {
            System.out.println(archivo);
        }
    }

    // Getters
    public float getEspacioTotal() {
        return espacioTotal;
    }

    public float getEspacioUsado() {
        return espacioUsado;
    }

    public float getEspacioDisponible() {
        return espacioDisponible;
    }

    public LocalDateTime getTiempoAlmacenado() {
        return tiempoAlmacenado;
    }

    public List<Archivo> getArchivosAlmacenados() {
        return archivosAlmacenados;
    }
}
