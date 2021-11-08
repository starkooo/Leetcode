package com.ncepu;

import java.util.ArrayList;
import java.util.List;


public class Sol_98_Array {

    private List<Integer> res = new ArrayList<>();

    /**
     * 对数组进行中序遍历，再依大小添加到一个数组中，然后判断数组是否有序即可
     * @param node
     */
    private void traversal(TreeNode node){
        if (node==null){
            return;
        }
        traversal(node.left);
        res.add(node.val);
        traversal(node.right);
    }

    public boolean isValidBST(TreeNode root) {
        res.clear();
        traversal(root);
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i)<=res.get(i-1)){
                return false;
            }
        }
        return true;
    }
}
