package billing;

import events.Event;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal calculatePrice(Event event);
}
