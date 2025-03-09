package MiniProyecto;

import java.util.Scanner;

public class Sala {
    private int numero;
    private int filasGenerales; 
    private int filasPreferenciales; 
    private int columnas;
    private boolean es3D;
    private boolean tienePreferencial;
    private Funcion[] funciones;
    private Asiento[][] asientosGenerales;
    private Asiento[][] asientosPreferenciales;


    public Sala(int numeroSala, int filasSala, int columnasSala, boolean es3DSala, boolean tienePreferencialSala) {
        numero = numeroSala;
        filasGenerales = filasSala;
        filasPreferenciales = tienePreferencialSala ? 2 : 0; 
        columnas = columnasSala;
        es3D = es3DSala;
        tienePreferencial = tienePreferencialSala;
        funciones = new Funcion[3];
        asientosGenerales = new Asiento[filasGenerales][columnas];
        if (tienePreferencial) {
            asientosPreferenciales = new Asiento[filasPreferenciales][9]; 
        }

        // Inicializar asientos generales (Filas A-F)
        for (int i = 0; i < filasGenerales; i++) {
            for (int j = 0; j < columnas; j++) {
                asientosGenerales[i][j] = new Asiento((char) ('A' + i), j + 1, false); // false porque no son preferenciales aquí
            }
        }

        if (tienePreferencial) {
            for (int i = 0; i < filasPreferenciales; i++) {
                for (int j = 0; j < 9; j++) { // 9 columnas para preferencial
                    asientosPreferenciales[i][j] = new Asiento((char) ('G' + i), j + 1, true); // true porque son preferenciales
                }
            }
        }
    }

    public int getNumero() { return numero; }
    public boolean getEs3D() { return es3D; }
    public Funcion getFuncion(int franja) { return funciones[franja]; }
    public int getFilasGenerales() { return filasGenerales; }
    public int getFilasPreferenciales() { return filasPreferenciales; }
    public int getColumnasGenerales() { return columnas; } 
    public int getColumnasPreferenciales() { return 9; } 


    public void asignarFuncion(Funcion funcion) {
        funciones[funcion.getFranja()] = funcion;
    }


    public Asiento encontrarAsiento(char filaChar, int numeroAsiento) {
        if (filaChar >= 'A' && filaChar <= 'F') { // Sección general
            int filaIndex = filaChar - 'A';
            if (numeroAsiento >= 1 && numeroAsiento <= columnas) {
                return asientosGenerales[filaIndex][numeroAsiento - 1];
            }
        } else if (tienePreferencial && filaChar >= 'G' && filaChar <= 'H') { 
            int filaIndex = filaChar - 'G';
            if (numeroAsiento >= 1 && numeroAsiento <= 9) {
                return asientosPreferenciales[filaIndex][numeroAsiento - 1];
            }
        }
        return null;
    }


    public void mostrarDisponibilidadAsientos() {
        System.out.println("Disponibilidad de asientos:");

        if (tienePreferencial) {
            for (int i = 0; i < filasPreferenciales; i++) {
                System.out.print((char) ('G' + i) + "  ");
                for (int j = 0; j < 9; j++) {
                    System.out.print(asientosPreferenciales[i][j].isOcupado() ? "X " : "_ ");
                }
                System.out.println();
            }
            System.out.println("-----------------------"); 
        }

        for (int i = 0; i < filasGenerales; i++) {
            System.out.print((char) ('A' + i) + "  ");
            for (int j = 0; j < columnas; j++) {
                System.out.print(asientosGenerales[i][j].isOcupado() ? "X " : "_ ");
            }
            System.out.println();
        }
        System.out.println("    --------------------"); 
        System.out.println("       [      Pantalla     ]"); 

    }
}