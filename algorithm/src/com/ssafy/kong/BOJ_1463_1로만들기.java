package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1463_1로만들기 {
	static int N, ans = 0;
	static int[] cnt;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = new int[N + 1];
		visited = new boolean[N + 1];
		bfs();
		for(int i = 0; i <= N; ++i) {
			System.out.print(visited[i] + " ");
		}
		System.out.println();
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		while (!q.isEmpty()) {
			int n = q.poll();
			if (n == 1) {
				System.out.println(cnt[1]);
				return;
			}
			if (n > 1) {
				if (n % 3 == 0 && !visited[n / 3]) {
					q.add(n / 3);
					cnt[n / 3] = cnt[n] + 1;
					visited[n / 3] = true;
				}
				if (n % 2 == 0 && !visited[n / 2]) {
					q.add(n / 2);
					visited[n / 2] = true;
					cnt[n / 2] = cnt[n] + 1;
				}
				if (!visited[n - 1]) {
					q.add(n - 1);
					visited[n-1] = true;
					cnt[n - 1] = cnt[n] + 1;
				}
			}
		}
	}
}
