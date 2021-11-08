package com.ncepu;

import java.util.Arrays;

public class Sol_647 {
    public int countSubstrings(String s) {
        int n = s.length();
        if (s==null || n<1){
            return 0;
        }

        int count = 0;

        //dp[i][j]表示s[i...j]是否为回文串
        boolean[][] dp = new boolean[n][n];

        //递推公式
        //遍历顺序：从下到上，从左到右
        char[] c = s.toCharArray();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (c[i]==c[j]){
                    if (((j-1)-(i+1)+1)<2){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else {
                    dp[i][j] = false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j]==true){
                    count++;
                }
            }
        }
        return count;
    }
}
