package CajonDeInformacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CopiaSeguridad {
      // Identificador único para la copia de seguridad
    private String id;
     // Fecha en que se creó la copia de seguridad
    private LocalDateTime fechaCreacion;
    // Tamaño total de los archivos respaldados (en MB)
    private float tamañoTotal;
    // Lista de archivos que se incluyen en la copia de seguridad
    private List<Archivo> archivos;
    
    // Constructor con parámetros: inicializa el ID, la fecha y la lista de archivos
    public CopiaSeguridad(String id, List<Archivo> archivos) 
    {
        this.id = id;
        this.fechaCreacion = LocalDateTime.now();
        this.archivos = archivos != null ? archivos : new ArrayList<>();
        this.tamañoTotal = calcularTamaño();// Se calcula automáticamente el tamaño
    }
    
    // Constructor vacío: se inicializa una copia vacía
    public CopiaSeguridad() 
    {
        this.fechaCreacion = LocalDateTime.now();
        this.archivos = new ArrayList<>();
        this.tamañoTotal = 0;
    }
    
    // Métodos getter y setter para los atributos
    public String getId() 
    {
        return id;
    }

    public void setId(String id) 
    {
        this.id = id;
    }

    public LocalDateTime getFechaCreacion() 
    {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) 
    {
        this.fechaCreacion = fechaCreacion;
    }

    public float getTamañoTotal() 
    {
        return tamañoTotal;
    }

    public void setTamañoTotal(float tamañoTotal) 
    {
        this.tamañoTotal = tamañoTotal;
    }

    public List<Archivo> getArchivos() 
    {
        return archivos;
    }

    public void setArchivos(List<Archivo> archivos) 
    {
        this.archivos = archivos;
        this.tamañoTotal = calcularTamaño();// Actualiza el tamaño al modificar archivos
    }
    
    // Crea una copia inicial con una lista de archivos
    public boolean crearCopiaInicial(List<Archivo> archivos)
    {
        if (archivos == null || archivos.isEmpty()) {
            return false;// No se puede crear una copia vacía
        }

        this.archivos = archivos;
        this.tamañoTotal = calcularTamaño();
        return true;
    }
    
    // Actualiza una copia existente con una nueva lista de archivos
    public boolean actualizarCopia(List<Archivo> nuevosArchivos) 
    {
        if (nuevosArchivos == null) 
        {
            return false;
        }

        this.archivos = nuevosArchivos;
        this.tamañoTotal = calcularTamaño();
        return true;
    }
    
    // Calcula el tamaño total de los archivos incluidos en la copia de seguridad
    public float calcularTamaño() 
    {
        float tamaño = 0;

        if (archivos != null) 
        {
            for (Archivo archivo : archivos) 
            {
                tamaño += archivo.getTamaño();
            }
        }

        return tamaño;
    }
    
    // Verifica si el tamaño total de la copia de seguridad no supera 1 GB (1024 MB)
    public boolean verificarEspacioDisponible() 
    {
        float espacioMaximo = 1024; // 1 GB en MB
        return tamañoTotal <= espacioMaximo;
    }
}
