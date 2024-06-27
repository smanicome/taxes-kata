package fr.smanicome.taxes.formatter;

import fr.smanicome.taxes.business.model.Product;
import fr.smanicome.taxes.business.port.BillFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleBillFormatter implements BillFormatter {
    @Override
    public List<String> formatBill(Map<Product, Integer> bill) {
        List<String> productLines = bill.entrySet().stream()
                .map(entry -> formatProduct(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        String totalTaxes = formatTotalTaxes(bill);
        String total = formatTotal(bill);

        ArrayList<String> billLines = new ArrayList<>(productLines);
        billLines.add(totalTaxes);
        billLines.add(total);

        return billLines;
    }

    private String formatProduct(Product product, Integer quantity) {
        return String.format(Locale.US, "%d %s: %.2f", quantity, product.getName(), product.getPriceIncludingTax() * quantity);
    }

    private String formatTotalTaxes(Map<Product, Integer> bill) {
        double tax = bill.entrySet().stream()
                .map(entry -> entry.getKey().getTax() * entry.getValue())
                .reduce(0.0, Double::sum);
        return String.format(Locale.US, "Montant des taxes: %.2f", tax);
    }

    private String formatTotal(Map<Product, Integer> bill) {
        double tax = bill.entrySet().stream()
                .map(entry -> entry.getKey().getPriceIncludingTax() * entry.getValue())
                .reduce(0.0, Double::sum);
        return String.format(Locale.US, "Total: %.2f", tax);
    }
}
