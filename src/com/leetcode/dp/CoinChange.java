package com.leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }


    public static int coinChange(int[] coins, int amount) {
//        int max = amount + 1;
        // 1. 기본 셋팅
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        // 2. 1부터 시작 dp[0] 은 0이다
        for (int i = 1; i <= amount; i++) {
            System.out.println("i: "+i);
            for (int j = 0; j < coins.length; j++) {
                System.out.println(": "+coins[j]+"  "+i);
                if (i >= coins[j]) {
                    System.out.println("coins["+j+"]"+coins[j]+" i "+i+" "+(dp[i - coins[j]]));
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            System.out.println();
        }
        return dp[amount] > amount ? -1 : dp[amount]; // 3을 구하는데 방법이 3을 넘어가면 말이안되는 조건이니 -1 return
    }
}
