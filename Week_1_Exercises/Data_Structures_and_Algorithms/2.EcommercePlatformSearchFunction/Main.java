import Product.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	

	    private Product[] products;
	    private int size;

	    public Main(int capacity) {
	        this.products = new Product[capacity];
	        this.size = 0;
	    }

	    public void addProduct(String productId, String productName, int quantity, double price) {
	        if (size >= products.length) {
	            System.out.println("Inventory is full. Cannot add more products.");
	            return;
	        }
	        products[size++] = new Product(productId, productName, quantity, price);
	    }

	    public Product linearSearch(String productId) {
	        for (int i = 0; i < size; i++) {
	            if (products[i].getProductId().equals(productId)) {
	                return products[i];
	            }
	        }
	        return null;
	    }

	    public Product binarySearch(String productId) {
	        Arrays.sort(products, 0, size, Comparator.comparing(Product::getProductId));
	        int left = 0, right = size - 1;
	        while (left <= right) {
	            int mid = left + (right - left) / 2;
	            int compare = products[mid].getProductId().compareTo(productId);
	            if (compare == 0) {
	                return products[mid];
	            } else if (compare < 0) {
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }
	        }
	        return null;
	    }

	    @Override
	    public String toString() {
	        return "InventoryManagementSystem{" +
	                "products=" + Arrays.toString(Arrays.copyOfRange(products, 0, size)) +
	                '}';
	    }

	    // Main method for testing
	    public static void main(String[] args) {
	    	Main ims = new Main(10);

	        ims.addProduct("001", "Laptop", 10, 999.99);
	        ims.addProduct("002", "Smartphone", 50, 499.99);
	        ims.addProduct("003", "Tablet", 20, 299.99);

	        System.out.println("Initial Inventory:");
	        System.out.println(ims);

	        // Linear search
	        Product foundProduct = ims.linearSearch("002");
	        System.out.println("Linear search result for '002':");
	        System.out.println(foundProduct);

	        // Binary search
	        foundProduct = ims.binarySearch("003");
	        System.out.println("Binary search result for '003':");
	        System.out.println(foundProduct);

	        // Binary search for a product not in inventory
	        foundProduct = ims.binarySearch("004");
	        System.out.println("Binary search result for '004':");
	        System.out.println(foundProduct);
	    
	}

}