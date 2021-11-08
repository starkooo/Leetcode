package com.ncepu;

public class Sol_344 {
    public static void main(String[] args) {
        char[] s = {'a','b','c'};
        reverseString(s);
    }

    public static void reverseString(char[] s) {
        for (int i = 0,j = s.length-1; i < s.length/2; i++,j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

    }
}
