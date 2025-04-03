package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        String filePath = "C:\\Users\\ajmac\\Documents\\Universidad\\Séptimo semestre\\Algoritmos y estructuras de datos\\HT7-CC2016\\Hoja de trabajo 7\\src\\main\\java\\org\\example\\home appliance skus lowes.csv";
        BinarySearchTree bst = ProductLoader.loadProducts(filePath);

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Buscar un producto por SKU");
            System.out.println("2. Mostrar todos los productos ordenados por SKU");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    System.out.print("Ingrese el SKU del producto: ");
                    String sku = scanner.nextLine();
                    Product product = bst.search(sku);
                    if (product != null) {
                        System.out.println("Producto encontrado: " + product);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 2:
                    System.out.println("Productos en orden ascendente:");
                    bst.inorderTraversal();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}