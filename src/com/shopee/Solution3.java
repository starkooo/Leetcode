package com.shopee;

import java.util.Arrays;

public class Solution3 {
    public long Solve(int n, int[] lens) {
        Arrays.sort(lens);
        int len = lens.length;
        long total = 0;
        for (int i = len-1; i >= 2; i--) {
            int left = 0, right = i-1;
            while (left<right){
                if (lens[left]+lens[right]>lens[i]){
                    total += (right-left);
                    right--;
                }else {
                    left++;
                }
            }
        }
        return total;
    }
}
