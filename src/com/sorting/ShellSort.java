package com.sorting;

public class ShellSort {

    public static void main(String[] args) {
        int[] nums = {9,1,2,5,7,4,8,6,3,5};
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void sort(int[] nums){
        int n = nums.length;

        //确定增长量，每一趟结束后要除以2
        int h = 1;
        while (h<n/2){
            h = h*2+1;
        }

        //当h<1时停止循环
        while (h>=1){
            //找到待插入元素的位置，依次是a[h],a[h+1],...,a[n-1]，即a[i]
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j-=h) {
                    if (nums[j]<nums[j-h]){
                        swap(nums,j,j-h);
                    }else {
                        break;
                    }
                }
            }
            h /=2;
        }
    }

    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
