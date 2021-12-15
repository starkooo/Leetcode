package com.pratice.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sol17 {

    private Map<Integer,String> phoneMap = new HashMap<Integer, String>();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        phoneMap.put(2,"abc");
        phoneMap.put(3,"def");
        phoneMap.put(4,"ghi");
        phoneMap.put(5,"jkl");
        phoneMap.put(6,"mno");
        phoneMap.put(7,"pqrs");
        phoneMap.put(8,"tuv");
        phoneMap.put(9,"wxyz");

        if (digits.equals("") || digits.length()==0){
            return result;
        }

        backtracking(digits,0,phoneMap,result,path);
        return result;
    }

    //参数
    //index：这个index是记录遍历第几个数字了，就是用来遍历digits的 ，同时index也表示树的深度。
    private void backtracking(String digits,int index,Map<Integer,String> phoneMap,List<String> result,StringBuilder path){
        if (index==digits.length()){
            result.add(path.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = phoneMap.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtracking(digits,index+1,phoneMap,result,path);
            path.deleteCharAt(index);
        }
    }
}
