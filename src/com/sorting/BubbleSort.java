package com.sorting;

/**
 * 从小到大
 * 原理：
 * 1. 当前一个元素比后一个元素大，则交换他们的位置
 * 2. 对每一对相邻元素都做同样的交换操作，直到最后一对元素
 * 3. 经过上述交换，每一趟都会选出最大的元素（放在队末）
 */
public class BubbleSort {

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
        //每一趟排完，都有1个最大元素被确定
        //第一个循环共n-1次，指的是经过n-1次交换后，n个元素已被确定，所以不用n次
        for (int i = 0; i < n-1; i++) {
            //每次比较都是相邻元素进行比较，从第一个元素开始（j=0）
            //最后一个元素下标为n-1，经过i趟后，已有i个元素位置被确定（最大值），所以到n-1-i结束比较
            for (int j = 0; j < n-1-i; j++) {
                if (nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }

    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
