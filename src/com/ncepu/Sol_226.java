package com.ncepu;

/**
 * 要把二叉树反转，只要把节点的左右孩子调换就行
 * 关键在于遍历的顺序，通过观察可以发现，中序遍历行不通，因为这样会把左右孩子反转两次
 */
public class Sol_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        swapChildren(root);
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    private void swapChildren(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
