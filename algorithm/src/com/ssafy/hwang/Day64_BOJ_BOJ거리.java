package com.ssafy.hwang;

import java.util.Arrays;
import java.util.Scanner;

public class Day64_BOJ_BOJ거리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(sc.nextLine());
		char[] arr = new char[N];
		String s = sc.nextLine();
		for (int i = 0; i < N; i++) {
			arr[i] = s.charAt(i);
		}
		String BOJ = "BOJ";
		int[] dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < dp.length - 1; i++) {
			int idx = BOJ.indexOf(arr[i]);
			if(dp[i]==Integer.MAX_VALUE) continue;
			for (int j = i + 1; j < dp.length; j++) {
				if(arr[j] == BOJ.charAt( (idx+1) % 3) ){
					dp[j] = Math.min(dp[j], (int)Math.pow(j-i, 2)+dp[i]);
				}
			}
		}
		if(dp[N-1]==Integer.MAX_VALUE) dp[N-1] = -1;
		System.out.println(dp[N-1]);
	}
}
