package com.ssafy.BOJ_SB;

import java.util.Scanner;

public class BOJ_11726_2xN타일링2 {
	static int N;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
		}

		System.out.println(dp[n]);

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