package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day132BOJ1967트리의지름DFS { // 1967 트리의 지름
	static int N, ans, midx;
	static List<int[]>[] nodes;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		ans = 0;
		midx = 0;
		nodes = new ArrayList[N];
		for (int i = 0; i < N; i++)
			nodes[i] = new ArrayList<>();

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			nodes[u].add(new int[] { v, c });
			nodes[v].add(new int[] { u, c });
		}
		// 부모노드부터 가장 멀리 있는 노드
		visited = new boolean[N];
		visited[0] = true;
		dfs(0, 0);
		// 가장 멀리 있는 노드에서 가장 멀리 있는 노드
		visited = new boolean[N];
		visited[midx] = true;
		dfs(midx, 0);

		System.out.println(ans);
		br.close();
	}

	private static void dfs(int idx, int sum) {
		if (ans < sum) {
			ans = sum;
			midx = idx;
		}
		for (int[] a : nodes[idx]) {
			int ed = a[0];
			int cost = a[1];
			if (!visited[ed]) {
				visited[ed] = true;
				dfs(ed, sum + cost);
			}
		}
	}
}
