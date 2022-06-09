package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Day120BOJ2110공유기설치BinarySearch기본 { // 2110 공유기 설치
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ss = br.readLine().split(" ");
		N = Integer.parseInt(ss[0]);
		M = Integer.parseInt(ss[1]);
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		int lo = 1;
		int hi = arr[N - 1] - arr[0] + 1;

		while (lo < hi) {
			int mid = (hi + lo) / 2;
			if (check(mid) < M)
				hi = mid;
			else
				lo = mid + 1;
		}

		System.out.println(lo - 1);
		br.close();
	}

	private static int check(int d) {
		int cnt = 1;
		int last = arr[0];

		for (int i = 1; i < arr.length; i++) {
			int l = arr[i];
			if (l - last >= d) {
				cnt++;
				last = l;
			}
		}
		return cnt;
	}
}
