package com.sorting;


public class QuickSort {

    public int[] sortArray(int[] nums) {
        sortArray(nums,0,nums.length-1);
        return nums;
    }

    public void sortArray(int[] nums, int low ,int high) {
        while (low>high){
            return;
        }

        int i = low;
        int j = high;

        int standard = nums[low];

        while (i<j){
            while (nums[j]>=standard && i<j){
                j--;
            }
            while (nums[i]<=standard && i<j){
                i++;
            }
            if (i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        nums[low] = nums[i];
        nums[i] = standard;

        sortArray(nums,low, i-1);
        sortArray(nums, i+1, high);
    }
}
