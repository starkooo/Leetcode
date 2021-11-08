package com.ncepu;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法
 * 参数：
 * int[] candidates
 * int target
 * int sum: 统计当前path里数字的总和
 * int startIndex: 控制for循环的起始位置
 * 注：如果是一个集合来求组合的话，就需要startIndex
 *    如果是多个集合取组合，各个集合之间相互不影响，那么就不用startIndex，例如：回溯算法：电话号码的字母组合
 *
 * 终止条件：sum==target
 */
public class Sol_39 {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,target,0,0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex){

        if(sum==target){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= candidates.length-1; i++) {
            //剪枝
            if (sum+candidates[i]>target){
                break;
            }

            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates,target,sum,i); //注意这里不用i+1，表示可以重复用之前的数
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
