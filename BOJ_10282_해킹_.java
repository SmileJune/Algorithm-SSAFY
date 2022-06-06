package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10282_해킹_ {

	static class info {
		int end, time;

		public info(int end, int time) {
			super();
			this.end = end;
			this.time = time;
		}

	}

	static int INF = Integer.MAX_VALUE;
	static boolean[] visited;
	static List<info> list[];
	static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list = new ArrayList[n + 1];
			distance = new int[n + 1];
			visited = new boolean[n + 1];

			for (int i = 1; i <= n; i++)
				list[i] = new ArrayList<>();

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				list[b].add(new info(a, s));
			}

			Arrays.fill(distance, INF);
			distance[c] = 0;

			int min, current = 0;
			for (int i = 0; i < n; i++) {
				min = Integer.MAX_VALUE;
				current = -1;
				for (int j = 1; j < n + 1; j++) {
					if (!visited[j] && distance[j] < min) {
						min = distance[j];
						current = j;
					}
				}
				if (current == -1)
					break;

				for (info next : list[current]) {
					if (!visited[next.end] && distance[next.end] > distance[current] + next.time) {
						distance[next.end] = distance[current] + next.time;
					}
				}
				visited[current] = true;
			}

			int count = 0, max = 0;
			for (int i = 1; i < distance.length; i++) {
				if (distance[i] != INF) {
					count++;
					max = Math.max(max, distance[i]);
				}

			}
			sb.append(count + " " + max + "\n");
		}
		System.out.println(sb.toString());
	}

}