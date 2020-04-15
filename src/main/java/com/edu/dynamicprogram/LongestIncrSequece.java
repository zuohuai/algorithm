package com.edu.dynamicprogram;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 最长上升子序列
 */
public class LongestIncrSequece {

    @Test
    public void testLengthOfLIS() throws Exception{
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    /**
     * 分析:
     * 定义状态: dp[i]: 0->i, 最长的子序列
     * 定义状态转移方程: dp[i] ; max(dp[j]) + 1 且 j: 0-> i-1,且a[j] < a[i]
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        //1. 参数校验
        if(nums == null || nums.length ==0){
            return 0;
        }
        //2. 定义初始值
        int res = 1;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1); //初始化值

        //3. 状态转移处理
        for(int i = 1; i<len; i++){
            for(int j = 0; j<i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1); // dp[j]+1 表示的是需要包含自己
                }
                res = Math.max(dp[i], res);
            }
        }
        return res;
    }
}
