package model.pricing;

import model.Money;
import model.OrderItem;

public class FixedDiscountValuePricingStrategy extends SubtotalBasedPricingStrategy {

    private final int discount;

    public FixedDiscountValuePricingStrategy(int discount) {
        this.discount = discount;
    }

    @Override
    protected Money subtotal(OrderItem item) {
        return item.subtotal().percent(100 - discount);
    }
}
