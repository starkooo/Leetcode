package com.ncepu;

public class Sol_516 {
    public static void main(String[] args) {
        String s = "cbba";
        System.out.println(longestPalindromeSubseq(s));
    }

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();

        //dp[i][j]：字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]。
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        char[] c = s.toCharArray();
        //遍历顺序：从下到上
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (c[i]==c[j]){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
