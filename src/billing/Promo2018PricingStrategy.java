package billing;

import events.Event;

import java.math.BigDecimal;

public class Promo2018PricingStrategy implements PricingStrategy {

    @Override
    public BigDecimal calculatePrice(Event event) {
        return event.withPromocode() ? BigDecimal.ZERO : event.listPrice();
    }
}
