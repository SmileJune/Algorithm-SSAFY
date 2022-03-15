package com.ssafy.kong;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질 {
	static int[] move = { -1, 1 };
	static int N, K;
	static boolean[] visited = new boolean[100001];
	static int[] map = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		BFS();
		System.out.println(map[K]);
	}

	static void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		map[N] = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < 3; ++i) {
				int next = 0;
				if (i < 2) {
					next = now + move[i];
				} else {
					next = now * 2;
				}
				if (now == K) {
					return;
				}
				if (next <= 100000 && next >= 0) {
					if (map[next] == 0) {
						map[next] = map[now] + 1;
						q.add(next);
					}
				}
			}
		}
	}
}