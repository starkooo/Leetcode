package com.pratice.BinaryTree;

public class Sol559 {
    public int maxDepth(Node root) {
        if (root==null){
            return 0;
        }

        int depth = 0;
        while (!root.children.isEmpty()){
            for (Node node:root.children){
                depth = Math.max(depth,maxDepth(node));
            }
        }
        return depth;
    }
}
