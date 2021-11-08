package com.ncepu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sol_102 {
//
//    private List<List<Integer>> res = new ArrayList<>();
//
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        levelTraversal(root);
//        return res;
//    }
//
//    private void levelTraversal(TreeNode node){
//        if (node==null){
//            return;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(node);
//
//        while (!queue.isEmpty()){
//            List<Integer> levelList = new ArrayList<>();
//            int levelSize = queue.size();
//
//            while (levelSize>0){
//                TreeNode temp = queue.poll();
//                levelList.add(temp.val);
//
//                if (temp.left!=null){
//                    queue.offer(temp.left);
//                }
//                if (temp.right!=null){
//                    queue.offer(temp.right);
//                }
//                levelSize--;
//            }
//
//            res.add(levelList);
//        }
//
//    }

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> levelList = new ArrayList<>();

            while (len>0){
                TreeNode temp = queue.poll();
                levelList.add(temp.val);

                if (temp.left!=null){
                    queue.offer(temp.left);
                }
                if (temp.right!=null){
                    queue.offer(temp.right);
                }

                len--;
            }

            res.add(levelList);
        }
        return res;

    }
}
