package org.example;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ProductLoaderTest {
    @Test
    public void load() throws IOException {
        File tempFile = File.createTempFile("test_products", ".csv");
        FileWriter writer = new FileWriter(tempFile);
        writer.write("SKU,Price_Retail,Price_Current,Product_Name,Category\n");
        writer.write("001,100.0,80.0,Laptop,Electronics\n");
        writer.write("002,200.0,150.0,Tablet,Electronics\n");
        writer.close();

        BinarySearchTree bst = ProductLoader.loadProducts(tempFile.getAbsolutePath());
        assertNotNull(bst.search("001"));
        assertEquals("Laptop", bst.search("001").productName);
    }

}