package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day116BOJ2042세그먼트트리공부용 { // 2042 구간 합 segment tree 공부용..
	static int N, M, K;
	static long[] arr, tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new long[N + 1];
		for (int i = 1; i < N + 1; i++)
			arr[i] = Long.parseLong(br.readLine());

		// tree의 사이즈를 구하는 방법
		// 1. 2^k >= N인 최소 k를 찾는다.
		// 2 k >= log N / log 2 를 올림, 더하기 1

		int k = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
		int size = (int) Math.pow(2, k);
		// tree = new long[N * 4]; // 그냥 무지성으로 4를 곱해도.. 
		tree = new long[size];

		init(1, N, 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				long dif = c - arr[b];
				arr[b] = c;
				update(1, N, 1, b, dif);
			} else if (a == 2)
				sb.append(sum(1, N, 1, b, (int) c) + "\n");
		}

		System.out.println(sb);
		br.close();
	}

	private static long init(int st, int ed, int node) {
		if (st == ed)
			return tree[node] = arr[st];
		int mid = (st + ed) / 2;
		return tree[node] = init(st, mid, node * 2) + init(mid + 1, ed, node * 2 + 1);
	}

	public static long sum(int st, int ed, int node, int left, int right) {
		if (left > ed || right < st)
			return 0;

		if (left <= st && ed <= right)
			return tree[node];

		int mid = (st + ed) / 2;
		return sum(st, mid, node * 2, left, right) + sum(mid + 1, ed, node * 2 + 1, left, right);
	}

	private static void update(int st, int ed, int node, int idx, long dif) {
		if (idx < st || idx > ed)
			return;
		tree[node] += dif;
		if (st == ed)
			return;

		int mid = (st + ed) / 2;
		update(st, mid, node * 2, idx, dif);
		update(mid + 1, ed, node * 2 + 1, idx, dif);
	}
}
