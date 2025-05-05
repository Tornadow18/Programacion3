package CajonDeInformacion;

import java.time.LocalDateTime;
import java.util.UUID;

public class NotificacionUsuario {
     
    // Atributos de la notificación
    private String idNotificacion;    // Identificador único de la notificación
    private String mensaje;  // Mensaje que contiene la notificación
    private LocalDateTime fechaEnvio; // Fecha y hora en que fue enviada
    private boolean leida;    // Estado de lectura (true si fue leída)
    private String tipo;  // Tipo de notificación (ej: alerta, info, etc.)
    
    // Constructor por defecto: genera un ID único y establece la notificación como no leída
    public NotificacionUsuario() {
        this.idNotificacion = UUID.randomUUID().toString(); // ID único
        this.leida = false;
    }
    
    // Getters y setters   
    public String getIdNotificacion() {
        return idNotificacion;
    }
    
    public void setIdNotificacion(String idNotificacion) {
        this.idNotificacion = idNotificacion;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }
    
    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
    
    public boolean isLeida() {
        return leida;
    }
    
    public void setLeida(boolean leida) {
        this.leida = leida;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    // Método para crear una notificación con mensaje y tipo
    public boolean crearNotificacion(String mensaje, String tipo) {
        if (mensaje == null || mensaje.trim().isEmpty()) {
            System.out.println("El mensaje de la notificación no puede estar vacío");
            return false;
        }
        
        if (tipo == null || tipo.trim().isEmpty()) {
            System.out.println("El tipo de notificación no puede estar vacío");
            return false;
        }
        
        this.mensaje = mensaje;
        this.tipo = tipo;
        
        System.out.println("Notificación creada con ID: " + this.idNotificacion);
        return true;
    }
    
    // Marca la notificación como leída si aún no lo está
    public boolean marcarComoLeida() {
        if (this.leida) {
            System.out.println("La notificación ya está marcada como leída");
            return false;
        }
        
        this.leida = true;
        System.out.println("Notificación con ID " + this.idNotificacion + " marcada como leída");
        return true;
    }
    
    // Envía la notificación y registra la fecha de envío
    public boolean enviarNotificacion() {
        if (this.mensaje == null || this.mensaje.trim().isEmpty()) {
            System.out.println("No se puede enviar una notificación sin mensaje");
            return false;
        }
        
        if (this.tipo == null || this.tipo.trim().isEmpty()) {
            System.out.println("No se puede enviar una notificación sin tipo");
            return false;
        }
        
        // Asigna la fecha actual como momento de envío
        this.fechaEnvio = LocalDateTime.now();
        
        boolean exito = simularEnvio();
        
        if (exito) {
            System.out.println("Notificación enviada correctamente a las " + this.fechaEnvio);
        } else {
            System.out.println("Error al enviar la notificación");
        }
        
        return exito;
    }
    
    // Simula el envío de la notificación (con una probabilidad de éxito del 95%)
    private boolean simularEnvio() {
        

        try {
            Thread.sleep(100); // Simula el retardo del envío
        } catch (InterruptedException e) {
            System.out.println("Interrupción durante el envío de la notificación");
            return false;
        }
        
        double probabilidadExito = Math.random();
        return probabilidadExito <= 0.95;
    }
    
    // Representación textual de la notificación (útil para impresión o debugging)
    public String toString() {
        String estadoLectura = this.leida ? "Leída" : "No leída";
        String fechaStr = this.fechaEnvio != null ? this.fechaEnvio.toString() : "No enviada";
        
        return "Notificación [ID: " + this.idNotificacion + 
               ", Tipo: " + this.tipo +
               ", Fecha: " + fechaStr + 
               ", Estado: " + estadoLectura + 
               ", Mensaje: " + this.mensaje + "]";
    }
}
