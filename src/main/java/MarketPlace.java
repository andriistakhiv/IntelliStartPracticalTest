
import java.util.*;

public class MarketPlace {
    private static Map<Integer, User> users = new HashMap<>();
    private static Map<Integer, Product> products = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public void addNewUser() {
        User user = new User();
        users.put(user.getId(), user);
        System.out.println("Done!");
    }

    public void addNewProduct() {
        Product product = new Product();
        products.put(product.getId(), product);
        System.out.println("Done!");
    }

    public void deleteUser() {
        int userId;
        if (!users.isEmpty()) {
            System.out.println("Choose user ID to delete");
            displayAllUsers();
            userId = scanner.nextInt();
        } else {
            displayAllUsers();
            return;
        }
        if (users.containsKey(userId)) {
            users.remove(userId);
            System.out.println("Done!");
        } else {
            System.out.println("This ID does not exist");
        }
    }

    public void deleteProduct() {
        int productId;
        if (!products.isEmpty()) {
            System.out.println("Choose product ID to delete");
            displayAllProducts();
            productId = scanner.nextInt();
        } else {
            displayAllProducts();
            return;
        }
        if (products.containsKey(productId)) {
            for (Integer key : users.keySet()) {
                Iterator<Product> iterator = users.get(key).getBag().iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().equals(products.get(productId))) {
                        iterator.remove();
                    }
                }
            }
            products.remove(productId);
            System.out.println("Done!");
        } else {
            System.out.println("This ID does not exist");
        }

    }

    public void displayAllUsers() {
        if (!users.isEmpty()) {
            System.out.printf("| %-5s | %-20s | %-20s | %-15s |\n", "ID", "First name", "Second name", "Amount of money");
            System.out.println(Constants.USER_PRINT_UNDERLINE);
            for (User user : users.values()) {
                System.out.printf(Constants.USER_PRINT_PATTERN, user.getId(), user.getFirstName(), user.getSecondName(), user.getBalance());
            }
        } else {
            System.out.println("No users exist yet");
        }
    }

    public void displayAllProducts() {
        if (!products.isEmpty()) {
            System.out.printf("| %-5s | %-30s | %-15s |\n", "ID", "Name", "Price");
            System.out.println(Constants.PRODUCT_PRINT_UNDERLINE);
            for (Product product : products.values()) {
                System.out.printf(Constants.PRODUCT_PRINT_PATTERN, product.getId(), product.getName(), product.getPrice());
            }
        } else {
            System.out.println("No products exist yet");
        }
    }

    public void buyProduct() {
        int userId;
        int productId;
        if (!products.isEmpty() && !users.isEmpty()) {
            System.out.println("Choose user ID to buy product");
            displayAllUsers();
            userId = scanner.nextInt();
            System.out.println("Choose product ID you want to buy");
            displayAllProducts();
            productId = scanner.nextInt();
        }else {
            System.out.println("No products/users exist yet");
            return;
        }
        if (users.containsKey(userId) && users.get(userId).getBalance() >= products.get(productId).getPrice() && products.containsKey(productId)) {
            users.get(userId).addToShoppingBag(products.get(productId));
            users.get(userId).setBalance(products.get(productId).getPrice());
            products.get(productId).addToArchive(users.get(userId));
            System.out.println("Congratulations on a successful purchase!");
        } else {
            System.out.println("Incorrect ID or not enough money!");
        }
    }

    public void displayListOfUserProducts() {
        int userId = 0;
        if (!users.isEmpty()) {
            System.out.println("Select a user ID to view their shopping bag");
            displayAllUsers();
            userId = scanner.nextInt();
        }else {
            displayAllUsers();
        }
        if (users.containsKey(userId) && !users.get(userId).getBag().isEmpty()) {
            System.out.println("Shopping bag:\n");
            for (Product product : users.get(userId).getBag()) {
                System.out.println(product.getName() + " - 1");
            }
        }
    }

    public void displayListOfUsersThatBoughtProduct() {
        int productId = 0;
        if (!products.isEmpty()) {
            System.out.println("Select a product ID to view users that bought it");
            displayAllProducts();
            productId = scanner.nextInt();
        }else {
            displayAllProducts();
        }
        if (products.containsKey(productId) && !products.get(productId).getArchive().isEmpty()) {
            System.out.println("Users:");
            for (User user : products.get(productId).getArchive()) {
                System.out.println(user.getFirstName() + " " + user.getSecondName());
            }
        }
    }
}
