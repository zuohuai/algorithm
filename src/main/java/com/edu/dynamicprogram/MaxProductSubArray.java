package com.edu.dynamicprogram;

import org.junit.Test;

/**
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaxProductSubArray {


    @Test
    public void testMaxProduct() throws Exception{
        int[] nums = {-1,-2,-9,-6};
        System.out.println(maxProduct(nums));
    }

    /**
     * 定义DP状态
     * dp状态方程: 利用DP的方式来实现 TODO
     *
     * @param nums
     * @return
     */
    public int maxProductByDp(int[] nums){
        //1.参数校验
        if(nums == null || nums.length == 0){
            return 0;
        }

        //2.dp转移方程
        long res = 0;
        long[] dp = new long[2];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for(int i=1; i<nums.length; i++){
            if(nums[i] < 0){
                long tmp = dp[0];
                dp[0]  = dp[1];
                dp[1] = tmp;
            }
        }
        return 0;
    }

    /**
     * 暴力美学
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        //1. 参数校验
        if(nums == null || nums.length == 0){
            return 0;
        }
        //2.定义结果
        long res = nums[0], max = nums[0], min = nums[0];
        for(int i=1; i< nums.length; i++){
            if(nums[i] < 0){
                long tmp = max;
                max = min;
                min = tmp;
            }
            max = max * nums[i];
            min = min * nums[i];

            max = Math.max(max, Math.max(min, nums[i]));
            min = Math.min(max, Math.min(min, nums[i]));
            res = Math.max(max, res);
        }
        return (int)res;
    }
}
