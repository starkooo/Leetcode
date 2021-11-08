package com.ncepu;

public class Sol_35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left + ((right-left)/2);
            if (target == nums[mid]){
                return mid;
            }else if (target > nums[mid]){
                left = mid + 1;
            }else if (target < nums[mid]){
                right = mid - 1;
            }
        }
        //因为此时left==right==mid。返回的left=mid+1
        return left;
    }
}
