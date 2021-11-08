package com.ncepu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sol_107 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int levelSize = queue.size();

            while (levelSize>0){
                TreeNode temp = queue.poll();
                levelList.add(temp.val);

                if (temp.left!=null){
                    queue.offer(temp.left);
                }
                if (temp.right!=null){
                    queue.offer(temp.right);
                }
                levelSize--;
            }
            list.add(levelList);
        }
        for (int i = list.size()-1; i >= 0; i--) {
            res.add(list.get(i));
        }
        return res;
    }
}
