package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day51BOJ1167트리의지름거리합 {
	static class Node {
		int idx;
		int d;

		Node(int idx, int d) {
			this.idx = idx;
			this.d = d;
		}
	}

	static List<Node>[] list;
	static boolean[] visited;
	static int node, ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int V = Integer.parseInt(br.readLine());
		list = new ArrayList[V + 1];
		for (int i = 1; i < V + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int v = 0; v < V; v++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int idx = Integer.parseInt(st.nextToken());
				if (idx == -1) break;
				int d = Integer.parseInt(st.nextToken());
				list[n].add(new Node(idx, d));
			}
		}
		visited = new boolean[V + 1];
		dfs(1, 0);
		visited = new boolean[V + 1];
		dfs(node, 0);
		System.out.println(ans);
		br.close();
	}

	private static void dfs(int x, int len) {
		if (len > ans) {
			ans = len;
			node = x;
		}
		visited[x] = true;
		for (Node n : list[x]) if (!visited[n.idx]) dfs(n.idx, n.d + len);
	}
}
