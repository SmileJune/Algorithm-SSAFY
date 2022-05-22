package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day104BOJ12015LISBestSol {

	static int N, n;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new int[N];
		arr[0] = Integer.parseInt(st.nextToken());
		int idx = 0;
		for (int i = 1; i < N; i++) {
			n = Integer.parseInt(st.nextToken());
			if (n > arr[idx]) arr[++idx] = n;
			else arr[find(0, idx)] = n;
		}
		System.out.println(idx + 1);
		br.close();
	}

	private static int find(int start, int end) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == n) return mid;
			if (arr[mid] < n) start = mid + 1;
			else end = mid - 1;
		}
		return start;
	}
}
