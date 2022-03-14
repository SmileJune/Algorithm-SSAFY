package com.ssafy.hong;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;

public class Boj2156 {
	static int N;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		dp = new int[N][3];
		
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			for(int j=0; j<3; j++)dp[i][j] = -1;
		}
		
		int ans = 0;
		for(int i=0; i<3; i++)ans = Math.max(ans, recur(N-1,i));
		System.out.println(ans);
	}
	
	static int recur(int n, int step) {
		if(n<0)return 0;
		if(dp[n][step] != -1)return dp[n][step];
		
		if(step == 0) {
			dp[n][step] = Math.max(Math.max(recur(n-1,0), recur(n-1,1)),recur(n-1,2));
		}
		else if(step == 1) {
			dp[n][step] = recur(n-1,0) + arr[n];
		}
		else {
			dp[n][step] = recur(n-1,1) + arr[n];
		}
		return dp[n][step];
	}
	
}
