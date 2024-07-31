import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    private Map<String, Product> inventory;
    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }
    //To add a product to the inventory
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }
    // To update an existing product in the inventory
    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found");
        }
    }
    // To delete a product from the inventory
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found");
        }
    }
    // To display the entire inventory
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty");
        } else {
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        ims.addProduct(new Product("1", "Laptop", 10, 5000));
        ims.addProduct(new Product("2", "phone", 15, 2500));
        ims.addProduct(new Product("3", "watch", 20, 1500));

        ims.displayInventory();

        // Updating a product
        ims.updateProduct(new Product("1", "Laptop", 8, 6000));

    }
}

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double cost;

    public Product(String productId, String productName, int quantity, double cost) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.cost = cost;
    }
    public Product(String string, String string2, String string3) {
    }
    public String getProductId() {
        return productId;
    }
    public double getcost() {
        return cost;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setcost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", cost=" + cost +
                '}';
    }
}
