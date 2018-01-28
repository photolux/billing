package model.pricing;

import model.Order;
import model.Price;

public interface PricingStrategy {
    Price applyTo(Order order);
}
