package com.ssafy.an.day199;

import java.io.*;
import java.util.*;

public class Day159BOJ2212그리디알고리즘 { // 2122
	static int N, K, ans;
	static int[] arr, diff;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		diff = new int[N - 1];

		for (int i = 0; i < diff.length; i++) {
			diff[i] = arr[i + 1] - arr[i];
		}
		Arrays.sort(diff);

		ans = 0;
		for (int i = 0; i < N - K; i++) {
			ans += diff[i];
		}
		System.out.println(ans);
		br.close();
	}
}