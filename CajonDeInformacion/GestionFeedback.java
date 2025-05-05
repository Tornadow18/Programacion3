package CajonDeInformacion;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GestionFeedback {
     // Atributos principales del feedback
    private String idFeedback; // Identificador único del feedback
    private String comentario; // Comentario del usuario
    private LocalDateTime fechaRecibido; // Fecha en que se recibió el feedback
    private String estado; // Estado actual del feedback (Pendiente, Recibido, Respondido, etc.)
    private String respuesta; // Respuesta dada al feedback
    
    // Constructor por defecto: genera ID automáticamente y estado por defecto "Pendiente"
    public GestionFeedback() {
        this.idFeedback = UUID.randomUUID().toString();
        this.estado = "Pendiente";
    }
    
    
    // Métodos getter y setter para los atributos
    public String getIdFeedback() {
        return idFeedback;
    }
    
    public void setIdFeedback(String idFeedback) {
        this.idFeedback = idFeedback;
    }
    
    public String getComentario() {
        return comentario;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public LocalDateTime getFechaRecibido() {
        return fechaRecibido;
    }
    
    public void setFechaRecibido(LocalDateTime fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getRespuesta() {
        return respuesta;
    }
    
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    // Método para registrar el feedback si el comentario no está vacío
    public boolean registrarFeedback(String comentario) {
        if (comentario == null || comentario.trim().isEmpty()) {
            System.out.println("El comentario no puede estar vacío");
            return false;
        }
        
        this.comentario = comentario;
        this.fechaRecibido = LocalDateTime.now();
        this.estado = "Recibido";
        
        System.out.println("Feedback registrado con ID: " + this.idFeedback);
        return true;
    }
    
    // Método para responder al feedback si existe y no está vacío
    public boolean responderFeedback(String respuesta) {
        if (respuesta == null || respuesta.trim().isEmpty()) {
            System.out.println("La respuesta no puede estar vacía");
            return false;
        }
        
        if (this.comentario == null || this.comentario.trim().isEmpty()) {
            System.out.println("No se puede responder a un feedback que no existe");
            return false;
        }
        
        this.respuesta = respuesta;
        this.estado = "Respondido";
        
        System.out.println("Feedback con ID " + this.idFeedback + " ha sido respondido");
        return true;
    }
    
    // Método para analizar el contenido del comentario
    public Map<String, Object> analizarFeedback() {
        if (this.comentario == null || this.comentario.trim().isEmpty()) {
            System.out.println("No hay feedback que analizar");
            return null;
        }
        
        Map<String, Object> analisis = new HashMap<>();
       
        // Longitud del comentario
        analisis.put("longitud", this.comentario.length());
       
        // Sentimiento detectado (positivo, negativo o neutral)
        String sentimiento = determinarSentimiento(this.comentario);
        analisis.put("sentimiento", sentimiento);
        
        String categoria = categorizarFeedback(this.comentario);
        analisis.put("categoria", categoria);
        
        // Sentimiento detectado (positivo, negativo o neutral)
        int urgencia = calcularUrgencia(this.comentario);
        analisis.put("urgencia", urgencia);
        
        // Cálculo de días desde que fue recibido
        if (this.fechaRecibido != null) {
            long diasTranscurridos = java.time.Duration.between(this.fechaRecibido, LocalDateTime.now()).toDays();
            analisis.put("diasTranscurridos", diasTranscurridos);
        }
        
        System.out.println("Análisis de feedback completado para ID: " + this.idFeedback);
        return analisis;
    }
    
    // Método que toma acción según el análisis del comentario
    public boolean actuarSobreFeedback() {
        if (this.comentario == null || this.comentario.trim().isEmpty()) {
            System.out.println("No hay feedback sobre el cual actuar");
            return false;
        }
       
        Map<String, Object> analisis = analizarFeedback();
        if (analisis == null) {
            return false;
        }
       
        String sentimiento = (String) analisis.get("sentimiento");
        String categoria = (String) analisis.get("categoria");
        int urgencia = (int) analisis.getOrDefault("urgencia", 0);
        
        // Lógica de decisión basada en urgencia y sentimiento
        if (urgencia > 8) {
            this.estado = "Prioridad Alta";
            System.out.println("Feedback marcado como prioridad alta. Se requiere acción inmediata.");
        } else if (sentimiento.equals("Negativo") && urgencia > 5) {
            this.estado = "Requiere Atención";
            System.out.println("Feedback negativo que requiere atención prioritaria.");
        } else if (sentimiento.equals("Positivo")) {
            this.estado = "Agradecimiento";
            System.out.println("Feedback positivo. Se enviará un agradecimiento al usuario.");
        } else {
            this.estado = "En Proceso";
            System.out.println("Feedback en proceso de evaluación.");
        }
        
        return true;
    }
    
    
    // Determina el sentimiento del comentario con base en palabras clave
    private String determinarSentimiento(String texto) {
      
        String textoLower = texto.toLowerCase();
        
        if (textoLower.contains("excelente") || textoLower.contains("bueno") || 
            textoLower.contains("genial") || textoLower.contains("me gusta")) {
            return "Positivo";
        } else if (textoLower.contains("malo") || textoLower.contains("horrible") || 
                   textoLower.contains("pésimo") || textoLower.contains("no funciona")) {
            return "Negativo";
        } else {
            return "Neutral";
        }
    }
    
    // Clasifica el feedback por tema
    private String categorizarFeedback(String texto) {
        
        String textoLower = texto.toLowerCase();
        
        if (textoLower.contains("interfaz") || textoLower.contains("diseño") || textoLower.contains("visual")) {
            return "Interfaz de Usuario";
        } else if (textoLower.contains("lento") || textoLower.contains("rápido") || textoLower.contains("velocidad")) {
            return "Rendimiento";
        } else if (textoLower.contains("error") || textoLower.contains("falla") || textoLower.contains("bug")) {
            return "Problemas Técnicos";
        } else if (textoLower.contains("función") || textoLower.contains("característica") || textoLower.contains("feature")) {
            return "Funcionalidad";
        } else {
            return "General";
        }
    }
    
    
    // Calcula el nivel de urgencia en una escala de 1 a 10 basado en palabras clave
    private int calcularUrgencia(String texto) {

        String textoLower = texto.toLowerCase();
        int urgencia = 5;  // Valor base
        
        // Aumentos por términos urgentes
        if (textoLower.contains("urgente") || textoLower.contains("inmediato")) urgencia += 3;
        if (textoLower.contains("critico") || textoLower.contains("grave")) urgencia += 2;
        if (textoLower.contains("importante")) urgencia += 1;
        if (textoLower.contains("ahora") || textoLower.contains("ya")) urgencia += 1;
        
        // Disminuciones por términos poco urgentes
        if (textoLower.contains("cuando puedas") || textoLower.contains("sin prisa")) urgencia -= 2;
        if (textoLower.contains("sugerencia") || textoLower.contains("idea")) urgencia -= 1;
        
        // Asegura que la urgencia esté en el rango 1-10
        if (urgencia < 1) urgencia = 1;
        if (urgencia > 10) urgencia = 10;
        
        return urgencia;
    }
}
