package com.ncepu;

import java.util.Scanner;
import java.util.Stack;

public class Sol_32 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = ")()()";
        int res = longestValidParentheses(input);
        System.out.println(res);
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        if (s.length()<2){
            return 0;
        }

        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxLen = Math.max(maxLen,i-stack.peek());
                }
            }
        }
        return maxLen;
    }
}
