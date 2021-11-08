package com.ncepu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums，返回其所有可能的全排列。你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * 参考了b站：爱学习的饲养员
 */
public class Sol_46 {
    public List<List<Integer>> permute(int[] nums) {
        //结果集
        List<List<Integer>> result = new ArrayList<>();
        //用一个HashMap来保存数字是否被访问过
        HashMap<Integer,Boolean> visited = new HashMap<>(nums.length);
        //初始化HashMap
        for (int n:nums){
            visited.put(n,false);
        }

        //调用回溯算法
        backtrack(nums,result,visited,new LinkedList<>());
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, HashMap<Integer,Boolean> visited, LinkedList<Integer> list){
        //递归退出条件：当list的长度和数字个数相等，说明所有数字都被列举过了
        if (list.size() == nums.length){
            // 注意！此处需要重新new一个List实现，然后进行赋值
            // 因为不重新构造List进行赋值，那么在回溯过程中，由于引用的存在，依旧会将list的元素进行移除，这样最终得到的结果就是为[]
            result.add(new ArrayList<>(list));
            return;
        }

        //开始遍历数组数字
        for (int num:nums){
            //在HashMap中检查数字是否被访问过
            if(!visited.get(num)){
                //没被访问过，把它添加到结果中
                list.add(num);
                //添加后该数字已经被访问过了，更新HashMap
                visited.put(num,true);
                //继续进行回溯，以当前数字开始
                backtrack(nums,result,visited,list);
                //结束上述回溯后，说明基于当前数字进行的回溯已经结束
                //此时要把list最后一个元素去掉，往上返回
                //所以后面还要把该数字改为没出现过
                list.removeLast();
                visited.put(num,false);
            }
        }
    }
}
