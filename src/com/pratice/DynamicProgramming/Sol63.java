package com.pratice.DynamicProgramming;

public class Sol63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //dp[i][j]:代表从(0,0)出发，到(i,j)有dp[i][j]条路径
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        //dp数组初始化，如果遇到障碍则终止赋值
        for (int i = 0; i < m && obstacleGrid[i][0]==0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i]==0; i++) {
            dp[0][i] = 1;
        }


        //遍历顺序
        //递推公式:dp[i][j] = dp[i-1][j] + dp[i][j-1]，但是要判断没有障碍物
        /**
         * if(obstacleGrid[i][j]==0){
         *      dp[i][j] = dp[i-1][j] + dp[i][j-1]
         * }
         */
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j]==0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
