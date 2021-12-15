package com.pratice.BinaryTree;

public class Sol110 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root)==-1 ? false : true;
    }

    private int getHeight(TreeNode node){
        if(node==null){
            return 0;
        }

        int leftHeight = getHeight(node.left);
        if(leftHeight == -1){
            return -1;
        }

        int rightHeight = getHeight(node.right);
        if(rightHeight == -1){
            return-1;
        }

        int gap = Math.abs(leftHeight-rightHeight);
        if(gap>1){
            gap = -1;
        }else{
            gap = 1 + Math.max(leftHeight,rightHeight); // 以当前节点为根节点的树的最大高度
        }
        return gap;
    }
}
