import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu {
    private Map<String, String> menu;
    private static Scanner scanner = new Scanner(System.in);
    private MarketPlace marketPlace = new MarketPlace();
    private String keyMenu;

    public Menu() {
        menu = new TreeMap<>();
        menu.put("1", "1 - Add new user");
        menu.put("2", "2 - Add new product");
        menu.put("3", "3 - Delete user");
        menu.put("4", "4 - Delete product");
        menu.put("5", "5 - Display all users");
        menu.put("6", "6 - Display all products");
        menu.put("7", "7 - Buy product");
        menu.put("8", "8 - Display list of user products");
        menu.put("9", "9 - Display list of users that bought product");
        menu.put("Q", "Q - Exit");
    }

    private void methodMenu(String string) {
        int menuPoint = Integer.parseInt(string);
        switch (menuPoint) {
            case 1:
                marketPlace.addNewUser();
                break;
            case 2:
                marketPlace.addNewProduct();
                break;
            case 3:
                marketPlace.deleteUser();
                break;
            case 4:
                marketPlace.deleteProduct();
                break;
            case 5:
                marketPlace.displayAllUsers();
                break;
            case 6:
                marketPlace.displayAllProducts();
                break;
            case 7:
                marketPlace.buyProduct();
                break;
            case 8:
                marketPlace.displayListOfUserProducts();
                break;
            case 9:
                marketPlace.displayListOfUsersThatBoughtProduct();
                break;
            default:
                System.out.println("Select one of the available options!");
        }
    }

    private void outputMenu() {
        System.out.println("\nMENU");
        for (String s : menu.values()) {
            System.out.println(s);
        }
    }

    public void showMenu() {
        do {
            try {
                outputMenu();
                System.out.println("Please, select menu point.");
                keyMenu = scanner.nextLine().toUpperCase();
                methodMenu(keyMenu);
            } catch (Exception e) {
                if (!keyMenu.equals("Q")) {
                    System.out.println("Select one of the available options!");
                    showMenu();
                }
            }
        } while (!keyMenu.equals("Q"));
    }
}
