package com.edu.dynamicprogram;

import org.junit.Test;

import java.util.Map;

public class MaxProfit {

	/**
	 *
	 *
	 * @throws Exception
	 */
	@Test
	public void testMaxProfit1() throws Exception{
		int[] prices = new int[]{7,1,5,3,6,4};
		System.out.println(maxProfit1(prices));
	}

	/**
	 * (只能交易一次)
	 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
	 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
	 注意：你不能在买入股票前卖出股票。
	 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
	 分析过程:
	 * 动态递推:
	 * dp[i][j] 表示：在索引为 i 的这一天，用户手上持股状态为 j(0: 表示不持股（特指卖出股票以后的不持股状态），1 表示持股) 所获得的最大利润
	 * 状态转移方程:
	 *dp[i][0]:
	 * dp[i - 1][0] ：当然可以从昨天不持股转移过来，表示从昨天到今天什么都不操作，这一点是显然的；
	 * dp[i - 1][1] + prices[i]：昨天持股，就在索引为 i 的这一天，我卖出了股票，状态由 1 变成了 0，此时卖出股票，因此加上这一天的股价。
	 * 综上所述: dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
	 * dp[i][1]:
	 * dp[i - 1][1] ：昨天持股，今天什么都不操作，当然可以从昨天持股转移过来，这一点是显然的；
	 * -prices[i]：注意：状态 1 不能由状态 0 来，因为事实上，状态 0 特指：“卖出股票以后不持有股票的状态”，请注意这个状态和“没有进行过任何一次交易的不持有股票的状态”的区别。
	 * 因此，-prices[i] 就表示，在索引为 i 的这一天，执行买入操作得到的收益。注意：因为题目只允许一次交易，因此不能加上 dp[i - 1][0]
	 * 综上：dp[i][1] = max(dp[i - 1][1], -prices[i]);
	 * @param prices
	 * @return
	 */
	public int maxProfit1(int[] prices) {
		//1. 参数校验
		if(prices == null || prices.length <= 0){
			return 0;
		}
		//2. 初始状态
		int len = prices.length;
		int[][] dp = new int[len][2];
		dp[0][0] = 0; // 不持股的初始化
		dp[0][1] = -prices[0]; //持股

		//3. 状态转移
		for(int i=1; i < len; i++){
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]); //i不持股状态转移
			dp[i][1] = Math.max(dp[i-1][1], -prices[i]);// i 持股状态转移, 由于只能买卖一次， 所以这里只能是-prices[i]
		}
		return dp[len-1][0];
	}

	@Test
	public void testMaxProfit2() throws Exception{
		int[] prices = new int[]{7,1,5,3,6,4};
		System.out.println(maxProfit2(prices));
	}

	/**
	 *
	 * (能交易无数次)
	 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
	 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
	 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
	 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
	 * @param prices
	 * @return
	 */
	public int maxProfit2(int[] prices) {
		//1. 参数校验
		if(prices == null || prices.length == 0){
			return 0;
		}

		//2. 定义dp的状态初始值
		int len = prices.length;
		int[][] dp = new int[len][2];
		dp[0][0] = 0; //不持有股票
		dp[0][1] = -prices[0]; //持有股票

		for(int i=1; i< len; i++){
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]); // 可以由 1) 没有股票 2)有股票，但是卖掉一次过来
			dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]); // 可以由 1) 有股票 2) 没有股票, 买入一股过来
		}
		return Math.max(dp[len-1][0], dp[len-1][1]);
	};

	@Test
	public void testMaxProfitK() throws Exception{
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfitK(prices, 1));
    }

	/**
	 * 能够交易k次的计算方式
	 * @param prices
	 * @return
	 */
	public int maxProfitK(int[] prices, int k){
		//1. 参数校验
	    if(prices == null || prices.length == 0){
			return 0;
		}
        //2. 定义dp状态初始值
        int len = prices.length;
	    int[][][] dp = new int[len][k][2];
	    dp[0][0][0] = 0; //第0次, 没有股票的情况
	    dp[0][0][1] = -prices[0]; //第0次 , 有股票的情况

        // TODO 待完成
        for(int i=1; i<len; i++){
            for(int j=0; j < k; j++){
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]); // i-1的位置,发生k次交易的情况->未持有股票的情况
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0] - prices[i]); // i-1的位置,发生k次交易的情况->持有股票的情况
            }
        }
		return Math.max(dp[len-1][k-1][0], dp[len-1][k-1][1]);
	}
}
