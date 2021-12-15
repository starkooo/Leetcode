package com.pratice.BinaryTree;

public class Sol104 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int depth = 1 + Math.max(leftDepth,rightDepth);

        return depth;
    }
}
