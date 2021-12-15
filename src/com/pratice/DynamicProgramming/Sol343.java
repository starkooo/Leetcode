package com.pratice.DynamicProgramming;

public class Sol343 {
    public int integerBreak(int n) {
        //dp[i]:代表拆分数字i可以得到的最大乘积
        int[] dp = new int[n+1];

        //dp数组初始化
        dp[2] = 1;

        //遍历顺序
        //递推公式：dp[i] = Math.max((j*(i-j), j*dp[i-j]);
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }
        return dp[n];
    }
}
