package com.sorting;

/**
 * 从小到大
 * 原理：
 * 1. 把所有元素看成两部分，已排序的和未排序的
 * 2. 找到未排序组中第一个元素，把它插入到已排序的组中
 * 3. 倒叙遍历已排序的组，依次于待插入元素进行比较，当找到一个元素小于或等于待插入元素，则把带插入元素放到这个位置，后面的元素依次向后移动
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = {5,1,7,3,2};
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void sort(int[] nums){
        if (nums==null || nums.length<2){
            return;
        }
        int n = nums.length;

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (nums[j]<nums[j-1]){
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }else {
                    break; //不需要交换
                }
            }
        }
    }

}
