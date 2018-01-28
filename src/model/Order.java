package model;

import model.pricing.PricingStrategy;
import model.pricing.SubtotalBasedPricingStrategy;

import java.util.ArrayList;
import java.util.Collection;

public class Order {

    PricingStrategy pricingStrategy;

    private Collection<OrderItem> items;

    public Order() {
        pricingStrategy = new SubtotalBasedPricingStrategy();
        items = new ArrayList<>();
    }

    public void changePricingStrategyTo(PricingStrategy strategy) {
        this.pricingStrategy = strategy;
    }

    public Collection<OrderItem> items() {
        return items;
    }

    public void add(Product product, int quantity) {
        items.add(new OrderItem(product, quantity));
    }

    public Price total() {
        return pricingStrategy.applyTo(this);
    }

}
