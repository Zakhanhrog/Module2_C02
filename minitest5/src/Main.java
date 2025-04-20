
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size ;
        System.out.print("Nhap so luong material (co san 4 material): ");
        size = scanner.nextInt();   // nhap so luong material
        System.out.println("So luong material cho phep nhap vao la: "+size);
        MaterialManager manager = new MaterialManager(size);

        manager.addMaterial(new CrispyFlour("F001", "Bột chiên A", LocalDate.now().minusYears(1).plusMonths(1).plusDays(15), 15000, 5)); // ~1.5 tháng
        manager.addMaterial(new CrispyFlour("F002", "Bột chiên B", LocalDate.now().minusYears(1).plusMonths(3).plusDays(20), 12000, 10)); // ~3.5 tháng
        manager.addMaterial(new Meat("M001", "Thịt Ba Chỉ", LocalDate.now().minusDays(3), 150000, 1.5)); // Còn 4 ngày
        manager.addMaterial(new Meat("M002", "Thịt Bò Thăn", LocalDate.now().minusDays(8), 250000, 0.8)); // Đã hết hạn (-1 ngày)
        manager.displayAllMaterials();

        int choice;
        int choiceType;
        do{
            System.out.println("MENU QUAN LI MATERIAL");
            System.out.println("1. Them Material");
            System.out.println("2. Xoa Material");
            System.out.println("3. Sua Material");
            System.out.println("4. Tinh tien chenh lech");
            System.out.println("0. Out");
            System.out.print("Nhap lua chon tuy chinh cua ban: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1. CrispyFlour");
                    System.out.println("2. Meat");
                    System.out.println("Lua chon loai san pham muon them: ");
                    choiceType = scanner.nextInt();
                    switch (choiceType) {
                        case 1:
                            addCrispyFlour(manager);
                            manager.displayAllMaterials();
                            break;
                        case 2:
                            addMeat(manager);
                            manager.displayAllMaterials();
                            break;
                    }
                    break;
                case 2:
                    deleteMaterial(manager);
                    manager.displayAllMaterials();
                    break;
                case 3:
                    System.out.println("1. CrispyFlour");
                    System.out.println("2. Meat");
                    System.out.println("Lua chon loai san pham muon sua: ");
                    choiceType = scanner.nextInt();
                    switch (choiceType) {
                        case 1:
                            editCrispyFlour(manager);
                            break;
                        case 2:
                            editMeat(manager);
                            break;
                    }
                    break;
                case 4:
                    calculateAmount(manager);
                    break;
                case 0:
                    System.exit(0);
            }
        }while (choice >= 0);
    }

    public static void addMeat(MaterialManager manager) {
        Scanner scanner = new Scanner(System.in);
        int cost;
        String id;
        int dayToSubtract;
        double weight;
        String name;

        System.out.println("ID: ");
        id = scanner.nextLine();

        System.out.println("Name: ");
        name = scanner.nextLine();

        System.out.println("dayToSubtract: ");
        dayToSubtract = scanner.nextInt();

        System.out.println("Cost: ");
        cost = scanner.nextInt();

        System.out.println("Weight: ");
        weight = scanner.nextDouble();

        manager.addMaterial(new Meat(id,name, LocalDate.now().minusDays(dayToSubtract), cost, weight));
        manager.displayAllMaterials();
    }

    public static void addCrispyFlour(MaterialManager manager) {
        Scanner scanner = new Scanner(System.in);
        int cost;
        String id;
        int yearToSubtract = 1;
        int quantity;
        int daysToAdd;
        int monthsToAdd;
        String name;

        System.out.println("ID: ");
        id = scanner.nextLine();

        System.out.println("Name: ");
        name = scanner.nextLine();

        System.out.println("MonthsToAdd: ");
        monthsToAdd = scanner.nextInt();

        System.out.println("DaysToAdd: ");
        daysToAdd = scanner.nextInt();

        System.out.println("Cost: ");
        cost = scanner.nextInt();

        System.out.println("Quantity: ");
        quantity = scanner.nextInt();

        manager.addMaterial(new CrispyFlour(id,name, LocalDate.now().minusYears(yearToSubtract).plusMonths(monthsToAdd).plusDays(daysToAdd), cost, quantity));
        manager.displayAllMaterials();
    }

    public static void deleteMaterial(MaterialManager manager) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("ID muon xoa: ");
        String id = scanner.nextLine();
        manager.deleteMaterial(id);
        manager.displayAllMaterials();
    }
    public static void editCrispyFlour(MaterialManager manager) {
        Scanner scanner = new Scanner(System.in);
        int cost;
        String id;
        int yearToSubtract = 1;
        int quantity;
        int daysToAdd;
        int monthsToAdd;
        String name;

        System.out.println("Nhap ID muon sua: ");
        id = scanner.nextLine();

        System.out.println("Name (new): ");
        name = scanner.nextLine();

        System.out.println("MonthsToAdd (new): ");
        monthsToAdd = scanner.nextInt();

        System.out.println("DaysToAdd (new) ");
        daysToAdd = scanner.nextInt();

        System.out.println("Cost (new): ");
        cost = scanner.nextInt();

        System.out.println("Quantity (new): ");
        quantity = scanner.nextInt();

        CrispyFlour updatedFlour = new CrispyFlour(id,name, LocalDate.now().minusYears(yearToSubtract).plusMonths(monthsToAdd).plusDays(daysToAdd), cost, quantity);
        manager.editMaterial(id, updatedFlour);
        manager.displayAllMaterials();

    }

    public static void editMeat(MaterialManager manager) {
        Scanner scanner = new Scanner(System.in);
        int cost;
        String id;
        int dayToSubtract;
        double weight;
        String name;

        System.out.println("Nhap ID muon sua: ");
        id = scanner.nextLine();

        System.out.println("Name: ");
        name = scanner.nextLine();

        System.out.println("dayToSubtract: ");
        dayToSubtract = scanner.nextInt();

        System.out.println("Cost: ");
        cost = scanner.nextInt();

        System.out.println("Weight: ");
        weight = scanner.nextDouble();

        Meat updatedMeat = new Meat(id,name, LocalDate.now().minusDays(dayToSubtract), cost, weight);
        manager.editMaterial(id, updatedMeat);
        manager.displayAllMaterials();
    }

    public static void calculateAmount(MaterialManager manager) {
        double totalAmount = manager.calculateTotalAmount();
        double totalRealMoney = manager.calculateTotalRealMoney();
        double difference = manager.calculateDifference();
        System.out.printf("So tien ban dau chua chiet khau: %.2f VND%n", totalAmount);
        System.out.printf("So tien sau khi chiet khau: %.2f VND", totalRealMoney);
        System.out.println("So tien chenh lech: " + difference);
        manager.displayAllMaterials();
    }

}