package events;

import billing.BillingEngine;

import java.math.BigDecimal;

public class Webinar extends Event {
    public Webinar(Client client, BigDecimal listPrice, BillingEngine billingEngine) {
        super(client, listPrice, billingEngine);
    }
}
