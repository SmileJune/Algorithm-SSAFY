package com.ssafy.BOJ_SB;

import java.util.Scanner;

public class BOJ_11726_2xN타일링 {
	static int N;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
//		DFS(0);
		int[] dp = new int[N + 2];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
		System.out.println(dp[N] % 10007);
	}

// 시간초과 코드
//	private static void DFS(int sum) {
//		if(sum > N) return;
//		if(sum == N) {
//			ans++;
//			return;
//		}
//		
//		DFS(sum+1);
//		DFS(sum+2);
//		
//	} 
}
