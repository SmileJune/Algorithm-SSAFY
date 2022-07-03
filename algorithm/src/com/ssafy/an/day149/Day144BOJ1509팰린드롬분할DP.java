package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Day144BOJ1509팰린드롬분할DP { // 1509 팰린드롬 분할
	static final int MAX_LEN = 2500;
	static final int CACHE_EMPTY = -1, FALSE = 0, TRUE = 1;
	static final int INF = 1 << 30;

	static int[][] palindromeCache = new int[MAX_LEN + 1][MAX_LEN + 1];
	static char[] text = new char[MAX_LEN + 1];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		initCache();

		String s = br.readLine();
		int len = s.length();

		for (int i = 0; i < len; i++) {
			text[i + 1] = s.charAt(i);
		}

		int[] dp = new int[len + 1];
		Arrays.fill(dp, INF);
		dp[0] = 0;

		for (int right = 1; right <= len; right++) {
			dp[right] = dp[right - 1] + 1;
			for (int left = 1; left <= right; left++) {
				if (isPalindrome(left, right) == TRUE) {
					dp[right] = Math.min(dp[right], dp[left - 1] + 1);
				}
			}
		}

		System.out.println(dp[len]);
		br.close();
	}

	public static void initCache() {
		for (int i = 0; i < palindromeCache.length; i++) {
			Arrays.fill(palindromeCache[i], CACHE_EMPTY);
		}
	}

	public static int isPalindrome(int left, int right) {
		if (left >= right) {
			return TRUE;
		}

		if (palindromeCache[left][right] != CACHE_EMPTY) {
			return palindromeCache[left][right];
		}

		if (text[left] == text[right] && isPalindrome(left + 1, right - 1) == TRUE) {
			return palindromeCache[left][right] = TRUE;
		} else {
			return palindromeCache[left][right] = FALSE;
		}
	}
}