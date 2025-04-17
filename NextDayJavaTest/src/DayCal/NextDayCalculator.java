// NextDayCalculator.java
package com.example.nextday; // Thay đổi package nếu cần

public class NextDayCalculator {

    // Hàm chính để tính ngày tiếp theo
    public static int[] calculateNextDay(int day, int month, int year) {
        // Kiểm tra tính hợp lệ cơ bản của ngày tháng năm (có thể thêm nếu muốn chặt chẽ hơn)
        if (month < 1 || month > 12 || day < 1 || day > getDaysInMonth(month, year) || year <= 0) {
            // Có thể ném ra một ngoại lệ (Exception) ở đây để báo lỗi đầu vào không hợp lệ
            // Ví dụ: throw new IllegalArgumentException("Ngày tháng năm không hợp lệ");
            // Hoặc trả về một giá trị đặc biệt như null hoặc mảng rỗng, tùy yêu cầu
            System.err.println("Cảnh báo: Ngày tháng năm đầu vào không hợp lệ: " + day + "/" + month + "/" + year);
            // Tạm thời trả về chính nó nếu không hợp lệ để tránh lỗi NullPointerException khi test
            return new int[]{day, month, year};
        }

        int daysInMonth = getDaysInMonth(month, year);
        int nextDay = day;
        int nextMonth = month;
        int nextYear = year;

        if (day < daysInMonth) {
            // Trường hợp ngày chưa phải cuối tháng
            nextDay++;
        } else {
            // Trường hợp ngày là cuối tháng
            nextDay = 1;
            if (month < 12) {
                // Trường hợp tháng chưa phải cuối năm
                nextMonth++;
            } else {
                // Trường hợp tháng là cuối năm (tháng 12)
                nextMonth = 1;
                nextYear++;
            }
        }

        return new int[]{nextDay, nextMonth, nextYear};
    }

    // Hàm phụ trợ: Lấy số ngày trong một tháng cụ thể của một năm
    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: // Tháng 1
            case 3: // Tháng 3
            case 5: // Tháng 5
            case 7: // Tháng 7
            case 8: // Tháng 8
            case 10: // Tháng 10
            case 12: // Tháng 12
                return 31;
            case 4: // Tháng 4
            case 6: // Tháng 6
            case 9: // Tháng 9
            case 11: // Tháng 11
                return 30;
            case 2: // Tháng 2
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0; // Tháng không hợp lệ
        }
    }

    // Hàm phụ trợ: Kiểm tra năm nhuận
    private static boolean isLeapYear(int year) {
        boolean isDivisibleBy4 = year % 4 == 0;
        boolean isDivisibleBy100 = year % 100 == 0;
        boolean isDivisibleBy400 = year % 400 == 0;

        // Năm nhuận là năm chia hết cho 4 nhưng không chia hết cho 100
        // HOẶC là năm chia hết cho 400
        return (isDivisibleBy4 && !isDivisibleBy100) || isDivisibleBy400;
    }

    // (Optional) Hàm main để chạy thử nhanh nếu không dùng JUnit ngay
    public static void main(String[] args) {
        int[] nextDate = calculateNextDay(31, 12, 2018);
        System.out.println("Ngày tiếp theo là: " + nextDate[0] + "/" + nextDate[1] + "/" + nextDate[2]); // Kết quả: 1/1/2019

        nextDate = calculateNextDay(28, 2, 2020); // Năm nhuận
        System.out.println("Ngày tiếp theo là: " + nextDate[0] + "/" + nextDate[1] + "/" + nextDate[2]); // Kết quả: 29/2/2020

        nextDate = calculateNextDay(29, 2, 2020); // Năm nhuận
        System.out.println("Ngày tiếp theo là: " + nextDate[0] + "/" + nextDate[1] + "/" + nextDate[2]); // Kết quả: 1/3/2020

        nextDate = calculateNextDay(28, 2, 2019); // Năm không nhuận
        System.out.println("Ngày tiếp theo là: " + nextDate[0] + "/" + nextDate[1] + "/" + nextDate[2]); // Kết quả: 1/3/2019
    }
}