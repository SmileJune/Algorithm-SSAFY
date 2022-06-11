package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_5972_택배배송 {
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

	static final int INF = Integer.MAX_VALUE;
	static int N, M;
	static List<Node>[] adjList; // 인접 리스트
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 0번부터 쓸거에요.
		M = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}

		dist = new int[N];
		Arrays.fill(dist, INF);

		// 간선 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			adjList[s].add(new Node(e, w));
			adjList[e].add(new Node(s, w));
		}

		dijkstra(0);

		System.out.println(dist[N - 1]);

	}

	static void dijkstra(int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		// 박문철2
		boolean[] visited = new boolean[N];

		pq.add(new Node(st, 0));
		// 시작 노드까지의 거리는 0
		dist[st] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll(); // 하나꺼내.

			if (visited[curr.v])
				continue;
			visited[curr.v] = true; // 선택한걸로치고

			// 뽑은 curr으로 부터 출발해서 도착할 수 있는 모든 정점들에 대하여
			for (Node node : adjList[curr.v]) {
				// 이미 알고 있는 거리보다 더 가깝게 도달 할 수 있다면
				if (!visited[node.v] && dist[node.v] > dist[curr.v] + node.weight) {
					dist[node.v] = dist[curr.v] + node.weight;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}

		}

	}
}
