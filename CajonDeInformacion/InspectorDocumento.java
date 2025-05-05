package CajonDeInformacion;

import java.util.ArrayList;
import java.util.List;

public class InspectorDocumento {
       
    // Atributos de la clase
    private String documento;  // Contenido del documento a inspeccionar
    private String archivo;    // Contenido del documento a inspeccionar
    private List<String> datosOcultos; // Lista para almacenar datos sensibles encontrados

    
    // Constructor principal que inicializa el documento y el nombre del archivo
    public InspectorDocumento(String documento, String archivo) {
        this.documento = documento;
        this.archivo = archivo;
        this.datosOcultos = new ArrayList<>();
    }
    
    
    // Constructor vacío no implementado, lanza excepción si se usa
    InspectorDocumento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // Getters
    public String getDocumento() {
        return documento;
    }

    public String getArchivo() {
        return archivo;
    }

    public List<String> getDatosOcultos() {
        return datosOcultos;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public void setDatosOcultos(List<String> datosOcultos) {
        this.datosOcultos = datosOcultos;
    }
    
    
    // Método que busca patrones específicos considerados como datos ocultos o sensibles
    public List<String> buscarDatosOculto() {
       
        datosOcultos.clear(); // Limpia resultados anteriores
        
        
        // Busca la palabra clave "CONFIDENCIAL"
        if (documento.contains("CONFIDENCIAL")) {
            datosOcultos.add("CONFIDENCIAL");
        }
        
        
        // Busca un ejemplo de número de seguro social
        if (documento.contains("123-45-6789")) {
            datosOcultos.add("Número de Seguro Social");
        }
        return datosOcultos;
    }
    
    
    // Método que elimina información personal (simulada con un número de seguro social)
    public boolean quitarInformacionPersona() {
        boolean modificado = false;
        // Si encuentra el patrón, lo reemplaza por un marcador
        if (documento.contains("123-45-6789")) {
            documento = documento.replace("123-45-6789", "[ELIMINADO]");
            modificado = true;
        }
        return modificado;
    }
    
    // Método que "limpia" el documento (lo vacía completamente)
    public String limpiarDocumento() {
        documento = "";
        return archivo;  // Retorna el nombre del archivo asociado
    }
    
    // Método que genera un reporte con los datos sensibles encontrados
    public String generarReporte() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("Reporte de Inspección del Documento:\n");
        reporte.append("Archivo: ").append(archivo).append("\n");
        reporte.append("Datos Ocultos Encontrados:\n");
        
        // Agrega cada dato detectado al reporte
        for (String dato : datosOcultos) {
            reporte.append("- ").append(dato).append("\n");
        }
        return reporte.toString();
    }
}
