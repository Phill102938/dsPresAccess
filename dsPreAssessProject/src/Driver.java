package dsPreAssess;

public class Driver {
    public static void main(String[] args) {
        // Assuming 50 orders in the file
        OrderDB db = new OrderDB(50);

        // If orders.txt is in the project root, this relative path should work.
        db.loadOrders("orders.txt");

        db.showOrders();
    }
}
