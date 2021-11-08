package com.netease;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sol_04_Brutal {
    public static void main(String[] args) {
        int[] num1 = new int[]{80,90};
        int[] num2 = new int[]{70,100};
        System.out.println(findMedianSortedArrays(num1,num2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        for(int n1:nums1){
            list.add(n1);
        }
        for(int n2:nums2){
            list.add(n2);
        }

        Collections.sort(list);
        int size = list.size();

        if (size%2==0){
            double res = (list.get(size/2)+list.get((size/2)-1))/2.0;
            return res;

        }else if (size%2==1){
            double res = list.get(size/2);
            return res;
        }
        return 0;

    }
}
