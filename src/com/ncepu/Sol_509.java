package com.ncepu;

public class Sol_509 {
    public static void main(String[] args) {
        fib(10);
    }

    public static int fib(int n) {
        if(n<=1){
            return n;
        }

        //dp数组代表: dp[i]对应的数值
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}
