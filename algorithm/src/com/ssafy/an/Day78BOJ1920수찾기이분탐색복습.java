package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day78BOJ1920수찾기이분탐색복습 { // 이분탐색
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			sb.append(binarySerch(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
		System.out.println(sb);
		br.close();
	}

	private static boolean binarySerch(int key) {
		int l = 0, r = arr.length - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (key < arr[mid])
				r = mid - 1;
			else if (key > arr[mid])
				l = mid + 1;
			else
				return true;
		}

		return false;
	}
}
