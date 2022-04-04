package com.ssafy.ehoi;

import java.util.Scanner;

public class Day56_BOJ_S1_11051 {
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		// 인덱스를 활용할거라서 +1로 생성
		dp = new int[n+1][k+1];
		
		//nCk 뽑아줘 -> 10007로 나눈 나머지 구해줘
		System.out.println(solution(n, k));
		
		sc.close();
	}
	
	// nCk = n-1Ck-1 + n-1Ck
	public static int solution(int n, int k) {
		// 종료 조건
		if (n == k || k == 0) {
			// 1이므로 메모이제이션 해주고 리턴
			return dp[n][k] = 1;
		}
		
		// 재귀파트
		if(dp[n][k] > 0) { 
			// 이미 메모이제이션 dp에 값이 있다면 그거 리턴
			return dp[n][k];
		}
		
		// 메모이제이션하고 리턴
		return dp[n][k] = ((solution(n-1, k-1)%10007) + (solution(n-1, k)%10007))%10007;
	}
}
