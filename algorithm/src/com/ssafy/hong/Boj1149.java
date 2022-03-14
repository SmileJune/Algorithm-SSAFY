package com.ssafy.hong;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;

public class Boj1149 {
	static int N;
	static int[][] arr;
	static int[][] dp;
	static final int INF = 1<<30;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][3];
		dp = new int[N][3];
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<3; j++) {
				arr[i][j] = sc.nextInt();
				dp[i][j] = INF;
			}
		}
		int ans = INF;
		for(int i=0; i<3; i++) ans = Math.min(ans, recur(N-1,i));
		System.out.println(ans);
	}
	
	static int recur(int n, int rgb) {
		if(n<0) return 0;
		if(dp[n][rgb] != INF) return dp[n][rgb];
		
		
		for(int i=0; i<3; i++)if(i != rgb) {
			dp[n][rgb] = Math.min(dp[n][rgb], recur(n-1, i) + arr[n][i]);
		}
		return dp[n][rgb];
	}
}
