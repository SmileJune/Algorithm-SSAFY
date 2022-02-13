package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13398연속합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr= new int[num];
		int[][] dp = new int[2][num];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < num ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = arr[0];
		dp[0][0] = arr[0];
		dp[1][0] = arr[0];
 		for (int i = 1; i < num; i++) {
			dp[0][i] = Math.max(dp[0][i-1]+arr[i], arr[i]);
			dp[1][i] = Math.max(dp[0][i-1], dp[1][i-1]+arr[i]);
			max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
		}
 		System.out.println(max);
	}
}
