// NextDayCalculatorTest.java
package DayCal; // Phải cùng package hoặc import lớp NextDayCalculator


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NextDayCalculatorTest {

    @Test
    @DisplayName("Test ngày 1/1/2018")
    void testDay1Month1Year2018() {
        int day = 1;
        int month = 1;
        int year = 2018;
        int[] expected = {2, 1, 2018}; // Ngày mong đợi: 2/1/2018
        int[] result = com.example.nextday.NextDayCalculator.calculateNextDay(day, month, year);
        assertArrayEquals(expected, result, "Lỗi: Ngày 1/1/2018 sai");
    }

    @Test
    @DisplayName("Test ngày 31/1/2018")
    void testDay31Month1Year2018() {
        int day = 31;
        int month = 1;
        int year = 2018;
        int[] expected = {1, 2, 2018}; // Ngày mong đợi: 1/2/2018
        int[] result = com.example.nextday.NextDayCalculator.calculateNextDay(day, month, year);
        assertArrayEquals(expected, result, "Lỗi: Ngày 31/1/2018 sai");
    }

    @Test
    @DisplayName("Test ngày 30/4/2018")
    void testDay30Month4Year2018() {
        int day = 30;
        int month = 4;
        int year = 2018;
        int[] expected = {1, 5, 2018}; // Ngày mong đợi: 1/5/2018
        int[] result = com.example.nextday.NextDayCalculator.calculateNextDay(day, month, year);
        assertArrayEquals(expected, result, "Lỗi: Ngày 30/4/2018 sai");
    }

    @Test
    @DisplayName("Test ngày 28/2/2018 - Năm không nhuận")
    void testDay28Month2Year2018() {
        int day = 28;
        int month = 2;
        int year = 2018;
        int[] expected = {1, 3, 2018}; // Ngày mong đợi: 1/3/2018
        int[] result = com.example.nextday.NextDayCalculator.calculateNextDay(day, month, year);
        assertArrayEquals(expected, result, "Lỗi: Ngày 28/2/2018 sai");
    }

    @Test
    @DisplayName("Test ngày 29/2/2020 - Năm nhuận")
    void testDay29Month2Year2020() {
        int day = 29;
        int month = 2;
        int year = 2020;
        int[] expected = {1, 3, 2020}; // Ngày mong đợi: 1/3/2020
        int[] result = com.example.nextday.NextDayCalculator.calculateNextDay(day, month, year);
        assertArrayEquals(expected, result, "Lỗi: Ngày 29/2/2020 sai");
    }

    @Test
    @DisplayName("Test ngày 31/12/2018")
    void testDay31Month12Year2018() {
        int day = 31;
        int month = 12;
        int year = 2018;
        int[] expected = {1, 1, 2019}; // Ngày mong đợi: 1/1/2019
        int[] result = com.example.nextday.NextDayCalculator.calculateNextDay(day, month, year);
        assertArrayEquals(expected, result, "Lỗi: Ngày 31/12/2018 sai");
    }

    // (Optional) Test case bổ sung cho ngày 28/2 năm nhuận
    @Test
    @DisplayName("Test ngày 28/2/2020 - Năm nhuận")
    void testDay28Month2Year2020() {
        int day = 28;
        int month = 2;
        int year = 2020;
        int[] expected = {29, 2, 2020}; // Ngày mong đợi: 29/2/2020
        int[] result = com.example.nextday.NextDayCalculator.calculateNextDay(day, month, year);
        assertArrayEquals(expected, result, "Lỗi: Ngày 28/2/2020 sai");
    }
}