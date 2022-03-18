package com.ssafy.hong;
import java.util.*;

public class Boj10844 {
	static int N;
	static int[][] dp;
	static final int MOD = 1000000000;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N][10];
		int ans = 0;
		for(int i=1; i<10; i++)dp[0][i] = 1;
		
		for(int i = 1; i<N; i++) {
			for(int j=0; j<10; j++) {
				if(j-1>=0) dp[i][j] = (dp[i][j] + dp[i-1][j-1])%MOD;
				if(j+1<=9) dp[i][j] = (dp[i][j] + dp[i-1][j+1])%MOD;
			}
		}
		for(int i=0; i<10; i++)ans = (ans + dp[N-1][i])%MOD;
		System.out.println(ans);
	}
}
