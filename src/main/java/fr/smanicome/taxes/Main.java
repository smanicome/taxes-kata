package fr.smanicome.taxes;

import fr.smanicome.taxes.business.model.Category;
import fr.smanicome.taxes.business.model.Product;
import fr.smanicome.taxes.business.port.BillFormatter;
import fr.smanicome.taxes.business.port.BillPrinter;
import fr.smanicome.taxes.business.service.BillingService;
import fr.smanicome.taxes.formatter.SimpleBillFormatter;
import fr.smanicome.taxes.printer.PrintStreamBillPrinter;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BillFormatter billFormatter = new SimpleBillFormatter();
        BillPrinter billPrinter = new PrintStreamBillPrinter(billFormatter, System.out);
        BillingService billingService = new BillingService(billPrinter);

        System.out.println("Output 1");

        Map<Product, Integer> input1 = new HashMap<>();
        input1.put(new Product("livre", 12.49, Category.Book, false), 1);
        input1.put(new Product("CD musical", 14.99, Category.Misc, false), 1);
        input1.put(new Product("barre de chocolat", 0.85, Category.Food, false), 1);
        billingService.printBill(input1);

        System.out.println("\nOutput 2");

        Map<Product, Integer> input2 = new HashMap<>();
        input2.put(new Product("boite de chocolat importée", 10.00, Category.Food, true), 1);
        input2.put(new Product("flacon de parfum importé", 47.50, Category.Misc, true), 1);
        billingService.printBill(input2);

        System.out.println("\nOutput 3");

        Map<Product, Integer> input3 = new HashMap<>();
        input3.put(new Product("flacon de parfum importé", 27.99, Category.Misc, true), 1);
        input3.put(new Product("flacon de parfum", 18.99, Category.Misc, false), 1);
        input3.put(new Product("boite de pillules contre la migraine", 9.75, Category.Medicine, false), 1);
        input3.put(new Product("boite de chocolat importée", 11.25, Category.Food, true), 1);
        billingService.printBill(input3);
    }
}
