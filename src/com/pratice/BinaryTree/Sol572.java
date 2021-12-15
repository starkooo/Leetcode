package com.pratice.BinaryTree;

public class Sol572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot==null){
            return true;
        }
        if (root==null){
            return false;
        }

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot) || isSame(root,subRoot);
    }

    private boolean isSame(TreeNode p,TreeNode q){
        if (p==null && q==null){
            return true;
        }
        if (p==null || q==null){
            return false;
        }
        if (p.val!=q.val){
            return false;
        }
        return isSame(p.left,q.left) && isSame(p.right,q.right);
    }
}
