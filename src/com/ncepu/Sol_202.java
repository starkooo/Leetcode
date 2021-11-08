package com.ncepu;

import java.util.HashSet;
import java.util.Set;

/**
 * 如何判断进入了死循环？
 * 当求出的sum重复出现，则表明进入了死循环
 * 因为要快速查找一个数是否出现过在集合中，用哈希表
 */
public class Sol_202 {
    public boolean isHappy(int n) {
        Set<Integer> sumSet = new HashSet<>();
        //算出来的sum等于1，跳出循环，此时满足要求；sum已存在，则代表进入死循环
        while (n!=1 && !sumSet.contains(n)){
            sumSet.add(n);
            n = getNextSum(n);
        }
        return n==1;
    }

    private int getNextSum(int n){
        int res = 0;
        while (n>0){
            int temp = n%10;
            res += temp*temp;
            n = n/10;
        }
        return res;
    }
}
