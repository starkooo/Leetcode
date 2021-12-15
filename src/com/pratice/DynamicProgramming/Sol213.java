package com.pratice.DynamicProgramming;

public class Sol213 {
    public int rob(int[] nums) {

        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }

        int result1 = rob(nums,0,nums.length-2);
        int result2 = rob(nums,1,nums.length-1);
        return Math.max(result1,result2);
    }

    private int rob(int[] nums, int start, int end){

        if (end==start){
            return nums[start];
        }

        //dp[i]代表盗窃包括i在内的房屋，所能获得的最大金额
        int[] dp = new int[nums.length];

        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start],nums[start+1]);

        for (int i = start+2; i <= end; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[end];
    }
}
