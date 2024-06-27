package fr.smanicome.taxes.business.service;

import fr.smanicome.taxes.business.model.Product;
import fr.smanicome.taxes.business.port.BillPrinter;

import java.util.Map;
import java.util.Objects;

public class BillingService {
    private final BillPrinter billPrinter;

    public BillingService(BillPrinter billPrinter) {
        this.billPrinter = Objects.requireNonNull(billPrinter);
    }

    public void printBill(Map<Product, Integer> cart) {
        Objects.requireNonNull(cart);
        billPrinter.printBill(cart);
    }
}
