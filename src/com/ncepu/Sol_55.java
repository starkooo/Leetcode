package com.ncepu;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class Sol_55 {
    public boolean canJump(int[] nums) {
        //1.定义：dp[j]表示能不能跳到石头j
        boolean[] dp = new boolean[nums.length];
        //2.初始化
        dp[0] = true;

        for (int j = 1; j < nums.length; j++) {
            dp[j] = false;
            for (int i = 0; i < j; i++) {
                if (dp[i] && i+nums[i]>=j){
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }
}
