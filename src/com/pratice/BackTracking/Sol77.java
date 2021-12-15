package com.pratice.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sol77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        backtracking(n,k,1,result,path);
        return result;
    }

    private void backtracking(int n,int k,int startIndex,List<List<Integer>> result,LinkedList<Integer> path){
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n,k,i+1,result,path);
            path.removeLast();
        }
    }
}
