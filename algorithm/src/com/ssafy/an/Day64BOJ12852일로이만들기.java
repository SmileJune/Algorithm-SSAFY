package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Day64BOJ12852일로이만들기 { // 12852 1로 2만들기
	static int N;
	static int[] d, path;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		d = new int[N + 1];
		path = new int[N + 1];

		Arrays.fill(d, Integer.MAX_VALUE);

		d[1] = 0;

		for (int i = 2; i < N + 1; i++) {
			if (i % 3 == 0)
				divThree(i);
			if (i % 2 == 0) 
				divTwo(i);			
			if (d[i - 1] + 1 < d[i]) {
				d[i] = d[i - 1] + 1;
				path[i] = i - 1;
			}
		}
		sb.append(d[N] + "\n");
		while (N > 0) {
			sb.append(N + " ");
			N = path[N];
		}
		System.out.println(sb);
		br.close();
	}

	private static void divThree(int i) {
		if (d[i / 3] + 1 < d[i]) {
			d[i] = d[i / 3] + 1;
			path[i] = i / 3;
		}
	}

	private static void divTwo(int i) {
		if (d[i / 2] + 1 < d[i]) {
			d[i] = d[i / 2] + 1;
			path[i] = i / 2;
		}
	}
}
