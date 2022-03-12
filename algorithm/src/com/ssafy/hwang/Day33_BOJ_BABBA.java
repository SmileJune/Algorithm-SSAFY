package com.ssafy.hwang;

import java.util.Scanner;

public class Day33_BOJ_BABBA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	
		memo = new int[N+1];
		System.out.println( fibo(N-1) + " " + fibo(N));
		sc.close();
	}
	static int[] memo;
	
	public static int fibo(int n) {
		if(n<2) {
			return memo[n] = n;
		}
		if(memo[n]>0) {
			return memo[n];
		}
		memo[n] = fibo(n-1)+fibo(n-2);
		return memo[n];
	}
}
