package com.pratice.DynamicProgramming;

import java.util.Arrays;

public class Sol322 {

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        System.out.println(coinChange(coins,amount));

    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        //便于取最小值
        Arrays.fill(dp,amount+1);

        if (amount<0){
            return -1;
        }
        if (amount==0){
            return 0;
        }
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin:coins){
                if (i-coin<0){
                    continue;
                }
                int res = 1+dp[i-coin];
                dp[i] = Math.min(dp[i], res);
            }
        }
        //注意，可以举coins={2},amount=3为例子来演示过程
        return dp[amount]==amount+1 ? -1 : dp[amount];
    }
}
