package com.pratice.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sol47 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtracking(nums,visited);
        return res;
    }

    private void backtracking(int[] nums, boolean[] visited){
        if (path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i]==nums[i-1] && visited[i-1]==false){
                continue;
            }

            if (visited[i]==true){
                continue;
            }

            visited[i] = true;
            path.add(nums[i]);
            backtracking(nums,visited);
            path.removeLast();
            visited[i] = false;
        }
    }
}
