package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day50BOJ11725트리의부모 { // 11725 트리탐색
	static int N;
	static Node[] nodes;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		nodes = new Node[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			nodes[i] = new Node(i);
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes[a].adj.add(nodes[b]);
			nodes[b].adj.add(nodes[a]);
		}

		System.out.println(bfs().toString());

		br.close();
	}

	private static StringBuilder bfs() {
		StringBuilder sb = new StringBuilder();
		Queue<Node> q = new LinkedList<>();

		nodes[1].root = -1;
		q.add(nodes[1]);

		while (!q.isEmpty()) {
			Node now = q.poll();

			for (Node no : now.adj) {
				if (!visited[no.idx]) {
					visited[no.idx] = true;
					no.root = now.idx;
					q.add(no);
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			sb.append(nodes[i].root).append("\n");
		}
		
		return sb;
	}

	static class Node {
		int idx;
		int root;
		List<Node> adj;

		public Node(int idx) {
			this.idx = idx;
			this.root = 0;
			this.adj = new ArrayList<>();
		}
	}
}
