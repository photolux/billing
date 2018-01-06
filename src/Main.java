import billing.BillingEngine;
import billing.Promo2018PricingStrategy;
import events.Client;
import events.Event;
import events.Webinar;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        BillingEngine billingEngine = new BillingEngine(new Promo2018PricingStrategy());

        Client client = new Client();
        client.addPromoCode("XMAS");

        BigDecimal listPrice = BigDecimal.valueOf(100500);

        Event session = new Webinar(client, listPrice, billingEngine);

        System.out.println(session.requiresPaymentForRegistration());
    }
}
