package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1504_특정한최단경로 {
	static int N, E;

	static class Node {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static List<Node>[] adjList; // 인접리스트
	static int[] dist;
	static final int INF = 200000000;
	static int v1, v2;
	static boolean visitV1, visitV2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수

		adjList = new ArrayList[N];
		for (int i = 0; i < N; ++i) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			adjList[s].add(new Node(e, w));
			adjList[e].add(new Node(s, w));
			// 인접리스트에 넣어준다. 무향그래프는 양쪽에 넣어준다.
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken()) - 1;
		v2 = Integer.parseInt(st.nextToken()) - 1;

		int ans1 = 0;
		ans1 += dijkstra(0, v1);
		ans1 += dijkstra(v1, v2);
		ans1 += dijkstra(v2, N - 1);

		int ans2 = 0;
		ans2 += dijkstra(0, v2);
		ans2 += dijkstra(v2, v1);
		ans2 += dijkstra(v1, N - 1);
		long ans = Math.min(ans1, ans2);
		if (ans >= INF) {
			ans = -1;
		}

		System.out.println(ans);
	}

	private static int dijkstra(int st, int ed) {

		dist = new int[N];
		Arrays.fill(dist, INF);
		boolean[] visited = new boolean[N];

		// 시작 노드까지의 거리는 0
		dist[st] = 0;

		for (int i = 0; i < N - 1; ++i) {
			int minIdx = -1;
			int minValue = INF;
			// 선택하지 않은 정점 중 dist가 가장 짧은 것을 골라라.
			for (int j = 0; j < N; ++j) {
				if (!visited[j] && minValue > dist[j]) {
					minValue = dist[j];
					minIdx = j;
				}
			}

			// 연결되지 않은 경우도 있다.
			if (minIdx == -1) {
				break;
			}

			visited[minIdx] = true;
			for (int j = 0; j < adjList[minIdx].size(); ++j) {
				Node now = adjList[minIdx].get(j);
				if (!visited[now.v] && dist[now.v] > dist[minIdx] + now.w) {
					dist[now.v] = dist[minIdx] + now.w;
				}
			}
		}
		return dist[ed];

	}
}
