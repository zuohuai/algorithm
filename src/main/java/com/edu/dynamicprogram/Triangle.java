package com.edu.dynamicprogram;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *    [2],
 *    [3,4],
 *    [6,5,7],
 *    [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * https://leetcode-cn.com/problems/triangle/
 */
public class Triangle {

    @Test
    public void testTrangle1() throws Exception{
        List<List<Integer>> paramList = initParamList();
        printParamList(paramList);
        System.out.println(doTrangle1(paramList));
    }

    /**
     * 动态递推方案:
     * 1. 定义状态, dp[i,j] = bottom-> (i,j)路径和的最小值
     * 2. 定义状态转移方程, dp[i,j] = min(dp[i+1,j], dp[i+1, j+1]) + trangle[i,j]
     * @param triangle
     * @return
     */
    public int doTrangle1(List<List<Integer>> triangle){
        //1. 参数校验
        if(triangle==null || triangle.size() == 0){
            return 0;
        }
        //2. 初始化结果
        int len = triangle.size();
        List<Integer> bottomList = triangle.get(len-1);
        int bottomSize = bottomList.size();
        int[][] resultArr = new int[len][bottomSize]; //每一个初始值是0
        //初始化最底层的数据
        for(int i = 0 ; i < bottomSize; i++){
            resultArr[len-1][i] = bottomList.get(i);
        }
        // 从倒数第二层开始
        for(int j = len-2; j>=0; j--){
            List<Integer> innerList = triangle.get(j);
            for(int k=0; k < innerList.size(); k++){
                resultArr[j][k] = Math.min(resultArr[j+1][k], resultArr[j+1][k+1]) + innerList.get(k);
            }
        }
//        for(int[] result: resultArr){
//            System.out.println(JSON.toJSONString(result));
//        }
        //System.out.println(JSON.toJSONString(resultArr));
        return resultArr[0][0];
    }

    public void printParamList(List<List<Integer>> paramList){
        for(List<Integer> innerList : paramList){
            System.out.println(JSON.toJSONString(innerList));
        }
    }

    public List<List<Integer>> initParamList(){
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(Lists.newArrayList(1));
        resultList.add(Lists.newArrayList(1, 2));
        resultList.add(Lists.newArrayList(1, 2, 3, 4));
        resultList.add(Lists.newArrayList(8, 6, 3, 2, 1));
        resultList.add(Lists.newArrayList(1, 2, 3, 4, 1, 1));
        return resultList;
    }
}
