package com.pratice.BinaryTree;

public class Sol404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null){
            return 0;
        }

        //递归的遍历顺序为后序遍历（左右中），是因为要通过递归函数的返回值来累加求取左叶子数值之和
        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);

        int midSum = 0;
        if (root.left!=null && root.left.left==null && root.left.right==null){
            midSum = root.left.val;
        }

        int sum = leftSum + rightSum + midSum;

        return sum;
    }
}
