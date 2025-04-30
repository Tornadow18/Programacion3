
 import java.util.ArrayList;
 import java.util.List;
 
 public class calcularEmisiones {
 
 public static class CalculadoraEmisiones {
        String tipo;
        int totalVehiculos;
        int porcentajeGasolina;
        int porcentajeDiesel;
        int porcentajeGas;

        public CalculadoraEmisiones(String tipox, int totalVehiculosx, int porcentajeGasolinax, int porcentajeDieselx, int porcentajeGasx) {
            tipo = tipox;
            totalVehiculos = totalVehiculosx;
            porcentajeGasolina = porcentajeGasolinax;
            porcentajeDiesel = porcentajeDieselx;
            porcentajeGas = porcentajeGasx;
        }

        public int getVehiculosGasolina() {
            return (int) (totalVehiculos * porcentajeGasolina / 100.0);
        }

        public int getVehiculosDiesel() {
            return (int) (totalVehiculos * porcentajeDiesel / 100.0);
        }

        public int getVehiculosGas() {
            return (int) (totalVehiculos * porcentajeGas / 100.0);
        }
    }

    public static void calcularEmisiones() {

        double emisionesGasolina = 120.0;
        double emisionesDiesel = 140.0;
        double emisionesGas = 100.0;

        List<CalculadoraEmisiones> vehiculos = new ArrayList<>();

        vehiculos.add(new CalculadoraEmisiones("Camiones Livianos", 400000, 30, 40, 30));
        vehiculos.add(new CalculadoraEmisiones("Camiones Medianos", 280000, 25, 50, 25));
        vehiculos.add(new CalculadoraEmisiones("Camiones Pesados", 380000, 10, 80, 10));
        vehiculos.add(new CalculadoraEmisiones("Tractocamiones", 1150000, 5, 90, 5));
        vehiculos.add(new CalculadoraEmisiones("Volquetas", 936000, 40, 40, 20));

        double emisionesTotales = 0.0;
        for (CalculadoraEmisiones vehiculo : vehiculos) {
            int vehiculosGasolina = vehiculo.getVehiculosGasolina();
            int vehiculosDiesel = vehiculo.getVehiculosDiesel();
            int vehiculosGas = vehiculo.getVehiculosGas();

            double emisionesGasolinaTotales = vehiculosGasolina * emisionesGasolina;
            double emisionesDieselTotales = vehiculosDiesel * emisionesDiesel;
            double emisionesGasTotales = vehiculosGas * emisionesGas;

            emisionesTotales += emisionesGasolinaTotales + emisionesDieselTotales + emisionesGasTotales;

            System.out.println("Tipo de Vehiculo: " + vehiculo.tipo);
            System.out.println("  Vehiculos Gasolina: " + vehiculosGasolina + " | Emisiones: " + emisionesGasolinaTotales + " g/km");
            System.out.println("  Vehiculos Diesel: " + vehiculosDiesel + " | Emisiones: " + emisionesDieselTotales + " g/km");
            System.out.println("  Vehiculos Gas: " + vehiculosGas + " | Emisiones: " + emisionesGasTotales + " g/km");
            System.out.println();
        }

        System.out.println("Emisiones totales de C02: " + emisionesTotales + " g/km");
    }

    public static void main(String[] args) {
        calcularEmisiones();
    }
}
