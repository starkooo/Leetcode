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
public class Sol_05_DP {
    public static void main(String[] args) {
        String str = "acaca";
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String s){
        int len = s.length();

        if (len<2){
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        //1.定义：d[i][j]代表s[i...j]是否为回文串
        boolean dp[][] = new boolean[len][len];

        //2.初始化，每个单独的字符都是一个回文字符串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        //3.状态转移
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else {
                    //当头尾两个字符串相等
                    //判断头尾去掉后还有没有字符剩余，或只剩一个字符，此时去掉头尾之前的字符串肯定是回文串，直接返回即可，不用往前回溯了
                    //以上情况判断条件:(j-1)-(i+1)+1<2 即(j-i)<3
                    if (((j-1)-(i+1)+1)<2){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                //当dp[i][j]=true，表示s[i...j]为回文串
                //接下来需要更新回文串的长度和起始位置
                if (dp[i][j] && maxLen < j-i+1){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }

        return s.substring(begin,begin+maxLen);
    }


}
