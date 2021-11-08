package com.sorting;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * 从小到大
 * 原理：
 * 1. 每一次遍历都先把起始元素当成最小值，记录它的下标作为最小值下标（minIndex）
 * 2. 把当前最小值元素依次和其他元素做对比，当发现小于该元素的元素时，更新minIndex
 * 3. 交换起始元素和minIndex的位置
 */
public class SelectionSort {
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
        //第一层循环，表示先第一个数作为起始元素，和它后面的元素进行比较
        for (int i = 0; i < n; i++) {
            int minIndex = 0;
            //第二层循环，从i后面第一个元素开始，到最后一个元素
            for (int j = i+1; j < n; j++) {
                //当发现i后面有元素比i上的元素小，先不交换（因为后面可能还有更小的），先记录下该元素下标
                if (nums[j]<nums[i]){
                    minIndex = j;
                }
                //等把i后面所有元素都遍历完，也就是第二层循环结束，再进行元素交换
                swap(nums,i,minIndex);
            }
        }
    }

    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
