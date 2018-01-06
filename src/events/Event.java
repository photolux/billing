package events;

import billing.BillingEngine;

import java.math.BigDecimal;

public abstract class Event {

    private Client client;

    private BigDecimal listPrice;

    private BillingEngine billingEngine;

    Event(Client client, BigDecimal listPrice, BillingEngine billingEngine) {
        this.client = client;
        this.listPrice = listPrice;
        this.billingEngine = billingEngine;
    }

    public BigDecimal listPrice() {
        return listPrice;
    }

    public BigDecimal price() {
        return billingEngine.pricingStrategy().calculatePrice(this);
    }

    public boolean withPromocode() {
        return client.hasPromoCode();
    }

    public boolean requiresPaymentForRegistration() {
        return price().compareTo(BigDecimal.ZERO) > 0;
    }
}
