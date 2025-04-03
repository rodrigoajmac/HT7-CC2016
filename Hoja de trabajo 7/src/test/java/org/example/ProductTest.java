package org.example;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {
    @Test
    public void ProdcutCreationtest() {
        Product product = new Product("123", 100.0, 80.0, "Laptop", "Electronics");

        assertEquals("123", product.sku);
        assertEquals(100.0, product.priceRetail, 0.001);
        assertEquals(80.0, product.priceCurrent, 0.001);
        assertEquals("Laptop", product.productName);
        assertEquals("Electronics", product.category);
    }

    @Test
    public void toStringtest() {
        Product product = new Product("123", 100.0, 80.0, "Laptop", "Electronics");
        String expected = "SKU: 123, Price Retail: 100.0, Price Current: 80.0, Name: Laptop, Category: Electronics";
        assertEquals(expected, product.toString());
    }

}