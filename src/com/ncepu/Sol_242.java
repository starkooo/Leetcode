package com.ncepu;

public class Sol_242 {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for(char c: s.toCharArray()){
            record[c-'a'] += 1;
        }
        for (char c: t.toCharArray()){
            record[c-'a'] -= 1;
        }
        for (int r: record){
            if (r!=0){
                return false;
            }
        }
        return true;
    }
}
