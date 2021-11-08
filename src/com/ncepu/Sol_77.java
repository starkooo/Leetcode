package com.ncepu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法
 * 参数：(int n, int k, int startIndex) --> startIndex 用于确定开始范围
 * 终止条件：path数组的大小等于k
 * 横向遍历：从startIndex到n
 */
public class Sol_77 {

    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();

        if(k<=0 || n<k){
            return res;
        }

        LinkedList<Integer> path = new LinkedList<>();
        backtrack(n,k,1,path,res);
        return res;
    }

    private void backtrack(int n,int k,int startIndex,LinkedList<Integer> path,List<List<Integer>> res){
        if (path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        /**
         * 剪枝优化：
         * 已经选择的元素个数：path.size();
         * 还需要的元素个数为: k - path.size();
         * 在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
         */
        //for (int i = startIndex; i <= n; i++) {
        for (int i = 0; i <= n-(k-path.size())+1; i++) { //控制树的横向遍历

            path.add(i);
            backtrack(n,k,i+1,path,res); //递归，控制树的纵向遍历，注意下一层搜索要从i+1开始
            path.removeLast();
        }
    }
}
