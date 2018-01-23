package model;

public class FixedDiscountValuePricingStrategy implements PricingStrategy {

    private final int discount;

    public FixedDiscountValuePricingStrategy(int discount) {
        this.discount = discount;
    }

    @Override
    public Price apply(Order order) {
        Price price = new Price();

        order.items().stream().forEach(item -> price.addFragment(item, subtotal(item)));

        return price;
    }

    private Money subtotal(Order.OrderItem item) {
        return item.subtotal().percent(100 - discount);
    }
}
