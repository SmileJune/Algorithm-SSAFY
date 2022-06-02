package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day110BOJ16928뱀과사다리BFS { // 16928 뱀과 사다리 게임
	static int N, M;
	static int[] map, lad;
	static boolean[] visit;
	static Queue<Integer> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[101];
		lad = new int[101];
		visit = new boolean[101];

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			lad[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		q = new LinkedList<>();
		q.offer(1);
		map[1] = 0;
		visit[1] = true;
		while (!q.isEmpty()) {
			int c = q.poll();
			if (c == 100) break;
			for (int i = 1; i < 7; i++) {
				int n = c + i;
				if (n > 100) continue;
				if (visit[n]) continue;
				visit[n] = true;
				if (lad[n] != 0) {
					if (!visit[lad[n]]) {
						q.offer(lad[n]);
						visit[lad[n]] = true;
						map[lad[n]] = map[c] + 1;
					}
				} else {
					q.offer(n);
					map[n] = map[c] + 1;
				}
			}
		}

		System.out.println(map[100]);
		br.close();
	}
}
