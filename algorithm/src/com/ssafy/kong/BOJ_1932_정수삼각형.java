package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형 {
   static int N;
   static int[][] arr;
   static int[][] dp;
   static int max = Integer.MIN_VALUE;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      int idx = N * 2 - 1;
      arr = new int[N][N];
      dp = new int[N][N];
      StringTokenizer st;
      for (int i = 0; i < N; ++i) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j <= i; j++) {
            arr[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      for (int[] tmp : dp) { // -1로 일단 다 채워라.
         Arrays.fill(tmp, -1);
      }

      for (int i = 0; i < N; ++i) {
         dp[N - 1][i] = arr[N - 1][i];
      }

      System.out.println(find(0, 0));

   }

   static int find(int r, int c) {
      if (r == N - 1)
         return dp[r][c];
      if (dp[r][c] == -1) {
         dp[r][c] = Math.max(find(r + 1, c), find(r + 1, c + 1)) + arr[r][c];
      }
      return dp[r][c];
   }
}