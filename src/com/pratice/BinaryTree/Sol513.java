package com.pratice.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Sol513 {
    public int findBottomLeftValue(TreeNode root) {
        if (root==null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int result = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (i==0){
                    //每一层遍历都取最左边元素，有多层则不断更新
                    result = node.val;
                }
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
}
