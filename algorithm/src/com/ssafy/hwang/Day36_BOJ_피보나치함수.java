package com.ssafy.hwang;

import java.util.Scanner;

public class Day36_BOJ_피보나치함수 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			dp = new int[n+1];
			if(n==1) {
				System.out.println("0 1");
			}
			else if(n==0) {
				System.out.println("1 0");
			}
			else {
				
				System.out.println(fibo(n-2)+" "+fibo(n-1));
			}
			

		}
	}
	static int[] dp;
	public static int fibo(int n) {
		if (n <2) {
			return 1;
		}
		if(dp[n]!=0) {
			return dp[n];
		}
		dp[n] = fibo(n-1) + fibo(n-2);

		return dp[n];
	}
}
