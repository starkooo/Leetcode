package com.ncepu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sol_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i-1] == nums[i]){
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (j>i+1 && nums[j-1] == nums[j]){
                    continue;
                }

                int left = j+1;
                int right = nums.length-1;
                while (left<right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if (sum>target){
                        right--;
                    } else if (sum<target){
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        while (left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
