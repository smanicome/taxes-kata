package fr.smanicome.taxes.printer;

import fr.smanicome.taxes.business.model.Category;
import fr.smanicome.taxes.business.model.Product;
import fr.smanicome.taxes.business.port.BillFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PrintStreamBillPrinterTest {
    @Mock
    BillFormatter billFormatter;

    @Mock
    PrintStream printStream;

    @InjectMocks
    PrintStreamBillPrinter printStreamBillPrinter;

    @Test
    @DisplayName("should print formatted bill")
    void shouldPrintFormattedBill() {
        Product product = new Product("test", 10, Category.Misc, false);
        Map<Product, Integer> cart = Collections.singletonMap(product, 1);

        when(billFormatter.formatBill(cart)).thenReturn(Arrays.asList("1", "2", "3"));

        printStreamBillPrinter.printBill(cart);

        InOrder orderVerifier = inOrder(billFormatter, printStream);
        orderVerifier.verify(billFormatter).formatBill(cart);
        orderVerifier.verify(printStream).println("1\n2\n3");
        orderVerifier.verifyNoMoreInteractions();
    }
}