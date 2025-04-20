package test.vehiclemanagement;

import main.vehiclemanagement.Car;
import main.vehiclemanagement.Motorbike;
import main.vehiclemanagement.Vehicle;
import main.vehiclemanagement.VehicleManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class VehicleManagerTest {

    private VehicleManager manager;
    private Vehicle car1;
    private Vehicle bike1;
    private Vehicle car2_DupId;
    private Vehicle bike2_DiffYear;

    @BeforeEach
    void setUp() {
        manager = new VehicleManager(); // Tạo mới manager cho mỗi test
        car1 = new Car("V001", "Toyota", 2020, 5); // Tax = 1500
        bike1 = new Motorbike("V002", "Honda", 2021, 150); // Tax = 1000
        car2_DupId = new Car("v001", "BMW", 2022, 4); // ID trùng car1, Tax = 1200
        bike2_DiffYear = new Motorbike("V003", "Yamaha", 2019, 90); // Tax = 500
    }

    @Test
    void testAddVehicle_Success() {
        manager.addVehicle(car1);
        manager.addVehicle(bike1);
        List<Vehicle> vehicles = manager.getVehicles();
        assertEquals(2, vehicles.size());
        assertTrue(vehicles.contains(car1));
        assertTrue(vehicles.contains(bike1));

        List<String> history = manager.getHistory();
        assertTrue(history.get(0).contains("Added vehicle: Car [ID=V001"));
        assertTrue(history.get(1).contains("Added vehicle: Motorbike [ID=V002"));
    }

    @Test
    void testAddVehicle_DuplicateId_CaseInsensitive() {
        manager.addVehicle(car1); // thêm thành công
        manager.addVehicle(car2_DupId); // thử thêm xe có ID trùng (khác case)

        List<Vehicle> vehicles = manager.getVehicles();
        assertEquals(1, vehicles.size(), "Should not add vehicle with duplicate ID");
        assertTrue(vehicles.contains(car1)); // xe gốc vẫn còn
        assertFalse(vehicles.contains(car2_DupId)); // xe trùng ID không được thêm

        // Kiểm tra log history
        List<String> history = manager.getHistory();
        assertEquals(2, history.size()); // 1 add thành công, 1 attempt thất bại
        assertTrue(history.get(0).contains("Added vehicle: Car [ID=V001"));
        assertTrue(history.get(1).contains("Attempted to add duplicate vehicle ID: v001"));
    }

    @Test
    void testRemoveVehicle_Exists_CaseInsensitive() {
        manager.addVehicle(car1);
        manager.addVehicle(bike1);
        assertEquals(2, manager.getVehicles().size());

        manager.removeVehicle("v001"); // xóa bằng ID khác case

        List<Vehicle> vehicles = manager.getVehicles();
        assertEquals(1, vehicles.size(), "Vehicle should be removed");
        assertFalse(vehicles.contains(car1));
        assertTrue(vehicles.contains(bike1));

        // kiểm tra xem log history
        List<String> history = manager.getHistory();
        // 2 adds + 1 remove
        assertTrue(history.get(history.size() - 1).contains("Removed vehicle: Car [ID=V001"));
    }

    @Test
    void testRemoveVehicle_NotExists() {
        manager.addVehicle(car1);
        assertEquals(1, manager.getVehicles().size());

        manager.removeVehicle("NONEXISTENT_ID");

        assertEquals(1, manager.getVehicles().size(), "List size should not change");
        assertTrue(manager.getVehicles().contains(car1));

        // kiểm tra log history
        List<String> history = manager.getHistory();
        // 1 add + 1 attempt remove
        assertTrue(history.get(history.size() - 1).contains("Attempted to remove non-existent vehicle ID: NONEXISTENT_ID"));
    }

    @Test
    void testSortByYear() {
        manager.addVehicle(car1); // 2020
        manager.addVehicle(bike1); // 2021
        manager.addVehicle(bike2_DiffYear); // 2019

        manager.sortByYear();
        List<Vehicle> sortedVehicles = manager.getVehicles();

        assertEquals(bike2_DiffYear, sortedVehicles.get(0)); // 2019
        assertEquals(car1, sortedVehicles.get(1));          // 2020
        assertEquals(bike1, sortedVehicles.get(2));          // 2021

        // kiểm tra log
        assertTrue(manager.getHistory().get(manager.getHistory().size() -1).contains("Sorted vehicles by year"));
    }

    @Test
    void testSortByBrand() {
        manager.addVehicle(car1); // Toyota
        manager.addVehicle(bike1); // Honda
        manager.addVehicle(bike2_DiffYear); // Yamaha

        manager.sortByBrand();
        List<Vehicle> sortedVehicles = manager.getVehicles();

        assertEquals(bike1, sortedVehicles.get(0));          // Honda
        assertEquals(car1, sortedVehicles.get(1));          // Toyota
        assertEquals(bike2_DiffYear, sortedVehicles.get(2)); // Yamaha

        // Kiểm tra log
        assertTrue(manager.getHistory().get(manager.getHistory().size() -1).contains("Sorted vehicles by brand"));
    }

    @Test
    void testSortByTax() {
        manager.addVehicle(car1); // Tax = 1500
        manager.addVehicle(bike1); // Tax = 1000
        manager.addVehicle(bike2_DiffYear); // Tax = 500

        manager.sortByTax();
        List<Vehicle> sortedVehicles = manager.getVehicles();

        assertEquals(bike2_DiffYear, sortedVehicles.get(0)); // 500
        assertEquals(bike1, sortedVehicles.get(1));          // 1000
        assertEquals(car1, sortedVehicles.get(2));          // 1500

        // Kiểm tra log
        assertTrue(manager.getHistory().get(manager.getHistory().size() -1).contains("Sorted vehicles by tax"));
    }

    @Test
    void testDisplayAllVehicles_RunsWithoutError() {
        manager.addVehicle(car1);
        assertDoesNotThrow(() -> manager.displayAllVehicles());
        assertTrue(manager.getHistory().get(manager.getHistory().size() -1).contains("Displayed all vehicles"));
    }

    @Test
    void testDisplayTaxReport_RunsWithoutError() {
        manager.addVehicle(bike1);
        assertDoesNotThrow(() -> manager.displayTaxReport());// check khong nem lai exception
        assertTrue(manager.getHistory().get(manager.getHistory().size() -1).contains("Displayed tax report"));
    }

    @Test
    void testPrintHistory_RunsWithoutError() {
        manager.addVehicle(car1);
        manager.removeVehicle(car1.getId());
        assertDoesNotThrow(() -> manager.printHistory());
        assertTrue(manager.getHistory().get(manager.getHistory().size() -1).contains("Viewed action history"));
    }
}