package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 위상 정렬 문제
public class Day71_BOJ_G5_14567 {
	static int V, E, indegree[], stage[];
	static List<Integer>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // 과목 개수
		E = Integer.parseInt(st.nextToken()); // 간선 개수
		indegree = new int[V + 1];
		stage = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			stage[i] = 1;
		}
		adjList = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) adjList[i] = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			adjList[s].add(e);
			indegree[e]++;
		}

		sort();

		for (int i = 1; i <=V ; i++) {
			System.out.print(stage[i] + " ");
		}
	}

	private static void sort() {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= V; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int next : adjList[curr]) {
				indegree[next]--;

				if (indegree[next] == 0) {
					stage[next] = stage[curr] + 1;
					q.add(next);
				}
			}
		}

	}
}
