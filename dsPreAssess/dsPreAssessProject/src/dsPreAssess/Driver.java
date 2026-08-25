package dsPreAssess;

public class Driver {
    public static void main(String[] args) {

        OrderDB db = new OrderDB(50);

        db.loadOrders("orders.txt");  
        db.showOrders();
    }
}
