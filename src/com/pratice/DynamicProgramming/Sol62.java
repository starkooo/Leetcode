package com.pratice.DynamicProgramming;

public class Sol62 {
    public int uniquePaths(int m, int n) {
        //dp[i][j]:代表从(0,0)出发，到(i,j)有dp[i][j]条路径
        int[][] dp = new int[m][n];
        
        //dp数组初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1; 
        }

        //遍历顺序：dp[i][j]都是从其上方和左方推导而来，那么从左到右一层一层遍历就可以了。
        //递推公式:dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
