package com.ncepu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sol_113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();

        if (root==null){
            return res;
        }

        //root不为空再创建path
        List<Integer> path = new LinkedList<>();;

        traversal(root,targetSum,res,path);
        return res;
    }

    private void traversal(TreeNode root, int count, List<List<Integer>> res,List<Integer> path){
        path.add(root.val);
        if (root.left==null && root.right==null){
            if (count - root.val == 0){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        if (root.left!=null){
            traversal(root.left,count-root.val,res,path);
            path.remove(path.size()-1);
        }
        if (root.right!=null){
            traversal(root.right,count-root.val,res,path);
            path.remove(path.size()-1);
        }
    }
}
