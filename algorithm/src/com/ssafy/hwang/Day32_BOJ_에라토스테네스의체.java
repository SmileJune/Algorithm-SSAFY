package com.ssafy.hwang;

import java.util.Scanner;

public class Day32_BOJ_에라토스테네스의체 {
	static int N;
	static int cnt;
	static int K;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cnt = 0;
		N = sc.nextInt();
		K = sc.nextInt();
		boolean[] isNotPrime = new boolean[N + 1];
		getPrime(isNotPrime);
		System.out.println(ans);
	}

	public static void getPrime(boolean[] isNotPrime) {
		for (int i = 2; i <= N; i++) {
			if (!isNotPrime[i]) {
				for (int j = i; j <= N; j += i) {
					if (!isNotPrime[j]) {
						cnt++;
						isNotPrime[j] = true;
						if (cnt == K) {
							ans = j;
							return;
						}
					}
				}
			}
		}
	}
}
