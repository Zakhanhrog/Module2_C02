import java.util.Stack;
import java.util.Scanner;

public class Main2 {

    public static String convertDecimalToBinary(int decimalNumber) {
        if (decimalNumber < 0) {
            return "Lỗi vì chỉ hỗ trợ số nguyên không âm";
        }
        if (decimalNumber == 0) {
            return "0";
        }
        Stack<Integer> remainderStack = new Stack<Integer>();
        int tempNumber = decimalNumber;
        while (tempNumber > 0) {
            int remainder = tempNumber % 2;
            remainderStack.push(remainder);
            tempNumber = tempNumber / 2;
        }
        String binaryString = "";
        while (!remainderStack.isEmpty()) {
            binaryString = binaryString + remainderStack.pop();
        }
        return binaryString;
    }

    public static int convertBinaryToDecimal(String binaryString) {
        if (binaryString == null || binaryString.isEmpty()) {
            System.err.println("Lỗi: Chuỗi nhị phân không được rỗng.");
            return -1;
        }
        int decimalValue = 0;
        int powerOf2 = 1;

        for (int i = binaryString.length() - 1; i >= 0; i--) {
            char bit = binaryString.charAt(i);

            if (bit == '1') {
                decimalValue = decimalValue + powerOf2;
            } else if (bit != '0') {
                System.err.println("Lỗi: Chuỗi nhị phân chứa ký tự không hợp lệ: '" + bit + "' tại vị trí " + (binaryString.length() - 1 - i) + " từ phải sang.");
                return -1;
            }
            powerOf2 = powerOf2 * 2;
        }
        return decimalValue;
    }

        public static String convertDecimalToHex(int decimalNumber) {
            if (decimalNumber < 0) {
                return "Lỗi: Chỉ hỗ trợ số nguyên không âm.";
            }
            if (decimalNumber == 0) {
                return "0";
            }

            char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            Stack<Character> remainderStack = new Stack<>();

            int tempNumber = decimalNumber;
            while (tempNumber > 0) {
                int remainder = tempNumber % 16;
                remainderStack.push(hexChars[remainder]);
                tempNumber = tempNumber / 16;
            }

//            StringBuilder hexString = new StringBuilder();
//            while (!remainderStack.isEmpty()) {
//                hexString.append(remainderStack.pop());
//            }
            String hexString = "";
            while (!remainderStack.isEmpty()) {
                hexString += remainderStack.pop();
            }

            return hexString.toString();
        }

        public static int convertHexToDecimal(String hexString) {
            if (hexString == null || hexString.isEmpty()) {
                System.err.println("Lỗi: Chuỗi hex không được rỗng.");
                return -1;
            }

            String upperHexString = hexString.toUpperCase();

            int decimalValue = 0;
            int powerOf16 = 1;

            for (int i = upperHexString.length() - 1; i >= 0; i--) {
                char hexChar = upperHexString.charAt(i);
                int digitValue;

                if (hexChar >= '0' && hexChar <= '9') {
                    digitValue = hexChar - '0';
                } else if (hexChar >= 'A' && hexChar <= 'F') {
                    digitValue = 10 + (hexChar - 'A');
                } else {
                    System.err.println("Lỗi: Chuỗi hex chứa ký tự không hợp lệ: '" + hexChar + "'");
                    return -1;
                }

                decimalValue = decimalValue + digitValue * powerOf16;
                powerOf16 = powerOf16 * 16;
            }

            return decimalValue;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Chuyển đổi Thập phân sang Nhị phân");
            System.out.print("Nhập số thập phân (số nguyên không âm): ");
            int inputDecimal = scanner.nextInt();

            String binaryResult = convertDecimalToBinary(inputDecimal);
            if (binaryResult.startsWith("Lỗi:")) {
                System.out.println(binaryResult);
            } else {
                System.out.println("Số thập phân " + inputDecimal + " là " + binaryResult + " trong hệ nhị phân.");
            }
            System.out.println();
            System.out.print("Nhập số nhị phân: ");
            String inputBinary = scanner.next();

            int decimalResult = convertBinaryToDecimal(inputBinary);
            if (decimalResult != -1) {
                System.out.println("Số nhị phân " + inputBinary + " là " + decimalResult + " trong hệ thập phân.");
            }

            System.out.println();
            System.out.print("Nhập số thâp phân: ");
            int inputDecimal2 = scanner.nextInt();

            String hexResult = convertDecimalToHex(inputDecimal2);
            if (hexResult.startsWith("Loi: ")){
                System.out.println(hexResult);
            }else {
                System.out.println("So thap phan " + inputDecimal2 + " la "+ hexResult +" trong he 16. ");
            }

            System.out.println();
            System.out.print("Nhập số nhị phân: ");
            String inputHex = scanner.next();

            int decimalResult2 = convertHexToDecimal(inputHex);
            if (decimalResult2 != -1) {
                System.out.println("Số he 16 " + inputHex + " là " + decimalResult2 + " trong hệ thập phân.");
            }




        }
    }
