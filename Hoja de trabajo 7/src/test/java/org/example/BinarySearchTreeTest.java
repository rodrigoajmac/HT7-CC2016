package org.example;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    private BinarySearchTree bst;

    @Test
    public void testInsertAndSearch() {
        bst = new BinarySearchTree();
        bst.insert(new Product("002", 200.0, 150.0, "Tablet", "Electronics"));
        bst.insert(new Product("001", 100.0, 80.0, "Laptop", "Electronics"));
        bst.insert(new Product("003", 300.0, 250.0, "Smartphone", "Electronics"));
        Product found = bst.search("002");
        assertNotNull(found);
        assertEquals("002", found.sku);

        Product notFound = bst.search("999");
        assertNull(notFound);
    }
}