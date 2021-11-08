package com.ncepu;

import java.util.Arrays;

public class Sol_300 {
    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }

    public static int lengthOfLIS(int[] nums) {
        //dp[i]表示i之前包括i的最长上升子序列
        int[] dp = new int[nums.length];
        //记得要先加上这一步，不然dp数组一开始全为0
        Arrays.fill(dp,1);
        int result = 0;
        if (nums.length<=1){
            return nums.length;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                result = Math.max(result,dp[i]);
            }
        }
        return result;
    }
}
