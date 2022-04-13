package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SW_1249_보급로 {
	static class Node {
		int idx, cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}

	static int N, V;
	static int[][] map;
	static List<int[]> list;
	static ArrayList<ArrayList<Node>> graph;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] dist;
	static PriorityQueue<Node> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			list = new ArrayList<>();
			V = N * N;
			;
			graph = new ArrayList<ArrayList<Node>>();
			for (int i = 0; i < V + 1; i++) {
				graph.add(new ArrayList<Node>());
			}
			makeNode();
			dist = new int[V + 1];
			for (int i = 0; i < V + 1; i++) {
				dist[i] = Integer.MAX_VALUE;
			}
			q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
			q.offer(new Node(1, 0));
			dist[1] = 0;
			find();
			sb.append("#" + tc + " " + dist[V] + "\n");
		}
		System.out.println(sb);
	}

	public static void makeNode() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					if (nr < 0 || nr == N || nc < 0 || nc == N)
						continue;
					int s = N * i + j + 1;
					int e = N * nr + nc + 1;
					int c = map[nr][nc];
					graph.get(s).add(new Node(e, c));
				}
			}
		}
	}

	public static void find() {
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp.idx == V) {
				return;
			}
			if (dist[temp.idx] < temp.cost) {
				continue;
			}
			for (int i = 0; i < graph.get(temp.idx).size(); i++) {
				Node nextNode = graph.get(temp.idx).get(i);
				if (dist[nextNode.idx] > temp.cost + nextNode.cost) {
					dist[nextNode.idx] = temp.cost + nextNode.cost;
					q.offer(new Node(nextNode.idx, dist[nextNode.idx]));
				}
			}
		}
	}
}
