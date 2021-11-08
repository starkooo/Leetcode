package com.ncepu;

public class Sol_98 {

    public boolean isValidBST(TreeNode root) {
        return isBST(root,null,null);
    }

    private boolean isBST(TreeNode root,TreeNode min,TreeNode max){
        if (root==null){
            return true;
        }

        if (min!=null && min.val>=root.val){
            return false;
        }

        if (max!=null && max.val<=root.val){
            return false;
        }

        return isBST(root.left,min,root) && isBST(root.right,root,max);
    }
}
