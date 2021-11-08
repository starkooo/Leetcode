package com.ncepu;

import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路：
 * 1. 首先定义 一个map，key放a和b两数之和，value 放a和b两数之和出现的次数。
 * 2. 遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。
 * 3. 定义int变量count，用来统计a+b+c+d = 0 出现的次数。
 * 4. 在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就用count把map中key对应的value也就是出现次数统计出来。
 * 5. 最后返回统计值 count 就可以了
 */
public class Sol_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;

        for (int a:nums1){
            for (int b:nums2){
                int temp = a+b;
                if (map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                }else {
                    map.put(temp,1);
                }
            }
        }

        for (int c:nums3){
            for (int d:nums4){
                int temp = c+d;
                if (map.containsKey(0-temp)){
                    count += map.get(0-temp);
                }
            }
        }

        return count;
    }
}
