package com.ncepu;

import java.util.Arrays;

public class Sol_215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len-k];
    }
}
