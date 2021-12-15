package com.pratice.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sol46 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
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
