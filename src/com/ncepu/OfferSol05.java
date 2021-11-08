package com.ncepu;

public class OfferSol05 {
    public String replaceSpace(String s) {
        if (s==null || s.length()==0){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            //str.charAt(i) 为 char 类型，为了比较需要将其转为和 " " 相同的字符串类型
            if (" ".equals(String.valueOf(s.charAt(i)))){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
