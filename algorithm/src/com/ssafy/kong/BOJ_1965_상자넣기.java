package com.ssafy.BOJ_SB;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1965_상자넣기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int dp[] = new int[N];
		Arrays.fill(dp, 1);
		int ans = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ans = Math.max(dp[i], ans);
		}
		System.out.println(ans);
	}
}
