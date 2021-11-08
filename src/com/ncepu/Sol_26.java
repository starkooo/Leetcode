package com.ncepu;

public class Sol_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }
        int p = 0;
        int q = 1;
        while (q< nums.length){
            //不等，则把右指针的值赋给左指针，再前移右节点，左节点
            if (nums[p]!=nums[q]){
                nums[p+1] = nums[q];
                q++;
                p++;
            }else {
                q++;
            }
        }
        return p+1;
    }
}
