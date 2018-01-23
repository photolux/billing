package model;

public interface PricingStrategy {
    Price apply(Order order);
}
