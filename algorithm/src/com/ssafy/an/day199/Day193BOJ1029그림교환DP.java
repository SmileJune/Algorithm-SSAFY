package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day193BOJ1029그림교환DP {
	static int N, dp[][][];
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new char[N][];
		dp = new int[1 << N][N][10];

		for (int i = 0; i < N; i++)
			map[i] = in.readLine().toCharArray();

		System.out.print(sol(1, 0, 0));

	}

	private static int sol(int bit, int curr, int prev) {
		if (dp[bit][curr][prev] != 0)
			return dp[bit][curr][prev];

		for (int i = 1; i < N; i++)
			if ((bit & (1 << i)) == 0 && map[curr][i] - '0' >= prev)
				dp[bit][curr][prev] = Math.max(dp[bit][curr][prev], sol(bit | (1 << i), i, map[curr][i] - '0'));

		return ++dp[bit][curr][prev];
	}

}
