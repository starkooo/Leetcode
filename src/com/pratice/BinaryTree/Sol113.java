package com.pratice.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sol113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null){
            return result;
        }

        List<Integer> path = new LinkedList<>();
        backtracking(root,targetSum,result,path);
        return result;
    }

    private void backtracking(TreeNode node,int targetSum,List<List<Integer>> result,List<Integer> path){
        path.add(node.val);

        if (node.left==null && node.right==null){
            if (targetSum-node.val==0){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        if (node.left!=null){
            backtracking(node.left,targetSum-node.val,result,path);
            path.remove(path.size()-1);
        }
        if (node.right!=null){
            backtracking(node.right,targetSum-node.val,result,path);
            path.remove(path.size()-1);
        }

    }
}
