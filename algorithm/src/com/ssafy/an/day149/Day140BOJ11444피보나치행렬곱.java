package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day140BOJ11444피보나치행렬곱 { // 11444 피보나치 수 6 분할정복 행렬 곱셈
	final static long MOD = 1000000007;
	public static long[][] origin = { { 1, 1 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long[][] A = { { 1, 1 }, { 1, 0 } };

		long N = Long.parseLong(br.readLine());

		System.out.println(pow(A, N - 1)[0][0]);
		br.close();
	}

	public static long[][] pow(long[][] A, long exp) {
		if (exp == 1 || exp == 0)
			return A;

		long[][] ret = pow(A, exp / 2);

		ret = multiply(ret, ret);

		if (exp % 2 == 1L)
			ret = multiply(ret, origin);

		return ret;
	}

	public static long[][] multiply(long[][] o1, long[][] o2) {
		long[][] ret = new long[2][2];

		ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
		ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
		ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
		ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;

		return ret;
	}
}
