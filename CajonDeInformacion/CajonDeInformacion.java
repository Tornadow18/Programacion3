package CajonDeInformacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CajonDeInformacion {
       public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Para recibir entradas del usuario
        Usuario usuario = null; // Usuario actual
        AlmacenamientoNube almacenamiento = new AlmacenamientoNube(1024); // 1 GB
       
                
        boolean salir = false;
        
        // Se inicializa con 1 GB de espacio
        while (!salir) 
        {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("Bienvenidos al cajon de informacion\n"+
                    " Ingrese una opcion ");
            // Opciones del sistema
            System.out.println("1. Crear usuario");
            System.out.println("2. Crear copia de seguridad");
            System.out.println("3. Ver archivos en almacenamiento nube");
            System.out.println("4. Acciones sobre archivos (seleccionar, restaurar, eliminar)");
            System.out.println("5. enviarDocumentos(enviarDocumento, generarCodigoQR, verificarSeguridad)");
            System.out.println("6. registrarFeedback(registrarFeedback,analizarFeedback,actuarSobreFeedback)");
            System.out.println("7. crearNotificacion(crearNotificacion, marcarComoLeida)");
            System.out.println("8. Buscar(Buscar,quitarInformacion,limpiarDocumento,generarReporte)");
            System.out.println("9. Salir");
            String opcion = scanner.nextLine();

            switch (opcion) 
            {
                case "1":
                    // Crear usuario
                    System.out.print("Correo electronico: ");
                    String correo = scanner.nextLine();
                    System.out.print("Contrasenna: ");
                    String contrasenna = scanner.nextLine();

                    usuario = new Usuario(correo, contrasenna);
                    try 
                    {
                        usuario.guardarArchivo("usuarios.txt");  // Guarda en archivo de texto
                    } catch (IOException e) 
                    {
                        System.out.println("Error al guardar el usuario.");
                    }
                    break;

                case "2":
                    // Crear respaldo de archivos
                    if (usuario == null) 
                    {
                        System.out.println("️ Debe crear un usuario antes.");
                        break;
                    }

                    System.out.print("¿Cuantos archivos desea respaldar? ");
                    int cantidadArchivos;
                    try 
                    {
                        cantidadArchivos = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) 
                    {
                        System.out.println("️ Ingrese un número valido.");
                        break;
                    }

                    for (int i = 1; i <= cantidadArchivos; i++) 
                    {
                        System.out.println("\nArchivo " + i + ":");
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ruta: ");
                        String ruta = scanner.nextLine();
                        System.out.print("Tamanno (en MB): ");
                        float tamaño;
                        try 
                        {
                            tamaño = Float.parseFloat(scanner.nextLine());
                        } catch (NumberFormatException e) 
                        {
                            System.out.println("️ Tamanno invalido.");
                            i--;    // Crear respaldo de archivos
                            continue;
                        }
                        System.out.print("Tipo: ");
                        String tipo = scanner.nextLine();

                        Archivo archivo = new Archivo(nombre, ruta, tamaño, tipo);
                        almacenamiento.almacenamientoArchivo(archivo); // Almacena en nube
                    }
                    
                    
                    // Mostrar espacio usado y disponible
                    System.out.println(" Espacio usado: " + almacenamiento.getEspacioUsado() + " MB");
                    System.out.println(" Espacio disponible: " + almacenamiento.getEspacioDisponible() + " MB");
                    break;

                case "3":
                    // Mostrar archivos en la nube (luego de eliminar expirados)
                    almacenamiento.gestionarTiempoAlmacenamiento(); // elimina expirados
                    almacenamiento.mostrarArchivos();
                    break;

                case "4":
                    // Acciones sobre archivos
                    List<Archivo> archivosDisponibles = almacenamiento.getArchivosAlmacenados();
                    if (archivosDisponibles.isEmpty()) 
                    {
                        System.out.println("️ No hay archivos para gestionar.");
                        break;
                    }
                    
                    // Mostrar archivos
                    System.out.println("\n Archivos disponibles:");
                    for (int i = 0; i < archivosDisponibles.size(); i++) 
                    {
                        System.out.println((i + 1) + ". " + archivosDisponibles.get(i).getNombre());
                    }

                    System.out.print("Seleccione el número del archivo: ");
                    int seleccion;
                    try 
                    {
                        seleccion = Integer.parseInt(scanner.nextLine()) - 1;
                        if (seleccion < 0 || seleccion >= archivosDisponibles.size()) 
                        {
                            System.out.println(" Seleccion invalida.");
                            break;
                        }
                    } catch (NumberFormatException e) 
                    {
                        System.out.println(" Entrada invalida.");
                        break;
                    }

                    Archivo archivoSeleccionado = archivosDisponibles.get(seleccion);
                    archivoSeleccionado.seleccionar();  // Marcar como seleccionado
                    
                    // Acciones: Restaurar o Eliminar
                    System.out.println("1. Restaurar");
                    System.out.println("2. Eliminar");
                    System.out.print("Accion: ");
                    String accion = scanner.nextLine();

                    if (accion.equals("1")) 
                    {
                        archivoSeleccionado.restaurar();
                    } else if (accion.equals("2")) 
                    {
                        archivoSeleccionado.eliminar();
                        almacenamiento.getArchivosAlmacenados().remove(seleccion);
                        almacenamiento.calcularEspacioDisponible();
                    } else 
                    {
                        System.out.println(" Accion invalida.");
                    }
                    
                    break;
                    
                   case "5":
                   // Gestión de documentos compartidos
    List<DocumentoCompartido> documentoCompartidos = new ArrayList<>();
    documentoCompartidos.add(new DocumentoCompartido("Informe Mensual"));
    documentoCompartidos.add(new DocumentoCompartido("Reporte Financiero"));
    documentoCompartidos.add(new DocumentoCompartido("Presentación Proyecto"));

    System.out.println("Documentos disponibles:");
    for (int i = 0; i < documentoCompartidos.size(); i++) 
    {
        System.out.println((i + 1) + ". " + documentoCompartidos.get(i).getNombre());
    }

    System.out.print("Seleccione un documento (numero): ");
    int seleccionDoc;
    try 
    {
        seleccionDoc = Integer.parseInt(scanner.nextLine()) - 1;
    } catch (NumberFormatException e) 
    {
        System.out.println("Seleccion invalida.");
        break;
    }

    if (seleccionDoc >= 0 && seleccionDoc < documentoCompartidos.size()) 
    {
        DocumentoCompartido docSeleccionado = documentoCompartidos.get(seleccionDoc);
        System.out.println("Documento seleccionado: " + docSeleccionado.getNombre());
        
        // Opciones sobre el documento
        System.out.println("1. Enviar documento");
        System.out.println("2. Generar código QR");
        System.out.println("3. Verificar seguridad");
        System.out.print("Accion: ");
        String accionDoc = scanner.nextLine();

        switch (accionDoc) 
        {
            case "1":
                System.out.print("Ingrese destinatarios separados por coma: ");
                String input = scanner.nextLine();
                List<String> destinatarios = Arrays.asList(input.split("\\s*,\\s*"));
                docSeleccionado.enviarDocumento(destinatarios);
                break;

            case "2":
                docSeleccionado.generarCodigoQR();
                break;

            case "3":
                docSeleccionado.verificarSeguridad();
                break;

            default:
                System.out.println("Accion invalida.");
                break;
        }

    } else 
    {
        System.out.println("Seleccion invalida.");
    }
    break;
    
    case "6":
        // Gestión de feedback
                    GestionFeedback feedback = new GestionFeedback();

                    // Registrar un comentario de feedback
                    String comentario = "La interfaz es muy lenta y presenta errores graves. Es urgente solucionarlo.";
                    boolean registrado = feedback.registrarFeedback(comentario);

                    if (registrado) 
                    {
                        // Analizar el feedback
                        System.out.println("\n--- Analisis del Feedback ---");
                        feedback.analizarFeedback();

                        // Actuar en base al análisis
                        System.out.println("\n--- Accion sobre el Feedback ---");
                        feedback.actuarSobreFeedback();

                        // Responder al feedback
                        String respuesta = "Gracias por reportar estos problemas. Nuestro equipo está trabajando para solucionarlos.";
                        feedback.responderFeedback(respuesta);
                    } else 
                    {
                        System.out.println("No se pudo registrar el feedback.");
                    }
                    break;
                    
    case "7":
    // Notificación a usuario
    NotificacionUsuario notificacion = new NotificacionUsuario();

    System.out.print("Ingrese el mensaje de la notificacion: ");
    String mensaje = scanner.nextLine();

    System.out.print("Ingrese el tipo de notificacion (por ejemplo: Alerta, Informacion, Recordatorio): ");
    String tipo = scanner.nextLine();

    if (notificacion.crearNotificacion(mensaje, tipo)) 
    {
    if (notificacion.enviarNotificacion()) 
     {
    System.out.println("Detalles de la notificacion:");
    System.out.println(notificacion.toString());

    System.out.print("¿Desea marcarla como leida? (s/n): ");
    String respuestaLeido = scanner.nextLine();
    if (respuestaLeido.equalsIgnoreCase("s")) 
       {
    notificacion.marcarComoLeida();
    System.out.println("Estado actualizado:");
    System.out.println(notificacion.toString());
       }
     }
    } else 
    {
    System.out.println("No se pudo crear la notificacion.");
    }
    break;
    
    case "8":
    System.out.print("Ingrese el contenido del documento a inspeccionar: ");
    String contenidoDoc = scanner.nextLine();

    System.out.print("Ingrese el nombre del archivo: ");
    String nombreArchivo = scanner.nextLine();

    InspectorDocumento inspector = new InspectorDocumento(contenidoDoc, nombreArchivo);

    System.out.println("Seleccione una accion:");
    System.out.println("1. Buscar datos ocultos");
    System.out.println("2. Quitar informacion personal");
    System.out.println("3. Limpiar documento");
    System.out.println("4. Generar reporte");
    System.out.print("Opcion: ");
    String opcionInspector = scanner.nextLine();

    switch (opcionInspector) 
    {
        case "1":
            // Buscar datos ocultos dentro del documento (por ejemplo, etiquetas confidenciales o datos sensibles)
            List<String> datosEncontrados = inspector.buscarDatosOculto();
            if (datosEncontrados.isEmpty()) 
            {
                System.out.println("No se encontraron datos ocultos.");
            } else 
            {
                System.out.println("Datos ocultos encontrados:");
                for (String dato : datosEncontrados) {
                    System.out.println("- " + dato);
                }
            }
            break;

        case "2":
            // Eliminar información personal identificable (por ejemplo, número de seguro social)
            boolean eliminado = inspector.quitarInformacionPersona();
            if (eliminado) 
            {
                System.out.println("Informacion personal eliminada del documento.");
            } else 
            {
                System.out.println("No se encontro información personal para eliminar.");
            }
            break;

        case "3":
            // Limpiar completamente el contenido del documento (resetea el texto)
            String archivoLimpio = inspector.limpiarDocumento();
            System.out.println("Documento limpiado. Archivo: " + archivoLimpio);
            break;

        case "4":
            // Generar un reporte de los datos ocultos encontrados en el documento
            inspector.buscarDatosOculto();  // Se asegura de actualizar la lista de datos antes del reporte
            String reporteFinal = inspector.generarReporte();
            System.out.println(reporteFinal);
            break;

        default:
            // Si el usuario escribe una opción incorrecta
            System.out.println("Opcion invalida.");
            break;
    }
    break;
    
    
    case "9":
        // Finaliza la ejecución del programa
    salir = true;
    System.out.println(" Programa finalizado.");
    break;

    default:
    // Captura opciones no reconocidas del menú
    System.out.println(" Opcion invalida. Intente de nuevo.");
    }
       
    }
        
        // Cierra el scanner al salir del programa
        scanner.close();
        
}
}