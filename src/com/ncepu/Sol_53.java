package com.ncepu;


/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 *
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：-1
 *
 * 示例 5：
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 */
public class Sol_53 {
    public int maxSubArray(int[] nums) {
        //1.定义:dp表示数组nums以nums[i]结尾的最大子数组和
        int[] dp = new int[nums.length];

        //2.初始化
        dp[0] = nums[0];

        int max = nums[0];

        //3.状态转移
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);

            if (dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }
}
