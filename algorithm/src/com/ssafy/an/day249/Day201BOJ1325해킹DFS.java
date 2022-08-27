package com.ssafy.an.day249;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Day201BOJ1325해킹DFS {
	static ArrayList<Integer>[] graph;
	static int depth, max;
	static int[] ans;
	static boolean[] isPossible;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		int N = stoi(s[0]);
		int M = stoi(s[1]);
		ans = new int[N + 1];
		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] s2 = br.readLine().split(" ");
			int A = stoi(s2[0]);
			int B = stoi(s2[1]);

			graph[A].add(B);
		}

		for (int i = 1; i <= N; i++) {
			isPossible = new boolean[N + 1];
			isPossible[i] = true;
			BFS(i);
		}
		int max = 0;

		for (int i = 1; i <= N; i++) {
			max = Math.max(max, ans[i]);
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			if (ans[i] == max) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb.toString().trim());

	}

	static void BFS(int curNode) {
		Queue<Integer> q = new LinkedList<>();
		q.add(curNode);
		isPossible[curNode] = true;

		while (!q.isEmpty()) {
			curNode = q.remove();
			for (int next : graph[curNode]) {
				if (!isPossible[next]) {
					ans[next]++;
					isPossible[next] = true;
					q.add(next);
				}
			}
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
