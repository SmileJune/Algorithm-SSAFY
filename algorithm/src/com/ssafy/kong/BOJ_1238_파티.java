package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1238_파티 {
	static int N, M, X;

	static class Node {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static List<Node>[] adjList;
	static int[] dist;
	static int INF = 1000001;
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생의 수 ( 정점의 수 )
		M = Integer.parseInt(st.nextToken()); // 간선의 수
		X = Integer.parseInt(st.nextToken()) - 1; // 만나기로 한 마을

		adjList = new ArrayList[N];
		for (int i = 0; i < N; ++i) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int t = Integer.parseInt(st.nextToken()); // 도로를 지나는데 필요한 소요시간
			adjList[s].add(new Node(e, t));
		}
		ans = new int[N];
		for (int i = 0; i < N; ++i) {
			if (i != X) {
				dijkstra(i);
				ans[i] += dist[X];
			}
		}
		dijkstra(X);
		for (int i = 0; i < N; ++i) {
			ans[i] += dist[i];
		}

		Arrays.sort(ans);
		System.out.println(ans[N - 1]);

	}

	private static void dijkstra(int st) {
		dist = new int[N];
		Arrays.fill(dist, INF);
		boolean[] visited = new boolean[N];
		dist[st] = 0;
		for (int i = 0; i < N - 1; ++i) {
			int minIdx = -1;
			int minValue = INF;
			for (int j = 0; j < N; ++j) {
				if (!visited[j] && minValue > dist[j]) {
					minValue = dist[j];
					minIdx = j;
				}
			}
			if (minIdx == -1)
				break;
			visited[minIdx] = true;

			for (int j = 0; j < adjList[minIdx].size(); ++j) {
				Node now = adjList[minIdx].get(j);
				if (!visited[now.v] && dist[now.v] > dist[minIdx] + now.w) {
					dist[now.v] = dist[minIdx] + now.w;
				}
			}
		}
	}

}
