package test.vehiclemanagement;

import main.vehiclemanagement.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

class ComparatorsTest {

    private Vehicle carToyota;
    private Vehicle carHonda;
    private Vehicle bikeYamahaLowTax;
    private Vehicle bikeHondaHighTax;
    private Vehicle carHondaSameBrand; // Để test case-insensitivity

    @BeforeEach
    void setUp() {
        // Thuế: 5 * 300 = 1500
        carToyota = new Car("C01", "Toyota", 2020, 5);
        // Thuế: 4 * 300 = 1200
        carHonda = new Car("C02", "Honda", 2021, 4);
        // Thuế: 500 (90cc)
        bikeYamahaLowTax = new Motorbike("M01", "Yamaha", 2019, 90);
        // Thuế: 1000 (150cc)
        bikeHondaHighTax = new Motorbike("M02", "Honda", 2022, 150);
        // Thuế: 1200
        carHondaSameBrand = new Car("C03", "honda", 2018, 4); // Brand viết thường
    }

    @Test
    void testBrandComparator() {
        Comparator<Vehicle> brandComparator = new VehicleBrandComparator();

        // Honda vs Toyota suy ra  Honda < Toyota
        assertTrue(brandComparator.compare(carHonda, carToyota) < 0);
        // Toyota vs Honda suyra Toyota > Honda
        assertTrue(brandComparator.compare(carToyota, carHonda) > 0);
        // Honda vs Yamaha suyra Honda < Yamaha
        assertTrue(brandComparator.compare(carHonda, bikeYamahaLowTax) < 0);
        // Honda vs Honda (case-insensitive) -> Equal
        assertEquals(0, brandComparator.compare(carHonda, bikeHondaHighTax));
        // Honda vs honda (case-insensitive) -> Equal
        assertEquals(0, brandComparator.compare(carHonda, carHondaSameBrand));
    }

    @Test
    void testTaxComparator() {
        Comparator<Vehicle> taxComparator = new VehicleTaxComparator();

        // Yamaha (500) vs Honda Bike (1000) suyra Yamaha < Honda Bike
        assertTrue(taxComparator.compare(bikeYamahaLowTax, bikeHondaHighTax) < 0);
        // Honda Bike (1000) vs Honda Car (1200) suyra Honda Bike < Honda Car
        assertTrue(taxComparator.compare(bikeHondaHighTax, carHonda) < 0);
        // Honda Car (1200) vs Toyota Car (1500) suyra Honda Car < Toyota Car
        assertTrue(taxComparator.compare(carHonda, carToyota) < 0);
        // Toyota Car (1500) vs Yamaha Bike (500) suyra Toyota Car > Yamaha Bike
        assertTrue(taxComparator.compare(carToyota, bikeYamahaLowTax) > 0);
        // Honda Car (1200) vs Honda Car Same Brand (1200) suyra Equal
        assertEquals(0, taxComparator.compare(carHonda, carHondaSameBrand));
    }
}