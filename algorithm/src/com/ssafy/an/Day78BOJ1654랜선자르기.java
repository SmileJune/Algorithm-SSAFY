package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day78BOJ1654랜선자르기 { // 랜선 자르기
	static int N, K;
	static int[] arr;
	static long min = 0, mid = 0, max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		K = Integer.parseInt(st[0]);
		N = Integer.parseInt(st[1]);

		arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(arr[i], max);
		}
		max++;

		while (min < max) {
			mid = min + (max - min) / 2;
			long cnt = 0;
			for (int i = 0; i < K; i++)
				cnt += (arr[i] / mid);
			max = cnt < N ? mid : max;
			min = cnt < N ? min : mid + 1;
		}
		System.out.println(min - 1);
		br.close();
	}
}
