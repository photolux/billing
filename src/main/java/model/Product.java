package model;

public class Product {

    private String code;
    private String title;
    private Money price;

    public Product(String code, String title, double price) {
        this.code = code;
        this.title = title;
        this.price = new Money(price);
    }

    public String code() {
        return code;
    }

    public String title() {
        return title;
    }

    public Money price() {
        return price;
    }
}
