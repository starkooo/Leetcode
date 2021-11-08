package com.ncepu;

import java.util.HashSet;
import java.util.Set;

public class Sol_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0){
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();

        for (int num:nums1){
            set1.add(num);
        }

        for (int num:nums2){
            if (set1.contains(num)){
                resSet.add(num);
            }
        }

        int[] res = new int[resSet.size()];
        int index = 0;
        for (int i:resSet){
            res[index++] = i;
        }
        return res;
    }
}
