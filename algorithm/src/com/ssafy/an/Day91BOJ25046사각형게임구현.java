package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day91BOJ25046사각형게임구현 { // 25046 사각형 게임
	static int N;
	static long ans;
	static long[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		ans = Long.MIN_VALUE; // 최대값을 찾기 위한
		map = new long[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Long.parseLong(st.nextToken());
		}

		for (int i = 0; i < (1 << N); i++)
			ans = Math.max(ans, sol(i, 0));

		System.out.println(ans);
		br.close();
	}

	private static long sol(int idx, long tmp) {
		for (int i = 0; i < N; i++) {
			long a = 0, b = 0;
			for (int j = 0 ; j < N; j++) {				
				if ((idx & 1 << j) > 0) a += map[j][i];
				else b += map[j][i];
			}
			tmp += Math.min(a, b);
		}
		return tmp;
	}

}
