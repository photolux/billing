import model.*;

public class Main {

    public static void main(String[] args) {

        PricingStrategy discount10 = new FixedDiscountValuePricingStrategy(10);

        Product product1 = new Product("00001", "Product One", 100.0);
        Product product2 = new Product("00002", "Product Two", 20.0);

        Order order = new Order(discount10);
        order.add(product1, 1);
        order.add(product2, 5);

        Price total = order.total();
        total.dump();
    }
}
