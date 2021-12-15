package com.pratice.BinaryTree;

public class Sol226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        swap(root);
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    private void swap(TreeNode root){
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
