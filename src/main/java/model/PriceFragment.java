package model;

public class PriceFragment {

    private OrderItem orderItem;
    private Money subtotal;

    public PriceFragment(OrderItem orderItem, Money subtotal) {
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
