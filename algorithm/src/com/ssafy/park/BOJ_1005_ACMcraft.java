package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1005_ACMcraft {
	static int V, E, W;
	static List<Integer>[] adjList;
	static int[] time, zero, stacktime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			adjList = new ArrayList[V + 1];
			for (int i = 0; i < V + 1; i++) {
				adjList[i] = new ArrayList<>();
			}
			zero = new int[V + 1];
			time = new int[V + 1];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= V; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				adjList[s].add(e);
				zero[e]++;
			}
			W = Integer.parseInt(br.readLine());
			stacktime = new int[V + 1];
			TopologicalSort();
			sb.append(stacktime[W] + "\n");
		}
		System.out.println(sb);
	}

	private static void TopologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < zero.length; i++) {
			if (zero[i] == 0) {
				stacktime[i] = time[i];
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int current = q.poll();

			for (int i = 0; i < adjList[current].size(); i++) {
				int next = adjList[current].get(i);
				stacktime[next] = Math.max(stacktime[current] + time[next], stacktime[next]);
				zero[next]--;
				if (zero[next] == 0)
					q.offer(next);
			}
		}
	}
}
