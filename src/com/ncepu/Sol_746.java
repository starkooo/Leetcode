package com.ncepu;

public class Sol_746 {
    public int minCostClimbingStairs(int[] cost) {
        //表示爬到第i级阶梯所需的最少体力值
        int[] dp = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }

        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
}
