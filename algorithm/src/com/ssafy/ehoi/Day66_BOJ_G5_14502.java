package com.ssafy.ehoi;

import java.util.Scanner;

public class Day66_BOJ_G5_14502 {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int N, M, map[][], copy[][], ans;
	static Node[] sel;
	static boolean[][] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ans = 0;
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		sel = new Node[3]; // 무조건 벽 세개!
		com(0);

//		System.out.println(Arrays.deepToString(copy));
		System.out.println(ans);

		sc.close();
	}

	private static void com(int cnt) {
		if (cnt == 3) {
			// 여기서 map 카피
			copy = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copy[i][j] = map[i][j];
				}
			}

			// 뽑은 거에 따라서 그 좌표에 벽 세우기
			for (int i = 0; i < 3; i++) {
				copy[sel[i].x][sel[i].y] = 1;
			}
			// 그럼 이제 바이러스가 돌아다니겠지?
			virus();
			// 다 퍼뜨리고 왔다 그럼 이제 세어볼까?

			ans = Math.max(ans, count());

			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visit[i][j] && map[i][j] == 0) {
					sel[cnt] = new Node(i, j);
					visit[i][j] = true;
					com(cnt+1);
					visit[i][j] = false;
				}
				
			}
		}
	}

	private static int count() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 0)
					cnt++;

			}
		}
		return cnt;
	}

	private static void virus() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 2) { // 바이러스를 만나면 걔네들이 이제 0을 다 2로 바꾼다
					dfs(i, j);
				}
			}
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void dfs(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;
			if (copy[nr][nc] != 0)
				continue; // 빈칸이 아니면 소용없어

			copy[nr][nc] = 2; // 2로 바꾸고
			dfs(nr, nc); // 다시 퍼뜨리러 가자 히히
		}
	}
	
	
}
