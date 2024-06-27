package fr.smanicome.taxes.business.model;

public class Product {
    private final String name;
    private final double price;
    private final Category category;
    private final boolean imported;

    public Product(String name, double price, Category category, boolean imported) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.imported = imported;
    }

    public String getName() {
        return name;
    }

    public double getPriceExcludingTax() {
        return price;
    }

    public double getTax() {
        if(imported) {
            return price * (category.getTax() + 5) /100 ;
        }
        return price * category.getTax() / 100;
    }

    public double getPriceIncludingTax() {
        return price + getTax();
    }
}
