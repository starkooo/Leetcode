package com.ncepu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 回溯算法
 * 参数：
 * String digits: 输入的字符串
 * StringBuffer path: 用来收集叶子结点的结果
 * List res: 结果
 * int index: 这个index是记录遍历第几个数字了，就是用来遍历digits的（题目中给出数字字符串），同时index也表示树的深度。
 *
 * 终止条件（也就是遍历深度）：输入字符串的长度(digits.length())等于index
 *
 * 确定单层遍历逻辑：
 * 首先要取index指向的数字，并找到对应的字符集（手机键盘的字符集。
 * 然后for循环来处理这个字符集
 */
public class Sol_17 {

    private List<String> res;
    private Map<Character,String> phoneMap = new HashMap<Character,String>();

    public List<String> letterCombinations(String digits) {
        phoneMap.put('2',"abc");
        phoneMap.put('3',"def");
        phoneMap.put('4',"ghi");
        phoneMap.put('5',"jkl");
        phoneMap.put('6',"mno");
        phoneMap.put('7',"pqrs");
        phoneMap.put('8',"tuv");
        phoneMap.put('9',"wxyz");

        res = new ArrayList<>();
        if (digits.equals("")){
            return res;
        }

        backtrack(digits,res,phoneMap,0,new StringBuffer());
        return res;
    }

    private void backtrack(String digits, List<String> res,Map<Character,String> phoneMap,int index,StringBuffer path){
        //终止条件
        if (index==digits.length()){
            res.add(path.toString());
            return;
        }

        char digit = digits.charAt(index);
        //每个数字对应的字符串
        String letters = phoneMap.get(digit);
        int lettersLen = letters.length();
        for (int i = 0; i < lettersLen; i++) {
            path.append(letters.charAt(i));
            backtrack(digits,res,phoneMap,index+1,path);
            path.deleteCharAt(index);
        }

    }
}
