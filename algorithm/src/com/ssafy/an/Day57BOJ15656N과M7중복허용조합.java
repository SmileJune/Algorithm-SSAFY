package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Day57BOJ15656N과M7중복허용조합 {
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
		comb(0);
		System.out.println(sb);
		br.close();
	}

	private static void comb(int d) {
		if (d == M) {
			sb.append(Arrays.toString(sel).replaceAll("[\\[\\],]", "").trim()).append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			sel[d] = arr[i];
			comb(d + 1);
		}
	}
}
