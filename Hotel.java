import java.util.Scanner;

public class Hotel {
    private int[][] habitaciones;
    private Scanner scanner;

    public static void main(String[] args) {
        ejecutarMain(args);
    }

    public static void ejecutarMain(String[] args) {
        Hotel hotel = new Hotel();
        int opcion = 0;

        while (opcion != 6) {
            hotel.mostrarMenu();
            System.out.println("Seleccione una opción:");
            opcion = hotel.scanner.nextInt();
            hotel.ejecutarAccion(opcion);
        }
    }

    public Hotel() {
        habitaciones = new int[10][3];
        scanner = new Scanner(System.in);
        inicializarHabitaciones();
    }

    public void inicializarHabitaciones() {
        for (int i = 0; i < 10; i++) {
            habitaciones[i][0] = 0; // Estado: Disponible
            habitaciones[i][1] = 0; // Sin comidas
            habitaciones[i][2] = 0; // Cero días
        }
    }

    public void cambiarEstadoHabitacion(int habitacion, int estado) {
        habitaciones[habitacion][0] = estado;
    }

    public void asignarComidas(int habitacion, int opcionComida) {
        habitaciones[habitacion][1] = opcionComida;
    }

    public void establecerDias(int habitacion, int dias) {
        habitaciones[habitacion][2] = dias;
    }

    public void mostrarMenu() {
        System.out.println("1. Consultar estado de habitaciones");
        System.out.println("2. Reservar habitación");
        System.out.println("3. Ocupar habitación");
        System.out.println("4. Liberar habitación");
        System.out.println("5. Reiniciar hotel");
        System.out.println("6. Salir");
    }

    public void ejecutarAccion(int opcion) {
        int habitacion, estado, opcionComida, dias;
        switch (opcion) {
            case 1:
                consultarEstadoHabitaciones();
                break;
            case 2:
                System.out.println("Ingrese el número de habitación a reservar (0-9):");
                habitacion = scanner.nextInt();
                System.out.println("Seleccione el tipo de reserva (0: Sin comidas, 1: Con comidas):");
                opcionComida = scanner.nextInt();
                System.out.println("Ingrese la cantidad de días:");
                dias = scanner.nextInt();
                reservarHabitacion(habitacion, opcionComida, dias);
                break;
            case 3:
                System.out.println("Ingrese el número de habitación a ocupar (0-9):");
                habitacion = scanner.nextInt();
                System.out.println("Seleccione el tipo de ocupación (0: Sin comidas, 1: Con comidas):");
                opcionComida = scanner.nextInt();
                System.out.println("Ingrese la cantidad de días:");
                dias = scanner.nextInt();
                ocuparHabitacion(habitacion, opcionComida, dias);
                break;
            case 4:
                System.out.println("Ingrese el número de habitación a liberar (0-9):");
                habitacion = scanner.nextInt();
                liberarHabitacion(habitacion);
                break;
            case 5:
                reiniciarHotel();
                break;
            case 6:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
    }
}