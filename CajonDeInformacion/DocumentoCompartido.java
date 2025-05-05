package CajonDeInformacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DocumentoCompartido {
      // Identificador único del documento (se genera automáticamente con UUID)
    private String id;
     // Nombre del documento
    private String nombre;
    // Lista de destinatarios a los que se enviará el documento
    private List<String> destinatarios;
     // Fecha en que se compartió el documento
    private LocalDateTime fechaCompartida;
        // Estado del envío del documento (Ej: "Pendiente", "Enviado", "Error")

    private String estadoEnvio;
    
    // Constructor por defecto: genera un ID aleatorio y establece estado "Pendiente"
    public DocumentoCompartido() {
        this.id = UUID.randomUUID().toString();  // Constructor por defecto: genera un ID aleatorio y establece estado "Pendiente"
        this.destinatarios = new ArrayList<>();
        this.estadoEnvio = "Pendiente";
    }
    
    
    // Constructor con nombre: además de lo anterior, asigna un nombre al documento
    public DocumentoCompartido(String nombre) {
        this();// Llama al constructor por defecto
        this.nombre = nombre;
    }
    
    
    // Métodos getter y setter para acceder y modificar los atributos
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public List<String> getDestinatarios() {
        return destinatarios;
    }
    
    public void setDestinatarios(List<String> destinatarios) {
        this.destinatarios = destinatarios;
    }
    
    public LocalDateTime getFechaCompartida() {
        return fechaCompartida;
    }
    
    public void setFechaCompartida(LocalDateTime fechaCompartida) {
        this.fechaCompartida = fechaCompartida;
    }
    
    public String getEstadoEnvio() {
        return estadoEnvio;
    }
    
    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }
    
    // Método para enviar el documento a una lista de destinatarios
    public boolean enviarDocumento(List<String> destinatarios) {
        if (destinatarios == null || destinatarios.isEmpty()) {
            return false;// No se puede enviar sin destinatarios
        }
        
     
        this.destinatarios = destinatarios;
        
        // Verifica si el documento es seguro antes de enviarlo
        boolean envioExitoso = verificarSeguridad();
        
        if (envioExitoso) {
            this.estadoEnvio = "Enviado";
            System.out.println("Documento '" + this.nombre + "' enviado exitosamente a " + destinatarios.size() + " destinatarios.");
        } else {
            this.estadoEnvio = "Error";
            System.out.println("Error al enviar el documento '" + this.nombre + "'.");
        }
        
        return envioExitoso;
    }
    
    // Método para generar un código QR ficticio basado en ID y nombre del documento
    public String generarCodigoQR() {
        if (this.id == null || this.nombre == null) {
            return null;// No se puede generar QR sin datos esenciales
        }
        
        
        // Se genera un código QR en formato simple, usando partes del ID y del nombre
        String codigoQR = "QR-" + this.id.substring(0, 8) + "-" + this.nombre.replaceAll("\\s+", "").substring(0, Math.min(5, this.nombre.length()));
        
        System.out.println("Código QR generado para el documento: " + codigoQR);
        return codigoQR;
    }
    
     // Método para verificar la seguridad del documento antes de ser enviado
    public boolean verificarSeguridad() {
       
        // Aquí podrías agregar validaciones reales, por ahora siempre devuelve true
        boolean documentoSeguro = true;
        
        if (documentoSeguro) {
            System.out.println("Verificación de seguridad exitosa para el documento '" + this.nombre + "'.");
        } else {
            System.out.println("El documento '" + this.nombre + "' no cumple con los requisitos de seguridad.");
        }
        
        return documentoSeguro;
    }
}
