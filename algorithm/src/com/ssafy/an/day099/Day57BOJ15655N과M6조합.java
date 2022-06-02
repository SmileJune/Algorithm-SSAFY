package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Day57BOJ15655N과M6조합 { // 15655
	static int N, M;
	static int[] arr, sel;
	static StringBuilder sb;
	static List<String> ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		sel = new int[M];
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		comb(0, 0);
		System.out.println(sb);
		br.close();
	}

	private static void comb(int d, int idx) {
		if (d == M) {
			sb.append(Arrays.toString(sel).replaceAll("[\\[\\],]", "").trim()).append("\n");
			return;
		}
		if (idx == N)
			return;

		sel[d] = arr[idx];
		comb(d + 1, idx + 1);
		comb(d, idx + 1);
	}
}
