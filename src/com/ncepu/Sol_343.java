package com.ncepu;

public class Sol_343 {
    public int integerBreak(int n) {
        //dp[i]代表拆分数字i，可得到的最大乘积
        int dp[] = new int[n];

        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i-1; j++) {
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }
}
