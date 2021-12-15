package com.pratice.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sol39 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            LinkedList<Integer> path = new LinkedList<>();

            backtracking(candidates,0,target,0,result,path);
            return result;
        }

        private void backtracking(int[] candidates, int sum, int target, int startIndex, List<List<Integer>> result, LinkedList<Integer> path){
            if (sum>target){
                return;
            }

            if (target==sum){
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = startIndex; i < candidates.length; i++) {
                sum += candidates[i];
                path.add(candidates[i]);
                backtracking(candidates,sum,target,i,result,path);
                sum -= candidates[i];
                path.removeLast();
            }
        }
}
