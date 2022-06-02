package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Day17BOJ1966프린트큐 { // 1966
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		LinkedList<int[]> q = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			q = new LinkedList<>();

			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				q.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
			}

			int ans = 0;
			while (!q.isEmpty()) {
				int[] front = q.poll();
				boolean isMax = true;
				for (int i = 0; i < q.size(); i++) {
					if (front[1] < q.get(i)[1]) {
						q.offer(front);
						for (int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						isMax = false;
						break;
					}
				}
				if (isMax == false) {
					continue;
				}
				ans++;
				if (front[0] == M) {
					break;
				}
			}
			sb.append(ans).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
