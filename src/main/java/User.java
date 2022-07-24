import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private static int counter;
    private final int id;
    private final String firstName;
    private final String secondName;
    private final double amountOfMoney;
    private double balance;
    private final Scanner scanner = new Scanner(System.in);
    private List<Product> shoppingBag = new ArrayList<>();

    public User() {
        counter++;
        id = counter;
        firstName = setFirstName();
        secondName = setSecondName();
        amountOfMoney = setAmountOfMoney();
        balance = amountOfMoney;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        if (getBalance() >= amount) {
            balance = balance - amount;
        }
    }

    public List<Product> getBag() {
        return shoppingBag;
    }

    public void addToShoppingBag(Product product) {
        shoppingBag.add(product);
    }

    private String setFirstName() {
        while (true) {
            System.out.println("Enter your first name:");
            String str = scanner.nextLine();
            if (str == null || str.equals("")) {
                System.out.println("Try again!");
            } else {
                return str;
            }
        }
    }

    private String setSecondName() {
        while (true) {
            System.out.println("Enter your second name:");
            String str = scanner.nextLine();
            if (str == null || str.equals("")) {
                System.out.println("Try again!");
            } else {
                return str;
            }
        }
    }

    private double setAmountOfMoney() {
        while (true) {
            System.out.println("Enter amount of money:");
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
        return id + "\t | \t" + firstName + "\t | \t" + secondName + "\t | \t" + balance;
    }
}
