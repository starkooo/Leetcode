package com.ncepu;

import java.util.Arrays;

public class Sol_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                int sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(target-sum) < Math.abs(target-res)){
                    res = sum;
                }else if (target>sum){
                    left++;
                }else if (target<sum){
                    right--;
                } else {
                    return res;
                }
            }
        }
        return res;
    }
}
