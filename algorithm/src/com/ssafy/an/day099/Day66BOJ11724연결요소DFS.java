package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day66BOJ11724연결요소DFS { // 11724 연결요소, 크루스칼도 가능할 듯
	static int N, M, ans;
	static boolean[] visited;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;

		visited = new boolean[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) {
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
		br.close();
	}

	private static void dfs(int idx) {
		if (visited[idx])
			return;
		visited[idx] = true;
		for (int i : list[idx])
			dfs(i);
	}
}
