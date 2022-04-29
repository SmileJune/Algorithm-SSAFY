package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day81BOJ2056작업위상정렬 { // 2056 작업 - 위상정렬 방법(더 느림.)
	static int N, ans;
	static int[] arr, idg; // indegree
	static List<Integer>[] wrk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		ans = 0;
		arr = new int[N];
		idg = new int[N];
		wrk = new ArrayList[N];
		for (int i = 0; i < N; i++)
			wrk[i] = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken()); // k번째 작업에 걸리는 시간
			int p = Integer.parseInt(st.nextToken()); // 선행되는 parent 수

			for (int j = 0; j < p; j++) {
				wrk[Integer.parseInt(st.nextToken()) - 1].add(i);
				idg[i]++;
			}
		}

		System.out.println(TopologicalSort());
		br.close();
	}

	static PriorityQueue<Integer> pq;

	private static int TopologicalSort() {
		pq = new PriorityQueue<>();
		int[] res = new int[N];
		for (int i = 0; i < N; i++) {
			res[i] = arr[i];
			if (idg[i] == 0)
				pq.offer(i);
		}
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			for (int n : wrk[cur]) {
				idg[n]--;
				res[n] = Math.max(res[n], res[cur] + arr[n]);
				if (idg[n] == 0)
					pq.add(n);
			}
		}
		for (int i = 0; i < N; i++)
			ans = Math.max(ans, res[i]);
		return ans;
	}
}
