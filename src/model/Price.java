package model;

import java.util.ArrayList;
import java.util.List;

import static model.Order.OrderItem;

public class Price {

    private List<PriceFragment> fragments = new ArrayList<>();

    public void addFragment(Order.OrderItem orderItem, Money subtotal) {
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
                            + ", effective price=" + fragment.subtotal().toPlainString());
        }
        System.out.println("----------------");
        System.out.println("Total: " + total().toPlainString());
    }

    public class PriceFragment {

        private OrderItem orderItem;
        private Money subtotal;

        public PriceFragment(Order.OrderItem orderItem, Money subtotal) {
            this.orderItem = orderItem;
            this.subtotal = subtotal;
        }

        public OrderItem item() {
            return orderItem;
        }

        public Money subtotal() {
            return subtotal;
        }
    }

}
