package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day173BOJ1053펠린드롬구현 { // 1053 펠린드롬 공장
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] string = br.readLine().toCharArray();

		int answer = Integer.MAX_VALUE;

		int[][] dp = new int[string.length][string.length];

		initDp(dp, string.length);

		answer = Math.min(answer, dfs(dp, string, 0, string.length - 1));

		for (int i = 0; i < string.length - 1; i++) {
			char[] copyString = new char[string.length];
			for (int j = i + 1; j < string.length; j++) {
				System.arraycopy(string, 0, copyString, 0, string.length);
				swap(copyString, i, j);
				initDp(dp, string.length);
				answer = Math.min(answer, dfs(dp, copyString, 0, string.length - 1) + 1);
			}
		}
		System.out.println(answer);

	}

	static void swap(char[] string, int i, int j) {
		char c = string[i];
		string[i] = string[j];
		string[j] = c;
	}

	static void initDp(int[][] dp, int n) {
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				dp[r][c] = -1;
			}
		}
	}

	static int dfs(int[][] dp, char[] string, int start, int end) {
		if (dp[start][end] != -1)
			return dp[start][end];

		while (start < end) {
			if (string[start] == string[end]) {
				start++;
				end--;
			} else {
				break;
			}
		}

		if (start >= end) {
			return 0;
		}

		int ret = Integer.MAX_VALUE;
		ret = Math.min(ret, dfs(dp, string, start + 1, end - 1) + 1);
		ret = Math.min(ret, dfs(dp, string, start + 1, end) + 1);
		ret = Math.min(ret, dfs(dp, string, start, end - 1) + 1);

		return dp[start][end] = ret;
	}
}
