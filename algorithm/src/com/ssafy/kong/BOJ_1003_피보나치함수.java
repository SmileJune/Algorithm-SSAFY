package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003_피보나치함수 {
	static int oneAns, zeroAns;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			oneAns = 0;
			zeroAns = 0;
			fibo(N);
			sb.append(zeroAns).append(" ").append(oneAns);
			System.out.println(sb);
		}
	}

	public static void fibo(int n) {

		int tmp1 = 0;
		int tmp2 = 1;
		int tmp = 0;

		if (n == 0) {
			zeroAns++;
			return;
		} else if (n == 1) {
			oneAns++;
			return;
		} else if (n < 0)
			return;
		else {
			for (int i = 1; i < n; i++) {
				tmp = tmp1 + tmp2;
				tmp1 = tmp2;
				tmp2 = tmp;
			}
			zeroAns = tmp1;
			oneAns = tmp2;
		}
	}
}