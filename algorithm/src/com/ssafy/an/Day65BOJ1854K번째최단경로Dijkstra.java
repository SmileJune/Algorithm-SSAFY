package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day65BOJ1854K번째최단경로Dijkstra { // 1854 K번째 최단경로
	static final int INF = 1 << 30;
	static int N, M, K;
	static PriorityQueue<Integer>[] dist;
	static List<int[]>[] list;
	static PriorityQueue<int[]> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); // 도시
		M = Integer.parseInt(st.nextToken()); // 간선
		K = Integer.parseInt(st.nextToken()); // K번째 최단 경로

		dist = new PriorityQueue[N + 1]; // 최소힙 관리
		list = new ArrayList[N + 1];
		pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));

		for (int i = 1; i < N + 1; i++) {
			dist[i] = new PriorityQueue<>(); // 최단 경로가 아닌, K번째 찾기
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[p].add(new int[] { c, w });
		}

		pq.add(new int[] { 1, 0 }); // 1번 마을, 누적합 0
		dist[1].add(0); // 1번 마을에 최소힙으로 경로 쌓기

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			for (int[] next : list[cur[0]]) {
				if (dist[next[0]].size() < K) {
					dist[next[0]].add((cur[1] + next[1]) * -1);
					pq.add(new int[] { next[0], cur[1] + next[1] });
				} else if (dist[next[0]].peek() * -1 > cur[1] + next[1]) {
					dist[next[0]].poll();
					dist[next[0]].add((cur[1] + next[1]) * -1);
					pq.add(new int[] { next[0], cur[1] + next[1] });
				} // K개 빼고는 버리고, pq에 추가
			}
		}
		
		for (int i = 1; i < N + 1; i++) {
			if (dist[i].size() == K)
				sb.append(dist[i].peek() * -1).append("\n");
			else
				sb.append(-1).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
