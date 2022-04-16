package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2056_작업 {
	static List<Integer>[] adjList;
	static int[] degree;
	static int N;
	static int[] time;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N + 1];
		degree = new int[N + 1];
		time = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			adjList[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int s = 1; s <= N; ++s) {
			st = new StringTokenizer(br.readLine());
			time[s] = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; ++i) {
				int e = Integer.parseInt(st.nextToken());
				adjList[s].add(e);
				degree[e]++;
			}
		}

		System.out.println(topological());
	}

	static int topological() {
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			result[i] = time[i];
			if (degree[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int now = q.remove();
			for (int next : adjList[now]) {
				degree[next]--;
				result[next] = Math.max(result[next], result[now] + time[next]);
				if (degree[next] == 0) {
					q.add(next);
				}
			}
		}

		int ans = 0;
		for (int i = 1; i <= N; ++i) {
			ans = Math.max(ans, result[i]);
		}
		return ans;
	}
}
