import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNumberPhone {

    private static final String PHONE_NUMBER_REGEX = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";

    private static final Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] validPhoneNumbers = {
                "(84)-(0978489648)",
                "(01)-(0123456789)",
                "(99)-(0555555555)"
        };

        String[] invalidPhoneNumbers = {
                "(a8)-(0978489648)",
                "(84)-(22b22222)",
                "(84)-(9978489648)",
                "84)-(0978489648)",
                "(84-(0978489648)",
                "(84)-(097848964)",
                "(84)-(09784896489)",
                "(841)-(0978489648)",
                "(8)-(0978489648)",
                "(84)-0978489648",
                "(84) (0978489648)",
                ""
        };

        System.out.println("--- Kiểm tra các số điện thoại hợp lệ ---");
        for (String number : validPhoneNumbers) {
            boolean isValid = isValidPhoneNumber(number);
            System.out.printf("Số điện thoại '%s' có hợp lệ không? %b%n", number, isValid);
        }

        System.out.println("\n--- Kiểm tra các số điện thoại KHÔNG hợp lệ ---");
        for (String number : invalidPhoneNumbers) {
            boolean isValid = isValidPhoneNumber(number);
            System.out.printf("Số điện thoại '%s' có hợp lệ không? %b%n", number, isValid);
        }
    }
}