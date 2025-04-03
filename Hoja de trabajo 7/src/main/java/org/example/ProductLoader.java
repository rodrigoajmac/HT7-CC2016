package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductLoader {
    public static BinarySearchTree loadProducts(String filePath) {
        BinarySearchTree bst = new BinarySearchTree();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Leer encabezado y descartarlo
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 5) {
                    String sku = values[0].trim();
                    double priceRetail = Double.parseDouble(values[1].trim());
                    double priceCurrent = Double.parseDouble(values[2].trim());
                    String productName = values[3].trim();
                    String category = values[4].trim();

                    Product product = new Product(sku, priceRetail, priceCurrent, productName, category);
                    bst.insert(product);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return bst;
    }
}
