package fr.smanicome.taxes.business.service;

import fr.smanicome.taxes.business.model.Category;
import fr.smanicome.taxes.business.model.Product;
import fr.smanicome.taxes.business.port.BillPrinter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Collections;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
public class BillingServiceTest {
    @Mock
    BillPrinter billPrinter;

    @InjectMocks
    BillingService billingService;

    @Test
    @DisplayName("should print bill")
    void shouldPrintBill() {
        Product product = new Product("test", 10, Category.Misc, false);
        Map<Product, Integer> cart = Collections.singletonMap(product, 1);
        billingService.printBill(cart);

        verify(billPrinter).printBill(cart);
        verifyNoMoreInteractions(billPrinter);
    }
}
