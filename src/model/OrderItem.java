package model;

public class OrderItem {

    private Product product;
    private int quantity;

    OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Money subtotal() {
        return product.price().mult(quantity);
    }

    Product product() {
        return product;
    }

    public int quantity() {
        return quantity;
    }
}
