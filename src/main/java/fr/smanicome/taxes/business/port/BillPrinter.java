package fr.smanicome.taxes.business.port;

import fr.smanicome.taxes.business.model.Product;

import java.util.Map;

public interface BillPrinter {
    void printBill(Map<Product, Integer> cart);
}
