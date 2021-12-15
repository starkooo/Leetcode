package com.pratice.BinaryTree;

public class Sol222 {
    public int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }
        int countLeft = countNodes(root.left);
        int countRight = countNodes(root.right);
        int total = 1 + countLeft + countRight;

        return total;
    }
}
