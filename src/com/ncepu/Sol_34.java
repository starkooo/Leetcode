package com.ncepu;

public class Sol_34 {
    public int[] searchRange(int[] nums, int target) {
        int lower = getLowerBound(nums,target);
        int upper = getUpperBound(nums,target);

        if (lower > upper){
            return new int[]{-1,-1};
        }

        return new int[]{lower,upper};
    }

    private int getLowerBound(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (target <= nums[mid]){
                right = mid - 1;
            }else if (target > nums[mid]){
                left = mid + 1;
            }
        }
        return left;
    }


    private int getUpperBound(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            int mid = left + (right-left)/2;
            if (target < nums[mid]){
                right = mid - 1;
            }else if (target >= nums[mid]){
                left = mid + 1;
            }
        }
        return right;
    }




}
