package com.netease;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */

/**
 * 思路：先把输入的字符串按从左到右遍历，当遇到左括号，就用把它压到一个栈中；当遇到右括号，就从栈中弹出一个元素，与当前右括号作对比，若能匹配，则继续遍历；
 *      若不能匹配，则说明字符串无效。
 * 注意：当遇到右括号时，要先判断一下栈是否为空，因为如果此时为空，则代表当前右括号没办法匹配。可以直接返回字符串无效结果。
 */
public class Sol_20 {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);


            if (c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }

                char topChar = stack.pop();
                if (c==')' && topChar!='('){
                    return false;
                }
                if (c==']' && topChar!='['){
                    return false;
                }
                if (c=='}' && topChar!='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
