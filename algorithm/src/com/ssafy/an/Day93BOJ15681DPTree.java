package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day93BOJ15681DPTree { // 15681
	static int N, R, Q;
	static Integer[] dp;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		dp = new Integer[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		recur(R, -1); // root 의 parent -1

		for (int i = 0; i < Q; i++)
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");

		System.out.println(sb);
		br.close();
	}

	private static int recur(int c, int p) {
		if (dp[c] == null) {
			dp[c] = 1; // 본인 포함 트리크기
			for (int i : list[c]) // 연결된 노드 중에
				if (p != i) // 부모가 아닌(트리)
					dp[c] += recur(i, c);
		}
		return dp[c];
	}
}
