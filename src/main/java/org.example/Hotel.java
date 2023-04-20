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

    public void consultarEstadoHabitaciones() {
        System.out.println("\nEstado de las habitaciones:");
        for (int i = 0; i < 10; i++) {
            String estado = "";
            switch (habitaciones[i][0]) {
                case 0:
                    estado = "Disponible";
                    break;
                case 1:
                    estado = "Ocupada";
                    break;
                case 2:
                    estado = "Reservada";
                    break;
            }

            String comidas = habitaciones[i][1] == 0 ? "Sin comidas" : "Con comidas";
            int dias = habitaciones[i][2];

            System.out.println("Habitación " + i + ": " + estado + ", " + comidas + ", " + dias + " noches.");
        }
        System.out.println();
    }

    public void reservarHabitacion(int habitacion, int opcionComida, int dias) {
        cambiarEstadoHabitacion(habitacion, 2); // Reservado
        asignarComidas(habitacion, opcionComida);
        establecerDias(habitacion, dias);
        System.out.println("Habitación " + habitacion + " reservada exitosamente.");
    }

    public void ocuparHabitacion(int habitacion, int opcionComida, int dias) {
        cambiarEstadoHabitacion(habitacion, 1); // Ocupado
        asignarComidas(habitacion, opcionComida);
        establecerDias(habitacion, dias);
        System.out.println("Habitación " + habitacion + " ocupada exitosamente.");
    }

    public void liberarHabitacion(int habitacion) {
        int total = calcularTotal(habitacion);
        imprimirBoleta(habitacion, total);
        cambiarEstadoHabitacion(habitacion, 0); // Disponible
        asignarComidas(habitacion, 0); // Sin comidas
        establecerDias(habitacion, 0); // Cero días
        System.out.println("Habitación " + habitacion + " liberada exitosamente.");
    }

    public int calcularTotal(int habitacion) {
        int precioBase = habitaciones[habitacion][1] == 0 ? 30000 : 40000;
        int dias = habitaciones[habitacion][2];
        return precioBase * dias;
    }

    public void imprimirBoleta(int habitacion, int total) {
        System.out.println("\nBoleta de la habitación " + habitacion + ":");
        System.out.println("Cantidad de noches: " + habitaciones[habitacion][2]);
        System.out.println("Total a cancelar: $" + total);
        System.out.println("Gracias por su estadía.\n");
    }

    public void reiniciarHotel() {
        System.out.println("Ingrese la clave para confirmar la operación:");
        String clave = scanner.next();
        if (clave.equals("1234")) {
            inicializarHabitaciones();
            System.out.println("Hotel reiniciado exitosamente.");
        } else {
            System.out.println("Clave incorrecta. Operación cancelada.");
        }
    }

}