package com.pratice.DynamicProgramming;

public class Sol198 {
    public int rob(int[] nums) {
        //dp[i]代表包括i下标在内的房屋，最多可以盗窃的金额是dp[i]
        int[] dp = new int[nums.length];

        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }

        return dp[nums.length-1];
    }
}
