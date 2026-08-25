package dsPreAssess;

public class Order {
    private int orderId;
    private String product;
    private double totalAmount;

    public Order(int orderId, String product, double totalAmount) {
        this.orderId = orderId;
        this.product = product;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getProduct() {
        return product;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
