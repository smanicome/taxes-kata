package fr.smanicome.taxes.business.port;

import fr.smanicome.taxes.business.model.Product;

import java.util.List;
import java.util.Map;

public interface BillFormatter {
    List<String> formatBill(Map<Product, Integer> bill);
}
