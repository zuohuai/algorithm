package com.edu.dynamicprogram;

import org.junit.Test;

/**
 * 题目描述:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    /**
     * 采用递归+记忆化
     */
    @Test
    public void testClimbStairs1()
    {
        System.out.println(doClimbStairs1(5));
    }

    public  int doClimbStairs1(int n){
        //1. 定义递归终止条件
        if(n <= 2){
            return n;
        }
        //2. 定义递归执行的流程
        return doClimbStairs1(n-1) + doClimbStairs1(n-2);
    }

    /**
     * 采用动态规划来做
     * dp状态: 到第n阶台阶的总步数 f(n)
     * dp转移方程: f(n) = f(n-1) + f(n-2)
     *
     */
    @Test
    public void testClimbStairs2(){
        System.out.println(doClimbStairs2(5));
    }

    private int doClimbStairs2(int n){
        //1. 参数校验
        if(n <= 2){
            return n;
        }
        //2. 定义出保存的临时标量, 这里也可以临时的用两个变量来保存
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        for(int i=2; i < n; i++){
            mem[i] = mem[i -1] + mem[i-2];
        }
        return mem[n-1];
    }
}
