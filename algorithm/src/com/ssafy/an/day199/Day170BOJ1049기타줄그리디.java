package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day170BOJ1049기타줄그리디 {
	static final int INF = 1 << 20;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int minSix = INF;
		int minOne = INF;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			minSix = Math.min(minSix, x);
			minOne = Math.min(minOne, y);
		}

		int a = N / 6;
		int b = N % 6;

		int A = (a + 1) * minSix;
		int B = a * minSix + b * minOne;
		int C = N * minOne;

		int ans = Math.min(A, Math.min(B, C));

		System.out.println(ans);
		br.close();
	}
}
