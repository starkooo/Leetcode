package com.ncepu;

public class Sol_559 {
    public int maxDepth(Node root) {
        if (root==null){
            return 0;
        }

        int depth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            depth = Math.max(depth, maxDepth(root.children.get(i)));
        }
        return depth+1;
    }
}
