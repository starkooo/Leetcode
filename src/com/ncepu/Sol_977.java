package com.ncepu;

/**
 * 思路：双指针
 */
public class Sol_977 {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        int insertIndex = result.length-1;

        while (left<=right){
            if (nums[left]*nums[left] > nums[right]*nums[right]){
                result[insertIndex--] = nums[left]*nums[left];
                left++;
            }else {
                result[insertIndex--] = nums[right]*nums[right];
                right--;
            }
        }
        return result;
    }
}
