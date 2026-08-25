package dsPreAssess;

import java.io.BufferedReader;
import java.io.FileReader;

public class OrderDB implements OrderDBInterface {

    private Order[] orders;
    private int count;

    public OrderDB(int maxSize) {
        orders = new Order[maxSize];
        count = 0;
    }

    
    public void loadOrders(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

           
            br.readLine();

            String line;

            while ((line = br.readLine()) != null && count < orders.length) {

               
                String[] parts = line.split(",");

         

                String orderId = "+" + parts[0];   
                String product = parts[2];
                double totalAmt = Double.parseDouble(parts[3]);

                orders[count++] = new Order(orderId, product, totalAmt);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    public void showOrders() {
        System.out.println("Order ID Product                         Total Amt");
        System.out.println("-------- -------                         ---------");

        for (int i = 0; i < count; i++) {
            Order o = orders[i];

            System.out.printf("%-8s %-30s %10.2f%n",
                    o.getOrderId(),
                    o.getProduct(),
                    o.getTotalAmount());
        }
    }
}
