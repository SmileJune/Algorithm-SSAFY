package com.ssafy.an.day199;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day192BOJ1208부분수열의합 {
	static Map<Long, Integer> sumCnt = new HashMap<>();
	static int arrN, brrN, k;
	static int[] arr, brr;
	static long ans = 0;

	static void f(int idx, long sum) {
		if (idx == arrN) {
			int x = sumCnt.getOrDefault(sum, 0);
			sumCnt.put(sum, x + 1);
			return;
		}

		f(idx + 1, sum);
		f(idx + 1, sum + arr[idx]);

	}

	static void f2(int idx, long sum) {
		if (idx == brrN) {
			ans += sumCnt.getOrDefault(k - sum, 0);
			return;
		}

		f2(idx + 1, sum);
		f2(idx + 1, sum + brr[idx]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		k = sc.nextInt();

		arrN = n / 2;
		arr = new int[arrN];
		for (int i = 0; i < arrN; ++i)
			arr[i] = sc.nextInt();

		brrN = n - arrN;
		brr = new int[brrN];
		for (int i = 0; i < brrN; ++i)
			brr[i] = sc.nextInt();

		f(0, 0);
		f2(0, 0);

		System.out.println(ans - (k == 0 ? 1 : 0));
	}

}
