package MiniProyecto;

public class Asiento {
    private char fila;
    private int numero;
    private boolean ocupado;
    private boolean esPreferencial;

    public Asiento(char filaAsiento, int numeroAsiento, boolean preferencial) {
        fila = filaAsiento;
        numero = numeroAsiento;
        ocupado = false;
        esPreferencial = preferencial;
    }

    public char getFila() { return fila; }
    public int getNumero() { return numero; }
    public boolean isOcupado() { return ocupado; }
    public boolean isPreferencial() { return esPreferencial; }

    public void ocupar() {
        ocupado = true;
    }
}