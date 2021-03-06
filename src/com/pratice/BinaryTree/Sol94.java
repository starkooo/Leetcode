package com.pratice.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Sol94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }

    private void inorder(TreeNode root,List<Integer> res){
        if (root==null){
            return;
        }

        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
}
