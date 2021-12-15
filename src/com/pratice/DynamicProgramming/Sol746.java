package com.pratice.DynamicProgramming;

public class Sol746 {
    public int minCostClimbingStairs(int[] cost) {
        //dp[i]：代表爬到第i级楼梯所需体力
        int[] dp = new int[cost.length+1];

        //dp数组初始化
        dp[0] = cost[0];
        dp[1] = cost[1];

        //遍历顺序：dp[i]由dp[i-1]和dp[i-2]推出，所以是从前到后遍历cost数组就可以了
        //递推公式：dp[i] = Math.min(dp[i-1],dp[i-2])+ cost[i]
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i];
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
}
