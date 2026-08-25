@Override
public void loadOrders(String fileName) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

        // Skip header
        br.readLine();

        String line;

        while ((line = br.readLine()) != null && count < orders.length) {

            // CSV split
            String[] parts = line.split(",");

            String orderId = parts[0];      // +1001 or similar
            String product = parts[1];      // product name
            double totalAmt = Double.parseDouble(parts[2]);  // numeric amount

            orders[count++] = new Order(orderId, product, totalAmt);
        }

    } catch (Exception e) {
        System.out.println(e);
    }
}
