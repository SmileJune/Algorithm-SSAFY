package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day65_BOJ_G4_1504 {
	static class Node implements Comparable<Node> {
		int st, ed, dist;

		public Node(int ed, int dist) {
			this.ed = ed;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}

	}

	static int V, E;
	static int[][] dist;
	static boolean[] visit;
	static List<Node>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 모두 초기화
		dist = new int[V + 1][V + 1];
		adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
			for (int j = 1; j <= V; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			adjList[s].add(new Node(e, d));
			adjList[e].add(new Node(s, d));
		}

		// 꼭 지나쳐야 하는 두 정점
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		// 입력 끝!

		// dist 2차원배열의 특징 [현재 정점][다음 정점]의 거리가 저장됨

		dijkstra(1);
		dijkstra(v1);
		dijkstra(v2);
		
		// 1번 - v1 - v2 - N
		int sum1 = dist[1][v1] + dist[v1][v2] + dist[v2][V];
		// 1번 - v2 - v1 - N
		int sum2 = dist[1][v2] + dist[v2][v1] + dist[v1][V];

		int ans = 0;
		if (dist[1][v1] == Integer.MAX_VALUE || dist[1][v2] == Integer.MAX_VALUE
				|| dist[1][V] == Integer.MAX_VALUE) {
			ans = -1;
		} else {
			ans = Math.min(sum1, sum2);
		}

		// dist배열이 무한대라는 것은 거기에 도착하지 못했다는 것! 간선이 연결되어있지 않다는 것!
		System.out.println(ans);

	}

	private static void dijkstra(int st) {
		// 방문 배열 초기화
		visit = new boolean[V + 1];

		// 시작 정점에 대한 거리를 0으로 초기화 해서 pq에 넣으면 가장 먼저 걸리게 설정을 해줘야지
		dist[st][st] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(st, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			// curr에서 진출해야 하는 정점 ed 방문 체크
			if (visit[curr.ed])
				continue;
			visit[curr.ed] = true;

			// 거리 갱신
			for (Node next : adjList[curr.ed]) {
				if (!visit[next.ed] && dist[st][next.ed] > dist[st][curr.ed] + next.dist) {
					dist[st][next.ed] = dist[st][curr.ed] + next.dist;
					pq.add(new Node(next.ed, dist[st][next.ed]));
				}
			}
		}
	}
}

// 무방향 그래프
// 1번 정점에서 N번 정점으로 최단 거리로 이동 
// -- 정점은 N+1로 만들 것
// -- 최단 거리로 이동
// -- 조건 : 임의로 주어진 두 정점을 반드시 통과해야 한다는 것
// 한번 갔던 곳을 다시 갈 수도 있지만 -> visited 안 써도 되겠다 -> 놉 써야함 근데 대신 2차원 배열 이용할 거임
// 반드시 최단 경로로 이동해야 함
// 