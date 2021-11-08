package com.ncepu;

public class Sol_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] words = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            words[c-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (words[c-'a']!=0){
                words[c-'a']--;
            }else {
                return false;
            }
        }
        return true;
    }
}
