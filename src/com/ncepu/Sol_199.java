package com.ncepu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 使用层序遍历，当遍历到单层最后面的元素，就加入到res中
 */
public class Sol_199 {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();

            //把每层的节点遍历
            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = queue.poll();
                if (temp.left!=null){
                    queue.offer(temp.left);
                }
                if (temp.right!=null){
                    queue.offer(temp.right);
                }
                if (i==levelSize-1){
                    res.add(temp.val);
                }
            }
        }
        return res;
    }
}
