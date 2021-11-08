package com.ncepu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法
 * 参数：
 * int k: 题目中要求k个数的集合
 * int targetSum: 目标和，也就是题目中的n
 * int sum: 已收集的元素总和
 * int startIndex: 下一层for循环搜索的起始位置
 *
 * 终止条件：path的元素数等于k，在这个前提下，如果targetSum==sum，则添加元素到结果集
 */
public class Sol_216 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,0,1);
        return result;
    }

    private void backtracking(int k, int targetSum, int sum, int startIndex){
        // 减枝
        if (sum > targetSum) {
            return;
        }

        //终止条件
        if (path.size()==k){
            if (targetSum==sum){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        //单层搜索过程[1...9]
        //for (int i = startIndex; i <=9; i++) {
        //剪枝后
        for (int i = startIndex; i <=9-(k-path.size())+1; i++) {

            path.add(i);
            sum += i;
            backtracking(k,targetSum,sum,i+1);
            path.removeLast();
            sum -= i;
        }
    }
}
