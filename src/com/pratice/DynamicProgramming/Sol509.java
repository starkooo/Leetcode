package com.pratice.DynamicProgramming;

public class Sol509 {
    public int fib(int n) {

        if (n<=1){
            return n;
        }

        //dp[i]代表第i个数的斐波那契数
        int[] dp = new int[n];

        //数组初始化
        dp[0] = 0;
        dp[1] = 1;

        //遍历顺序，从左到右，因为dp[i]依赖于dp[i-1]和dp[i-2]
        //状态转移公式:dp[i] = dp[i-1] + dp[i-2];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
