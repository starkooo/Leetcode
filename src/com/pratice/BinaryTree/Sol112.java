package com.pratice.BinaryTree;

public class Sol112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        return backtracking(root,targetSum-root.val);
    }

    private boolean backtracking(TreeNode node,int count){
        if (node.left==null && node.right==null && count==0){
            return true;
        }
        if (node.left==null && node.right==null){
            return false;
        }

        if (node.left!=null){
            count -= node.left.val;
            if(backtracking(node.left,count)){
                return true;
            }
            count += node.left.val;
        }

        if (node.right!=null){
            count -= node.right.val;
            if (backtracking(node.right,count)){
                return true;
            }
            count += node.right.val;
        }

        return false;
    }
}
