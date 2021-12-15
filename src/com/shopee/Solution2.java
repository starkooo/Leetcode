package com.shopee;

import java.util.ArrayList;


/**
 * 给定一个字符串，输出这个字符串中所有字符的排列组合
 */
public class Solution2 {

    ArrayList<String> res = new ArrayList<>();

    public String[] permutation(String s) {

        if (s.length()==0 || s.equals("")){
            return new String[]{res.toString()};
        }

        char[] chars = s.toCharArray();
        long size = calN(chars.length);
        dfs(chars,0,chars.length-1);
        String[] array = res.toArray(new String[res.size()]);
        return array;
    }

    private void dfs(char[] chars, int start, int end){
        StringBuilder path = new StringBuilder();
        if (end<=1){
            return;
        }
        if (start==end){
            for (int i = 0; i < chars.length; i++) {
                path.append(chars[i]);
            }
            res.add(path.toString());
        }else {
            for (int i = start; i <= end; i++) {
                swap(chars,i,start);
                dfs(chars,start+1,end);
                swap(chars,i,start);
            }
        }
    }

    private void swap(char[] chars,int a,int b){
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

    private long calN(int num){
        if (num==1){
            return 1;
        }else {
            return num*(calN(num-1));
        }
    }
}
