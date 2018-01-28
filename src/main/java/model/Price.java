package model;

import java.util.ArrayList;
import java.util.List;

public class Price {

    private List<PriceFragment> fragments = new ArrayList<>();

    public void addFragment(OrderItem orderItem, Money subtotal) {
        fragments.add(new PriceFragment(orderItem, subtotal));
    }

    public Money total() {
        return fragments.stream().map(PriceFragment::subtotal).reduce(Money.ZERO, Money::plus);
    }

    public void dump() {

        for (PriceFragment fragment : fragments) {
            Product product = fragment.item().product();
            System.out.println(product.title()
                            + ", list price=" + product.price().toPlainString()
                            + ", quantity=" + fragment.item().quantity()
                            + ", effective subtotal=" + fragment.subtotal().toPlainString());
        }
        System.out.println("----------------");
        System.out.println("Total: " + total().toPlainString());
    }

}
