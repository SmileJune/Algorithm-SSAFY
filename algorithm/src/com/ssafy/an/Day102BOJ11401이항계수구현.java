package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day102BOJ11401이항계수구현 { // 11401 이항계수
	static final long MOD = 1_000_000_007;
	static int N, K; // nCk

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		K = Integer.parseInt(tmp[1]);

		System.out.println(fac(N) * pow(fac(K) * fac(N - K) % MOD, MOD - 2) % MOD);
		br.close();
	}

	public static long fac(long n) { // 팩토리얼
		long res = 1L;
		while (n > 1)
			res = res * n-- % MOD;
		return res;
	}

	public static long pow(long base, long expo) {
		if (expo == 1)
			return base % MOD;

		long temp = pow(base, expo / 2);
		if (expo % 2 == 1)
			return (temp * temp % MOD) * base % MOD;

		return temp * temp % MOD;

	}
}
