import model.Money;
import model.Order;
import model.Price;
import model.Product;
import model.pricing.FixedDiscountValuePricingStrategy;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class OrderTotalTest {

    private Order order;

    @Before
    public void anOrder() {
        Product product1 = new Product("00001", "Product One", 100.0);
        Product product2 = new Product("00002", "Product Two", 20.0);

        order = new Order();
        order.add(product1, 1);
        order.add(product2, 5);
    }

    @Test
    public void defaultPricing() throws Exception {
        Price price = order.total();
        assertEquals(Money.of(200.0), price.total());
    }

    @Test
    public void withFixedDiscount() throws Exception {
        order.changePricingStrategyTo(new FixedDiscountValuePricingStrategy(10));
        Price price = order.total();
        assertEquals(Money.of(180.0), price.total());
    }
}