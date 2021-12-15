package com.pratice.BinaryTree;

public class Sol101 {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left,root.right);
    }

    private boolean compare(TreeNode left,TreeNode right){
        if (left==null && right!=null){
            return false;
        }else if (left!=null && right==null){
            return false;
        }else if (left==null && right==null){
            return true;
        }else if (left.val!=right.val){
            return false;
        }

        boolean outside = compare(left.left,right.right);
        boolean inside = compare(left.right,right.left);
        boolean isSymmetric = outside && inside;

        return isSymmetric;
    }
}
