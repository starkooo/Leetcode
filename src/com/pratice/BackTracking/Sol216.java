package com.pratice.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sol216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        backtracking(n,k,1,result,path);
        return result;
    }

    private void backtracking(int targetSum, int k, int startIndex, List<List<Integer>> result, LinkedList<Integer> path){
        if (targetSum<0){
            return;
        }

        if (path.size()==k){
            if (targetSum==0){
                result.add(new ArrayList<>(path));
                return;
            }
        }

        for (int i = startIndex; i <= 9; i++) {
            targetSum -= i;
            path.add(i);
            backtracking(targetSum,k,i+1,result,path);
            path.removeLast();
            targetSum += i;
        }
    }
}
