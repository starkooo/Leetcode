package com.ncepu;

public class Sol_08_api {
    public int myAtoi(String s){
        boolean start = false;
        boolean negative = false;

        s = s.trim();
        if (s.length()==0 || s.equals("")){
            return 0;
        }

        //首位不是数字且不是符号的，直接返回0，eg.a123
        if (!Character.isDigit(s.charAt(0)) && s.charAt(0)!='+' && s.charAt(0)!='-'){
            return 0;
        }

        //首位是符号的，但是只有符号的，过滤，eg. - ；首位是符号，后面接的不是数字的，过滤，eg.-a123
        if (s.charAt(0) == '-' || s.charAt(0) == '+'){
            if (s.length()==1){
                return 0;
            }else if (!Character.isDigit(s.charAt(1))){
                return 0;
            }
        }

        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='-' || c=='+'){
                if (start){
                    break;
                }else if(c=='-'){
                    negative = true;
                }
                continue;
            }
            if (Character.isDigit(c)){
                start = true;
                res = res*10 + c-'0';
                if (res>=Integer.MAX_VALUE && negative==true){
                    return Integer.MAX_VALUE;
                }else if (negative==false && -res<=Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }else {
                break;
            }
        }

        if (negative){
            res = 0-res;
        }

        return (int)res;
    }
}
