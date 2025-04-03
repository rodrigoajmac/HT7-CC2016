package org.example;

public class BinarySearchTree {
    private TreeNode root;

    public void insert(Product product) {
        root = insertRec(root, product);
    }

    private TreeNode insertRec(TreeNode node, Product product) {
        if (node == null) return new TreeNode(product);

        if (product.sku.compareTo(node.product.sku) < 0)
            node.left = insertRec(node.left, product);
        else if (product.sku.compareTo(node.product.sku) > 0)
            node.right = insertRec(node.right, product);

        return node;
    }

    public Product search(String sku) {
        return searchRec(root, sku);
    }

    private Product searchRec(TreeNode node, String sku) {
        if (node == null || node.product.sku.equals(sku))
            return node != null ? node.product : null;

        if (sku.compareTo(node.product.sku) < 0)
            return searchRec(node.left, sku);
        else
            return searchRec(node.right, sku);
    }

    public void inorderTraversal() {
        inorderRec(root);
    }

    private void inorderRec(TreeNode node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.println(node.product);
            inorderRec(node.right);
        }
    }
}
