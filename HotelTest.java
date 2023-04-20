
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    private Hotel hotel;

    @BeforeEach
    void setUp() {
        hotel = new Hotel();
    }

    @Test
    void testInicializarHabitaciones() {
        hotel.inicializarHabitaciones();
        for (int i = 0; i < 10; i++) {
            assertEquals(0, hotel.getEstadoHabitacion(i));
            assertEquals(0, hotel.getComidasHabitacion(i));
            assertEquals(0, hotel.getDiasHabitacion(i));
        }
    }

    @Test
    void testCambiarEstadoHabitacion() {
        hotel.cambiarEstadoHabitacion(5, 1);
        assertEquals(1, hotel.getEstadoHabitacion(5));
    }

    @Test
    void testAsignarComidas() {
        hotel.asignarComidas(3, 1);
        assertEquals(1, hotel.getComidasHabitacion(3));
    }

    @Test
    void testEstablecerDias() {
        hotel.establecerDias(7, 3);
        assertEquals(3, hotel.getDiasHabitacion(7));
    }

    @Test
    void testCalcularTotal() {
        hotel.asignarComidas(0, 1);
        hotel.establecerDias(0, 4);
        int total = hotel.calcularTotal(0);
        assertEquals(160000, total);
    }

    @Test
    void testReservarHabitacion() {
        hotel.reservarHabitacion(2, 0, 5);
        assertEquals(2, hotel.getEstadoHabitacion(2));
        assertEquals(0, hotel.getComidasHabitacion(2));
        assertEquals(5, hotel.getDiasHabitacion(2));
    }

    @Test
    void testOcuparHabitacion() {
        hotel.ocuparHabitacion(4, 1, 3);
        assertEquals(1, hotel.getEstadoHabitacion(4));
        assertEquals(1, hotel.getComidasHabitacion(4));
        assertEquals(3, hotel.getDiasHabitacion(4));
    }

    @Test
    void testLiberarHabitacion() {
        hotel.ocuparHabitacion(6, 0, 2);
        hotel.liberarHabitacion(6);
        assertEquals(0, hotel.getEstadoHabitacion(6));
        assertEquals(0, hotel.getComidasHabitacion(6));
        assertEquals(0, hotel.getDiasHabitacion(6));
    }

    @Test
    void testReiniciarHotel() {
        hotel.ocuparHabitacion(1, 1, 3);
        hotel.reservarHabitacion(2, 0, 5);
        hotel.reiniciarHotel("1234");
        for (int i = 0; i < 10; i++) {
            assertEquals(0, hotel.getEstadoHabitacion(i));
            assertEquals(0, hotel.getComidasHabitacion(i));
            assertEquals(0, hotel.getDiasHabitacion(i));
        }
    }
}
