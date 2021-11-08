package com.ncepu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *  
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class Sol_15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    //从左到右遍历，先定一个元素nums[k]，在nums[k]后面设置双指针，两个指针分别指向其后面第一个元素和最后一个元素，逐渐收缩
    public static List<List<Integer>> threeSum(int[] nums) {
        //首先对数组进行排序
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length-1; k++) {
            //当nums[k]大于0，直接break，因为此时后面的元素之和不可能为0
            if (nums[k] > 0){
                break;
            }

            //数字重复，跳过
            if (k>0 && nums[k-1]==nums[k]){
                continue;
            }
            //设置双指针。分别从k后第一个元素i和最后一个元素j逐渐收紧
            int i = k+1;
            int j = nums.length-1;
            while (i<j){
                int sum = nums[k]+nums[i]+nums[j];

                //sum<0,说明要换绝对值更小的负数
                if (sum<0){
                    i++;
                }else if (sum>0){
                    j--;
                }else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));

                    //去重
                    while (i<j && nums[i]==nums[i+1]){
                        i++;
                    }
                    //去重
                    while (i<j && nums[j]==nums[j-1]){
                        j--;
                    }
                    //继续收缩
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}
