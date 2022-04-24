package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	static int V, E, K;

	static class Node implements Comparable<Node> {
		int v, weight;

		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static List<Node>[] adjList;
	static final int INF = Integer.MAX_VALUE;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine()); // 시작점

		adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; ++i) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 1; i <= E; ++i) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[s].add(new Node(e, w));
		}
		dist = new int[V + 1];
		Arrays.fill(dist, INF);
		dijkstra(K);
		for (int i = 1; i <= V; ++i) {
			if (dist[i] == INF) {
				System.out.println("INF");
				continue;
			}
			System.out.println(dist[i]);
		}
	}

	private static void dijkstra(int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		// 박문철2
		boolean[] visited = new boolean[V+1];

		pq.add(new Node(st, 0));
		// 시작 노드까지의 거리는 0
		dist[st] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (visited[curr.v])
				continue;
			visited[curr.v] = true;

			for (Node node : adjList[curr.v]) {
				if (!visited[node.v] && dist[node.v] > dist[curr.v] + node.weight) {
					dist[node.v] = dist[curr.v] + node.weight;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}
	}
}
