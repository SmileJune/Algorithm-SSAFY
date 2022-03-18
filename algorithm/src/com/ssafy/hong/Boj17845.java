package com.ssafy.hong;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj17845 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] val = new int[K];
		int[] time = new int[K];
		int[][] dp = new int[K][N+1];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			val[i] = Integer.parseInt(st.nextToken());
			time[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i+time[0]<=N; i++) dp[0][i+time[0]] = val[0];
		
		for(int i=1; i<K; i++) {
			for(int j=0; j<=N; j++)dp[i][j] = dp[i-1][j];
			
			for(int j=0; j+time[i]<=N; j++) {
				dp[i][j+time[i]] = Math.max(dp[i-1][j+time[i]], dp[i-1][j]+val[i]);
			}
		}
		
		System.out.println(dp[K-1][N]);
	}
}
