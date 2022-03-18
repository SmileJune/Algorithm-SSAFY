package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day39_BOJ_S1_2156 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 포도주 잔의 개수 입력받기 (1 ~ 10000)
		int n = Integer.parseInt(br.readLine());
		// 포도주 양을 배열로 입력받기
		int[] wine = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		// 포도주 양의 최댓값을 저장해둘 dp 배열 만들기
		// [i][0] : i번째 음료를 마시지 않을 때의 최대 양 
		// [i][1] : i번째 음료를 첫번째로 마실 때의 최대 양
		// [i][2] : i번째 음료를 두번째로 마실 때의 최대 양
		int[][] dp = new int[n+1][3];
		
		// 기본으로 알 수 있는 부분 저장
		dp[1][0] = 0;
		dp[1][1] = wine[1];
		
		for(int i = 2; i <= n; i++) {
			// 이번 턴을 안마신다고 하면 직전 턴의 최댓값을 저장
			int max = 0;
			for (int j = 0; j < 3; j++) {
				if(dp[i-1][j] > max) max = dp[i-1][j];
			}
			dp[i][0] = max;
			
			// 연속 1번으로 마시는 경우라면 내 직전 잔은 마셨으면 안됨
			dp[i][1] = dp[i-1][0] + wine[i];
			// 연속 2번으로 마시는 경우라면 내 직전에 1번 마신 거의 누적이랑 나를 더해야지
			dp[i][2] = dp[i-1][1] + wine[i];
		}
		// 다 만들고 최대로 마실 수 있는 포도주의 양 계산하기
		int max = 0;
		for (int j = 0; j < 3; j++) {
			if(dp[n][j] > max) max = dp[n][j];
		}
		System.out.println(max);
	}
}
