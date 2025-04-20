package test.vehiclemanagement;

import main.vehiclemanagement.Motorbike;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotorbikeTest {

    @Test
    void testConstructorAndGetters() {
        Motorbike bike = new Motorbike("MB001", "Honda", 2021, 150);
        assertEquals("MB001", bike.getId());
        assertEquals("Honda", bike.getBrand());
        assertEquals(2021, bike.getYear());
        assertEquals(150, bike.getEnginePower());
    }

    @Test
    void testCalculateTax_Below100cc() {
        Motorbike bike = new Motorbike("MB002", "Yamaha", 2022, 90);
        assertEquals(500.0, bike.calculateTax(), 0.001);
    }

    @Test
    void testCalculateTax_AtOrAbove100cc() {
        Motorbike bike1 = new Motorbike("MB003", "Suzuki", 2020, 100);
        Motorbike bike2 = new Motorbike("MB004", "Kawasaki", 2023, 250);
        assertEquals(1000.0, bike1.calculateTax(), 0.001);
        assertEquals(1000.0, bike2.calculateTax(), 0.001);
    }

    @Test
    void testCompareTo_BasedOnYear() {
        Motorbike bikeOlder = new Motorbike("MB005", "Honda", 2019, 110);
        Motorbike bikeNewer = new Motorbike("MB006", "Honda", 2022, 110);
        Motorbike bikeSameYear = new Motorbike("MB007", "Yamaha", 2019, 125);

        assertTrue(bikeOlder.compareTo(bikeNewer) < 0, "Older bike should come before newer bike");
        assertTrue(bikeNewer.compareTo(bikeOlder) > 0, "Newer bike should come after older bike");
        assertEquals(0, bikeOlder.compareTo(bikeSameYear), "Bikes with the same year should compare as equal");
    }

    @Test
    void testToString() {
        Motorbike bike = new Motorbike("MB001", "Honda", 2021, 150);
        String bikeString = bike.toString();
        assertTrue(bikeString.contains("ID=MB001"));
        assertTrue(bikeString.contains("Brand=Honda"));
        assertTrue(bikeString.contains("Year=2021"));
        assertTrue(bikeString.contains("Engine Power=150"));
    }
}