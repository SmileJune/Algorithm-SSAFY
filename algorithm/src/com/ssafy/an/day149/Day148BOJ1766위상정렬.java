package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day148BOJ1766위상정렬 {
	static int N, M;
	static int[] indegree;
	static List<Integer>[] graph;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		indegree = new int[N + 1];
		graph = new List[N + 1];
		for (int i = 0; i < N + 1; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			indegree[to] += 1;
		}

		PriorityQueue<Integer> PQ = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				PQ.offer(i);
			}
		}
		StringBuilder sb = new StringBuilder();

		while (!PQ.isEmpty()) {
			int num = PQ.poll();

			sb.append(num + " ");

			for (int n : graph[num]) {
				indegree[n] -= 1;
				if (indegree[n] == 0) {
					PQ.offer(n);
				}
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
