package model;

public interface PricingStrategy {
    Price applyTo(Order order);
}
