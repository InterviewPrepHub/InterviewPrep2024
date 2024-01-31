package com.series.InterviewPrep2024.Design;

/*
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
The cost of painting each house with a certain color is different. You have to paint all the houses such
that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example,
costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1
with color green, and so on... Find the minimum cost to paint all houses.

 */

public class PaintHouse {

    public static void main(String[] args) {

//                       c1, c2, c3
        int cost[][] = { { 14, 2, 11 }, //---> h1
                          { 11, 14, 5 }, //---> h2
                          { 14, 3, 10 }};//---> h3
        int N = cost.length;
        minCost(cost, N);
    }

    private static void minCost(int[][] cost, int n) {

        int[][] dp = new int[n][3];

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i = 1; i < n; i++) {

            dp[i][0] = cost[i][0]+ Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = cost[i][1]+ Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = cost[i][2]+ Math.min(dp[i-1][0], dp[i-1][1]);
        }

        System.out.println(
                Math.min(dp[n - 1][0],
                        Math.min(dp[n - 1][1], dp[n - 1][2])));

    }
}
