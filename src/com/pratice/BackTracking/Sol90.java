package com.pratice.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sol90 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtracking(nums,0,visited);
        return res;
    }

    private void backtracking(int[] nums, int startIndex, boolean[] visited){
        res.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++) {
            if (i>0 && nums[i]==nums[i-1] && visited[i-1]==false){
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            backtracking(nums,i+1,visited);
            visited[i] = false;
            path.removeLast();
        }
    }
}
