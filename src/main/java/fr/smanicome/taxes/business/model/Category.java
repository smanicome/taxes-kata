package fr.smanicome.taxes.business.model;

public enum Category {
    Book(0),
    Food(0),
    Medicine(0),
    Misc(10);

    private final long tax;

    Category(long tax) {
        this.tax = tax;
    }

    public long getTax() {
        return tax;
    }
}
