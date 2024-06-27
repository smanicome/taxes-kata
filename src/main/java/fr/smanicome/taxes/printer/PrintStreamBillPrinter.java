package fr.smanicome.taxes.printer;

import fr.smanicome.taxes.business.model.Product;
import fr.smanicome.taxes.business.port.BillFormatter;
import fr.smanicome.taxes.business.port.BillPrinter;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PrintStreamBillPrinter implements BillPrinter {
    private final BillFormatter billFormatter;
    private final PrintStream printStream;

    public PrintStreamBillPrinter(BillFormatter billFormatter, PrintStream printStream) {
        this.billFormatter = Objects.requireNonNull(billFormatter);
        this.printStream = printStream;
    }


    @Override
    public void printBill(Map<Product, Integer> cart) {
        List<String> lines = billFormatter.formatBill(cart);
        printStream.println(String.join("\n", lines));
    }
}
