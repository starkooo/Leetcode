package com.ncepu;

public class Sol_209 {
    public int minSubArrayLen(int target, int[] nums) {

        int result = Integer.MAX_VALUE;
        int left = 0; //窗口起始位置
        int winLen = 0;
        int sum = 0; //窗口内数值之和

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            //如果其和大于target，要把长度求出来，然后移动左边界，移动左边界前先把当前左边界上的元素从和中删除
            //注意这里用while，因为后面会更新i，每次更新 i（起始位置），并不断比较子序列是否符合条件
            while (sum>=target){
                winLen = right-left+1;
                result = winLen<result ? winLen : result;
                sum -= nums[left];
                left++;
            }

            //如果其和小于target，移动右边界（即进入下一次循环），也就是不用做处理，因为for循环right++
        }
        return result==Integer.MAX_VALUE ? 0 : result;
    }
}
