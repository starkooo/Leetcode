package com.pratice.BackTracking;

import java.util.*;

public class Sol491 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums,0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex){
        if (path.size()>1){
            res.add(new ArrayList<>(path));
            /** 注：这里不加return，因为子集问题要收集的是树上所有节点的值，与组合问题不同（组合问题只收集叶子节点上的值，
             *  如果没有path.size()要>=2的要求，if{}这一部分可以省略
             * **/
        }

        //set用于对同层元素去重
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            //注意判断条件，第一个条件除去同层重复元素，第二个条件除去同枝重复元素
            if (set.contains(nums[i]) || (!path.isEmpty() && nums[i]<path.getLast())){
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();
        }


    }
}
