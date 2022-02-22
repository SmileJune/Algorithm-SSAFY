package com.ssafy.an;

import java.util.Scanner;

public class Day12BOJ1592영식이와친구들 { // 1592
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 3이상 50이하
		int M = sc.nextInt(); // 50이하
		int L = sc.nextInt(); // N - 1 이하
		int[] cnt = new int[N];
		int ans = 0;
		int idx = 0;
		while (true) {
			cnt[idx]++;

			if (cnt[idx] == M) {
				break;
			}
			ans++;

			if (cnt[idx] % 2 == 1) { // 받고 시작해서 짝수가 1로 판단
				if (idx + L < N)
					idx += L;
				else
					idx += L - N; // idx 보정
			} else {
				if (idx - L >= 0)
					idx -= L;
				else
					idx -= L - N; // idx 보정
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
