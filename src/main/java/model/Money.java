package model;

import java.math.BigDecimal;

public class Money {

    public static final Money ZERO = new Money(0);

    public static Money of(double amount) {
        return new Money(amount);
    }

    private final BigDecimal amount;

    public Money(double amount) {
        this.amount = BigDecimal.valueOf(amount);
    }

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal amount() {
        return amount;
    }

    public Money plus(Money sum) {
        return new Money(amount.add(sum.amount));
    }

    public Money minus(Money sum) {
        return new Money(amount.subtract(sum.amount));
    }

    public Money mult(int value) {
        return new Money(amount.multiply(BigDecimal.valueOf(value)));
    }

    public Money percent(int percentage) {
        return new Money(amount.multiply(BigDecimal.valueOf(percentage)).divide(BigDecimal.valueOf(100)));
    }

    public String toPlainString() {
        return amount.toPlainString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return amount != null ? amount.equals(money.amount) : money.amount == null;

    }

    @Override
    public int hashCode() {
        return amount != null ? amount.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }
}
