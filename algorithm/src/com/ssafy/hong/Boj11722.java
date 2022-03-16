package com.ssafy.hong;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;

public class Boj11722 {
	static int N;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		dp = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextInt();
			dp[i]=-1;
		}
		int ans = 0;
		for(int i=0; i<N; i++)ans = Math.max(ans, recur(i));
		System.out.println(ans);
	}
	
	static int recur(int n) {
		if(dp[n] != -1)return dp[n];
		
		dp[n]=1;
		for(int i=n+1; i<N; i++) if(arr[n] > arr[i]){
			dp[n] = Math.max(dp[n], recur(i)+1);
		}
		return dp[n];
	}
}
