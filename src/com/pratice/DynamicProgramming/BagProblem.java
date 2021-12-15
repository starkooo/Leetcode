package com.pratice.DynamicProgramming;

public class BagProblem {

    public static void main(String[] args) {
        int[] weight = {2, 1, 3};
        int[] value = {4, 2, 3};
        int bagSize = 4;
        testWeightBagProblem(weight, value, bagSize);
    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){

        //dp[i][w]数组表示：对于前 i 个物品，当前背包的容量为 w，这种情况下可以装的最大价值是 dp[i][w]。
        int[][] dp = new int[weight.length+1][bagSize+1];

        //当背包容量为0
        for (int i = 0; i <= weight.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= weight.length; i++) {
            for (int w = 1; w <= bagSize; w++) {
                //i只能不装入背包的情况
                if (w < weight[i-1]){
                    dp[i][w] = dp[i-1][w];
                }else {
                    //如果装了第 i 个物品，就要寻求剩余重量 w - wt[i-1] 限制下的最大价值，加上第 i 个物品的价值 val[i-1]。
                    dp[i][w] = Math.max(dp[i-1][w],dp[i-1][w-weight[i-1]]+value[i-1]);
                }
            }
        }

        //打印dp数组
        for (int i = 0; i <= weight.length; i++){
            for (int j = 0; j <= bagSize; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
