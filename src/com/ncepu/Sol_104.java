package com.ncepu;

public class Sol_104 {


    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }

        int max = 0;
        int maxL = 0;
        int maxR = 0;

        if(root.left != null){
            maxL = maxDepth(root.left);
        }

        if (root.right != null){
            maxR = maxDepth(root.right);
        }

        max = maxL > maxR ? maxL+1 : maxR+1;
        return max;
    }
}
