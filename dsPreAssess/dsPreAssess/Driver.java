package dsPreAssess;

public class Driver {
    public static void main(String[] args) {

        OrderDB db = new OrderDB(50);

        db.loadOrders("orders.txt");   // file must be in project root
        db.showOrders();
    }
}
