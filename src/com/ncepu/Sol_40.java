package com.ncepu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法
 * 参数：
 * int[] candidates
 * int target
 * int sum
 * int startIndex
 * boolean used: 用来记录同一树枝上的元素是否使用过。
 */
public class Sol_40 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] flag = new boolean[candidates.length];
        backtracking(candidates,target,0,0,flag);
        return res;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex, boolean[] used){
        if (sum==target){
            res.add(new ArrayList<>(path));
            return;
        }

        //在for循环这里就剪枝
        for (int i = startIndex; i < candidates.length && candidates[i]+sum<=target; i++) {
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 要对同一树层使用过的元素进行跳过
            if (i>0 && candidates[i]==candidates[i-1] && used[i-1]== false){
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            used[i] = true;
            backtracking(candidates,target,sum,i+1,used);
            sum -= candidates[i];
            path.removeLast();
            used[i] = false;
        }
    }
}
