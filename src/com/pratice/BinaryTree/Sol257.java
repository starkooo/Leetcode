package com.pratice.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Sol257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root==null){
            return result;
        }
        List<Integer> path = new ArrayList<>();
        backtracking(root,path,result);
        return result;
    }

    private void backtracking(TreeNode node, List<Integer> path, List<String> result){

        path.add(node.val);

        //终止条件：遇到叶子节点
        if (node.left==null && node.right==null){
            //对path里面存的节点号进行处理
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size()-1; i++) {
                sb.append(path.get(i) + "->");
            }
            sb.append(path.get(path.size()-1));
            result.add(sb.toString());
            return;
        }
        if (node.left!=null){
            backtracking(node.left,path,result);
            //回溯
            path.remove(path.size()-1);
        }
        if (node.right!=null){
            backtracking(node.right,path,result);
            //回溯
            path.remove(path.size()-1);
        }

    }
}
