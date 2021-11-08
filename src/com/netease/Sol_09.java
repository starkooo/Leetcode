package com.netease;

public class Sol_09 {
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        return isPalindrome(chars,0,chars.length-1);
    }

    private static boolean isPalindrome(char[] charArray,int left,int right){
        while (left<right){
            if (charArray[left]!=charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
