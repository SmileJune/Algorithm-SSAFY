package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day69BOJ9370미확인도착지Dijkstra고정간선 {
	static final int INF = 1 << 30;
	static int N, M, T;
	static int S, G, H;
	static int[] des, d;
	static List<int[]>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			list = new ArrayList[N + 1];
			des = new int[T];

			for (int i = 1; i < N + 1; i++)
				list[i] = new ArrayList<>();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				list[s].add(new int[] { e, d });
				list[e].add(new int[] { s, d });
			}

			for (int i = 0; i < T; i++) {
				des[i] = Integer.parseInt(br.readLine());
			}
			
			pq = new PriorityQueue<>();

			for (int D : des) {
				long res1 = dijkstra(S, G) + dijkstra(G, H) + dijkstra(H, D);
				long res2 = dijkstra(S, H) + dijkstra(H, G) + dijkstra(G, D);
				long res = dijkstra(S, D); // G -> H, H -> G 경우와 최소 간선을 비교
				if (res == Math.min(res1, res2)) // 이부분 구선생님
					pq.add(D);
			}

			while (!pq.isEmpty()) {
				sb.append(pq.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static int dijkstra(int st, int ed) {
		d = new int[N + 1];
		Arrays.fill(d, INF);
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));

		pq.add(new int[] { st, 0 });
		d[st] = 0;
		while (!pq.isEmpty()) {
			int[] a = pq.poll();
			int curr = a[0];
			int dist = a[1];

			if (d[curr] < dist)
				continue;
			for (int i = 0; i < list[curr].size(); i++) {
				int idx = list[curr].get(i)[0];
				int cost = d[curr] + list[curr].get(i)[1];
				if (cost < d[idx]) {
					d[list[curr].get(i)[0]] = cost;
					pq.add(new int[] { idx, cost });
				}
			}
		}
		return d[ed]; // 최종 도착지에 누적합 반환
	}
}
