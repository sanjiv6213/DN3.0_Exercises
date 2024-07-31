
public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("1", "sanjiv", 250.0),
            new Order("2", "nivesh", 150.0),
            new Order("3", "kumar", 300.0),
            new Order("4", "hari", 200.0)
        };

        System.out.println("Original Orders:");
        printOrders(orders);

        // Sort using Bubble Sort
        BubbleSort.bubbleSort(orders);
        System.out.println("\nOrders sorted by Bubble Sort:");
        printOrders(orders);

        // Reset the orders array
        orders = new Order[]{
            new Order("1", "Alice", 250.0),
            new Order("2", "Bob", 150.0),
            new Order("3", "Charlie", 300.0),
            new Order("4", "Dave", 200.0)
        };

        // Sort using Quick Sort
        QuickSort.quickSort(orders, 0, orders.length - 1);
        System.out.println("\nOrders sorted by Quick Sort:");
        printOrders(orders);
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
