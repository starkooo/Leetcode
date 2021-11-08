package com.ncepu;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class OfferSol3 {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i<n){
            //当nums[i]=i，代表索引和元素对应，跳过
            if (nums[i]==i){
                i++;
                continue;
            }
            /**
             * 若nums[nums[i]]=nums[i]：代表索引 nums[i]处和索引 i 处的元素值都为 nums[i]，即找到一组重复值，返回此值 nums[i]
             */
            if (nums[nums[i]]==nums[i]){
                return nums[i];
            }
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
}
