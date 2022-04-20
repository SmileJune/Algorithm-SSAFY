package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1783_병든나이트 {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		System.out.println(process());
	}

	public static int process() {
		if (N == 1) {
			return 1;
		} else if (N == 2) {
			if (M < 7)
				return (M - 1) / 2 + 1;
			else
				return 4;
		} else if (N >= 3) {
			if (M < 6)
				return Math.min(4, M);
			else
				return M - 2;
		}
		return 1;
	}
}
