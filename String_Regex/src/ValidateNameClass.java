import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNameClass {

    private static final String CLASS_NAME_REGEX = "^[CAP]\\d{4}[GHIK]$";

    private static final Pattern pattern = Pattern.compile(CLASS_NAME_REGEX);

    public static boolean isValidClassName(String className) {
        if (className == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(className);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] validClassNames = {"C0223G", "A0323K", "P1234H", "C9999I"};
        String[] invalidClassNames = {
                "M0318G",
                "P0323A",
                "C0223X",
                "C022G",
                "C02233G",
                "c0223g",
                "C02!3G",
                "C0223 G",
                ""
        };

        System.out.println("--- Kiểm tra các tên lớp hợp lệ ---");
        for (String name : validClassNames) {
            boolean isValid = isValidClassName(name);
            System.out.printf("Tên lớp '%s' có hợp lệ không? %b%n", name, isValid);
        }

        System.out.println("\n--- Kiểm tra các tên lớp KHÔNG hợp lệ ---");
        for (String name : invalidClassNames) {
            boolean isValid = isValidClassName(name);
            System.out.printf("Tên lớp '%s' có hợp lệ không? %b%n", name, isValid);
        }
    }
}