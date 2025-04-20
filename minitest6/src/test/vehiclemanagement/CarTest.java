package test.vehiclemanagement;

import vehiclemanagement.Car;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testConstructorAndGetters() {
        Car car = new Car("C001", "Toyota", 2020, 5);
        assertEquals("C001", car.getId());
        assertEquals("Toyota", car.getBrand());
        assertEquals(2020, car.getYear());
        assertEquals(5, car.getNumberOfSeats());
    }

    @Test
    void testCalculateTax() {
        Car car4Seats = new Car("C002", "Hyundai", 2021, 4);
        Car car7Seats = new Car("C003", "Ford", 2019, 7);
        assertEquals(4 * 300.0, car4Seats.calculateTax(), 0.001); // 1200.0
        assertEquals(7 * 300.0, car7Seats.calculateTax(), 0.001); // 2100.0
    }

    @Test
    void testCompareTo_BasedOnYear() {
        Car carOlder = new Car("C004", "Toyota", 2018, 5);
        Car carNewer = new Car("C005", "Toyota", 2023, 5);
        Car carSameYear = new Car("C006", "Honda", 2018, 4);

        assertTrue(carOlder.compareTo(carNewer) < 0, "Older car should come before newer car");
        assertTrue(carNewer.compareTo(carOlder) > 0, "Newer car should come after older car");
        assertEquals(0, carOlder.compareTo(carSameYear), "Cars with the same year should compare as equal");
    }

    @Test
    void testToString() {
        Car car = new Car("C001", "Toyota", 2020, 5);
        String carString = car.toString();
        assertTrue(carString.contains("ID=C001"));
        assertTrue(carString.contains("Brand=Toyota"));
        assertTrue(carString.contains("Year=2020"));
        assertTrue(carString.contains("Seats=5"));
    }
}