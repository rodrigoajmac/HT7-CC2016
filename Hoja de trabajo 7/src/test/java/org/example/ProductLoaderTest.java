package org.example;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ProductLoaderTest {
    private BinarySearchTree bst;

    @Test
    public void testLoadProducts_NotEmpty() {
        bst = new BinarySearchTree();
        String testCsvContent = "CATEGORY,DATE_SCRAPED,SORT_BY,RUN_START_DATE,SUBCATEGORY,SHIPPING_LOCATION,SKU,COUNTRY,BRAND,PRICE_RETAIL,PRICE_CURRENT,SELLER,PRODUCT_URL,CURRENCY,BREADCRUMBS,DEPARTMENT,PROMOTION,BESTSELLER_RANK,PRODUCT_NAME,WEBSITE_URL\n"
                + "Electronics,2025-04-01,Popular,2025-04-01,Headphones,USA,12345,USA,Sony,99.99,79.99,Amazon,https://example.com,USD,Audio > Headphones,Electronics,Discount,1,Sony Headphones,https://example.com\n"
                + "Appliances,2025-04-01,Top Rated,2025-04-01,Refrigerators,USA,67890,USA,LG,1499.99,1299.99,BestBuy,https://example.com,USD,Home > Kitchen,Home,Sale,2,LG Fridge,https://example.com";

        String testFilePath = "test_products.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFilePath))) {
            writer.write(testCsvContent);
        } catch (IOException e) {
            fail("Error al crear el archivo de prueba: " + e.getMessage());
        }

        bst = ProductLoader.loadProducts(testFilePath);
        assertNotNull(bst, "El árbol de productos no debería ser nulo");
    }

    @Test
    public void testSearchProductExists() {
        bst = new BinarySearchTree();
        String testCsvContent = "CATEGORY,DATE_SCRAPED,SORT_BY,RUN_START_DATE,SUBCATEGORY,SHIPPING_LOCATION,SKU,COUNTRY,BRAND,PRICE_RETAIL,PRICE_CURRENT,SELLER,PRODUCT_URL,CURRENCY,BREADCRUMBS,DEPARTMENT,PROMOTION,BESTSELLER_RANK,PRODUCT_NAME,WEBSITE_URL\n"
                + "Electronics,2025-04-01,Popular,2025-04-01,Headphones,USA,12345,USA,Sony,99.99,79.99,Amazon,https://example.com,USD,Audio > Headphones,Electronics,Discount,1,Sony Headphones,https://example.com\n"
                + "Appliances,2025-04-01,Top Rated,2025-04-01,Refrigerators,USA,67890,USA,LG,1499.99,1299.99,BestBuy,https://example.com,USD,Home > Kitchen,Home,Sale,2,LG Fridge,https://example.com";

        String testFilePath = "test_products.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFilePath))) {
            writer.write(testCsvContent);
        } catch (IOException e) {
            fail("Error al crear el archivo de prueba: " + e.getMessage());
        }

        bst = ProductLoader.loadProducts(testFilePath);
        Product product = bst.search("12345");
        assertNotNull(product, "El producto con SKU 12345 debería existir");
        assertEquals("12345", product.sku);
        assertEquals(99.99, product.priceRetail, 0.01);
        assertEquals(79.99, product.priceCurrent, 0.01);
        assertEquals("Sony Headphones", product.productName);
        assertEquals("Electronics", product.category);
    }

    @Test
    public void testSearchProductNotExists() {
        bst = new BinarySearchTree();
        String testCsvContent = "CATEGORY,DATE_SCRAPED,SORT_BY,RUN_START_DATE,SUBCATEGORY,SHIPPING_LOCATION,SKU,COUNTRY,BRAND,PRICE_RETAIL,PRICE_CURRENT,SELLER,PRODUCT_URL,CURRENCY,BREADCRUMBS,DEPARTMENT,PROMOTION,BESTSELLER_RANK,PRODUCT_NAME,WEBSITE_URL\n"
                + "Electronics,2025-04-01,Popular,2025-04-01,Headphones,USA,12345,USA,Sony,99.99,79.99,Amazon,https://example.com,USD,Audio > Headphones,Electronics,Discount,1,Sony Headphones,https://example.com\n"
                + "Appliances,2025-04-01,Top Rated,2025-04-01,Refrigerators,USA,67890,USA,LG,1499.99,1299.99,BestBuy,https://example.com,USD,Home > Kitchen,Home,Sale,2,LG Fridge,https://example.com";

        String testFilePath = "test_products.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFilePath))) {
            writer.write(testCsvContent);
        } catch (IOException e) {
            fail("Error al crear el archivo de prueba: " + e.getMessage());
        }

        bst = ProductLoader.loadProducts(testFilePath);
        Product product = bst.search("99999");
        assertNull(product, "El producto con SKU 99999 no debería existir");
    }

}