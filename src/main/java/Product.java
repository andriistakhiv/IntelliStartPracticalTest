import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product {
    private static int counter;
    private final int id;
    private final String name;
    private final double price;
    private final Scanner scanner = new Scanner(System.in);
    private List<User> archive = new ArrayList<>();

    public Product() {
        counter++;
        id = counter;
        name = setName();
        price = setPrice();

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public List<User> getArchive() {
        return archive;
    }

    public void addToArchive(User user) {
        archive.add(user);
    }

    private String setName() {
        while (true) {
            System.out.println("Enter product name: ");
            String str = scanner.nextLine();
            if (str == null || str.equals("")) {
                System.out.println("Try again!");
            } else {
                return str;
            }
        }
    }

    private double setPrice() {
        while (true) {
            System.out.println("Enter the price of the product:");
            String amount = scanner.nextLine();
            if (isNumeric(amount)) {
                return Double.parseDouble(amount);
            } else {
                System.out.println("Try again!");
            }
        }
    }

    private boolean isNumeric(String string) {
        if (string == null || string.equals("")) {
            return false;
        }
        try {
            double i = Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return id + "\t | \t" + name + "\t | \t" + price;
    }
}
