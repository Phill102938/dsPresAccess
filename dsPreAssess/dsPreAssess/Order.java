package dsPreAssess;

public class Order {
    private String orderId;
    private String product;
    private double totalAmount;

    public Order(String orderId, String product, double totalAmount) {
        this.orderId = orderId;
        this.product = product;
        this.totalAmount = totalAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProduct() {
        return product;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
