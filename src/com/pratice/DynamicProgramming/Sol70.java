package com.pratice.DynamicProgramming;

public class Sol70 {
    public int climbStairs(int n) {

        if (n<=1){
            return n;
        }

        //dp[i]：代表爬上i阶楼梯有dp[i]种方法
        int[] dp = new int[n+1];

        //dp数组初始化
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        //遍历顺序：从左到右，因为dp[i]依赖于dp[i-1]和dp[i-2]
        //递推公式：dp[i] = dp[i-1] + dp[i-2]
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
