package com.ncepu;

public class Sol_704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        //因为left == right是有意义的，所以使用 <=
        while (left<=right){
            int mid = left + (right-left)/2;
            if (target==nums[mid]){
                return mid;
            } else if (target>nums[mid]){
                left = mid+1;
            }else if (target<nums[mid]){
                right = mid-1;
            }
        }
        return -1;
    }
}
