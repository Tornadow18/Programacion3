package CajonDeInformacion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Usuario {
      // Atributos privados del usuario
    private String correoElectronico;   // Correo del usuario
    private String contrasenna;  // Contraseña del usuario
    private LocalDateTime fechaRegistro; // Fecha de registro del usuario
    
    // Constructor por defecto que establece la fecha de registro actual
    public Usuario() 
    {
        this.fechaRegistro = LocalDateTime.now();
    }
    
    
    // Constructor con parámetros para crear un usuario con correo y contraseña
    public Usuario(String correoElectronico, String contrasenna) 
    {
        this.correoElectronico = correoElectronico;
        this.contrasenna = contrasenna;
        this.fechaRegistro = LocalDateTime.now();
    }
    
    // Getters y setters
    public String getCorreoElectronico() 
    {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) 
    {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasenna() 
    {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) 
    {
        this.contrasenna = contrasenna;
    }

    public LocalDateTime getFechaRegistro() 
    {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) 
    {
        this.fechaRegistro = fechaRegistro;
    }
    
    /**
     * Guarda la información del usuario en un archivo de texto.
     * @param nombreArchivo nombre del archivo donde se guardarán los datos.
     * @throws IOException si ocurre un error al escribir en el archivo.
     */
    public void guardarArchivo(String nombreArchivo) throws IOException 
    {
    // Intenta abrir el archivo en modo de agregado (append)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) 
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaFormateada = fechaRegistro.format(formatter);
            
            
            // Escribir los datos del usuario en el archivo
            writer.write("Correo Electronico: " + correoElectronico);
            writer.newLine();
            writer.write("Contrasenna: " + contrasenna);
            writer.newLine();
            writer.write("Fecha de Registro: " + fechaFormateada);
            writer.newLine();
            writer.newLine();

            System.out.println(" Información del usuario guardada en " + nombreArchivo);
        } catch (IOException e) 
        {
            // En caso de error, mostrar mensaje y relanzar la excepción
            System.out.println(" Error al guardar usuario: " + e.getMessage());
            throw e;
        }
    }
    
     /**
     * Retorna una representación en texto del objeto Usuario.
     */
    @Override
    public String toString() 
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Usuario{"
                + "correoElectronico='" + correoElectronico + '\''
                + ", contrasenna='" + contrasenna + '\''
                + ", fechaRegistro=" + fechaRegistro.format(formatter)
                + '}';
    }
}
