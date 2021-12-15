package com.pratice.BinaryTree;

public class Sol111 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if(root.left==null && root.right!=null){
            return 1+rightDepth;
        }
        if(root.left!=null && root.right==null){
            return 1+leftDepth;
        }

        int minDepth = 1 + Math.min(leftDepth,rightDepth);
        return minDepth;
    }
}
