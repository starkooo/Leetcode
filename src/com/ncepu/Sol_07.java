package com.ncepu;

/**
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 */
public class Sol_07 {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        int res = 0;

        while (x!=0){
            //取末尾数字
            int temp = x%10;

            if ((res> Integer.MAX_VALUE/10) || (res < Integer.MIN_VALUE/10)){
                return 0;
            }
            res = res*10+temp;

            x /= 10;

        }
        return res;
    }
}
