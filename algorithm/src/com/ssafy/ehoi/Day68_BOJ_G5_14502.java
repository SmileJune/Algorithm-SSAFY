package com.ssafy.ehoi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day68_BOJ_G5_14502 {
	static int N, M, map[][], copyMap[][], ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		copyMap = new int[N][M];
		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 벽 고르러 조합 보내자
		comb(0, 0, 0);

		System.out.println(ans);
		sc.close();

	}

	//
	private static void comb(int cnt, int r, int c) {
		if (cnt == 3) {
			// 이미 벽을 세우고 들어옴
			// 카피하자
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copyMap[i][j] = map[i][j];
				}
			}

			// 바이러스 퍼뜨리러 가야지
			virus();
			
			// 이제 0인 애들 세자
			ans = Math.max(ans, count());

			return;
		}

		// 그 행의 친구들부터 탐색
		for (int j = c; j < M; j++) {
			if (map[r][j] == 0) {
				map[r][j] = 1;
				comb(cnt + 1, r, j);
				map[r][j] = 0; // 원상복귀
			}
		}

		for (int i = r + 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					comb(cnt + 1, i, j);
					map[i][j] = 0;
				}
			}
		}
	}

	private static int count() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copyMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	// 이거를 bfs로 하는 거임
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void virus() {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 2) {
					q.add(new Node(i, j));
					visit[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			Node n = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc])
					continue;
				if (copyMap[nr][nc] != 0)
					continue;
				
				copyMap[nr][nc] = 2;
				q.add(new Node(nr, nc));
				visit[nr][nc] = true;
			}

		}

	}
}
