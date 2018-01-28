package model.pricing;

import model.Money;
import model.Order;
import model.OrderItem;
import model.Price;

public class SubtotalBasedPricingStrategy implements PricingStrategy {

    @Override
    public Price applyTo(Order order) {
        Price price = new Price();

        order.items().stream().forEach(item -> price.addFragment(item, subtotal(item)));

        return price;
    }

    protected Money subtotal(OrderItem item) {
        return item.subtotal();
    }
}
