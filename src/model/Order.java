package model;

import java.util.ArrayList;
import java.util.Collection;

public class Order {

    PricingStrategy pricingStrategy;

    private Collection<OrderItem> items;

    public Order(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
        items = new ArrayList<>();
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

    static class OrderItem {

        private Product product;
        private int quantity;

        OrderItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        Money subtotal() {
            return product.price().mult(quantity);
        }

        Product product() {
            return product;
        }

        public int quantity() {
            return quantity;
        }
    }
}
