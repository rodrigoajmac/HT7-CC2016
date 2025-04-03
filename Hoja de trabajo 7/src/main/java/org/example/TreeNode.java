package org.example;

public class TreeNode {
    Product product;
    TreeNode left, right;

    public TreeNode(Product product) {
        this.product = product;
        this.left = this.right = null;
    }
}
