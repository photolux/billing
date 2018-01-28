import model.Order;
import model.Price;
import model.Product;
import model.pricing.FixedDiscountValuePricingStrategy;

public class Main {

    public static void main(String[] args) {

        Product product1 = new Product("00001", "Product One", 100.0);
        Product product2 = new Product("00002", "Product Two", 20.0);

        Order order = new Order();
        order.add(product1, 1);
        order.add(product2, 5);

        Price total = order.total();
        total.dump();

        order.changePricingStrategyTo(new FixedDiscountValuePricingStrategy(10));
        Price discounted = order.total();
        discounted.dump();
    }
}
