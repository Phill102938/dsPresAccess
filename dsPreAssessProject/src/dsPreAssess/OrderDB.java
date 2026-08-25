package dsPreAssess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrderDB implements OrderDBInterface {

    private Order[] orders;
    private int orderCount;

    public OrderDB(int maxOrders) {
        orders = new Order[maxOrders];
        orderCount = 0;
    }

    @Override
    public void loadOrders(String fileName) {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {

            // Skip header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Read each remaining line as one order
            while (scanner.hasNextLine() && orderCount < orders.length) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                // Adjust parsing to match your actual file format.
                // Common case: fields separated by tabs or multiple spaces.
                String[] parts = line.split("\\s{2,}"); // split on 2+ spaces

                // Example expectation:
                // parts[0] = order id (like +1001 or 1001)
                // parts[1] = product name
                // parts[2] = total amount

                if (parts.length >= 3) {
                    String idStr = parts[0].replace("+", "");
                    int id = Integer.parseInt(idStr);

                    String product = parts[1];

                    double total = Double.parseDouble(parts[2]);

                    orders[orderCount] = new Order(id, product, total);
                    orderCount++;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + fileName);
        }
    }

    @Override
    public void showOrders() {
        // Header EXACTLY as required
        System.out.println("Order ID Product                         Total Amt");
        System.out.println("-------- -------                         ---------");

        for (int i = 0; i < orderCount; i++) {
            Order o = orders[i];

            // Format to match sample:
            // +1001    Mechanical Keyboard                263.42
            System.out.printf("+%-7d %-30s %10.2f%n",
                    o.getOrderId(),
                    o.getProduct(),
                    o.getTotalAmount());
        }
    }
}
