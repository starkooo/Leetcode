package com.ncepu;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 *  
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 */
public class Sol_05_Brutal {
    public static void main(String[] args) {
        String str = "acaca";
        System.out.println(longestPalindrome(str));
    }

    //
    public static String longestPalindrome(String s){
        int len = s.length();

        if (len<2){
            return s;
        }

        int max = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (j-i+1>max && isPalindromic(charArray,i,j)){
                    max = j-i+1;
                    begin = i;
                }
            }
        }

        return s.substring(begin,begin+max);
    }

    //判断字符串是否为回文字符串
    public static boolean isPalindromic(char[] charArray,int left,int right){
        while (left<right){
            if (charArray[left] != charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
