package com.pratice.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sol40 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        backtracking(candidates,target,0,0,visited);
        return res;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex, boolean[] visited){
        if(sum>target){
            return;
        }

        if(sum==target){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=startIndex; i<candidates.length; i++){
            if(i>0 && candidates[i]==candidates[i-1] && visited[i-1]==false){
                continue;
            }

            sum += candidates[i];
            visited[i] = true;
            path.add(candidates[i]);
            backtracking(candidates,target,sum,i+1,visited);
            path.removeLast();
            visited[i] = false;
            sum -= candidates[i];
        }
    }
}
