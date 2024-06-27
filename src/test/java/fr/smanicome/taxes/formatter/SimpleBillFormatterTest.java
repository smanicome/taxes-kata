package fr.smanicome.taxes.formatter;

import fr.smanicome.taxes.business.model.Category;
import fr.smanicome.taxes.business.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBillFormatterTest {
    @Test
    @DisplayName("should format cart")
    void shouldFormatCart() {
        Map<Product, Integer> cart = new HashMap<>();
        Product product1 = new Product("test1", 10, Category.Misc, false);
        Product product2 = new Product("test2", 5, Category.Book, true);

        cart.put(product1, 1);
        cart.put(product2, 2);

        SimpleBillFormatter simpleBillFormatter = new SimpleBillFormatter();
        List<String> result = simpleBillFormatter.formatBill(cart);

        List<String> expected = Arrays.asList(
            "1 test1: 11.00",
            "2 test2: 10.50",
            "Montant des taxes: 1.50",
            "Total: 21.50"
        );
        assertEquals(expected, result);
    }
}