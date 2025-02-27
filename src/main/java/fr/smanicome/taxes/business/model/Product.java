package fr.smanicome.taxes.business.model;

import java.util.Objects;

public class Product {
    private final String name;
    private final double price;
    private final Category category;
    private final boolean imported;

    public Product(String name, double price, Category category, boolean imported) {
        this.name = name;
        this.price = price;
        this.category = Objects.requireNonNull(category);
        this.imported = imported;
    }

    public String getName() {
        return name;
    }

    public double getTax() {
        double tax;

        if(imported) {
            tax = price * (category.getTax() + 5) /100 ;
        } else {
            tax = price * category.getTax() / 100;
        }

        return ceilTax(tax);
    }

    public double getPriceIncludingTax() {
        return price + getTax();
    }

    private double ceilTax(double tax) {
        return Math.ceil(tax * 20) / 20;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && imported == product.imported && Objects.equals(name, product.name) && category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, category, imported);
    }
}
