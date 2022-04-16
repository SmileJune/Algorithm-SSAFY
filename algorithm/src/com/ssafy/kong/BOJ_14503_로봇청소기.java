package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
	static int N, M;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Loc {
		int r, c, dir;

		public Loc(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}

	static Loc robot;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		robot = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		clean = new boolean[N][M];
		// r위치, c위치, dir 방향
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 둘째줄에 로봇청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d가 주어진다.
		// d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있는 것이다.
		// 빈칸은 0, 벽은 1. 지도의 첫 행, 첫 열, 마지막 열에 있는 모든 칸은 벽이다.
		explore(robot.r, robot.c, 0);
		// 정답은 로봇청소기가 청소하는 칸이다.

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (clean[i][j]) {
					ans++;
				}
			}
		}
		System.out.println(ans);

	}

	static boolean[][] clean;

	// 재귀로 탐색해봐야겠다
	private static void explore(int r, int c, int cnt) {
		clean[r][c] = true;
		if (cnt == 4) {
			// 청소, 후진하지 않고 네번 연속으로 실행됐을 경우, 바로 뒤쪽이 벽쪽이면 작동 멈추기.
			// 0 -> 2가 되어야 하고, 1 -> 3, 2 -> 0, 3 -> 1.
			int dir = (robot.dir + 2) % 4;
			int nr = dr[dir] + r;
			int nc = dc[dir] + c;
			if (map[nr][nc] == 1) {
				// 바로 뒤가 벽이라면
				return;
			} else {
				// 바로 뒤가 벽이 아니라면 후진해! (방향을 바꾸지는 않앙)
				explore(nr, nc, 0);
				return;
			}
		}
		// 왼쪽을 봐!
		int dir = (robot.dir == 0 ? 3 : robot.dir - 1);
		// dr[0] : 북, dr[1] : 동, dr[2] : 남, dr[3] : 서
		// 북쪽을 보고있는 로봇청소기의 왼쪽은 서쪽. 동쪽을 보고 있는 로봇청소기의 왼쪽은 북. 내가 보는 방향의 -1을 해주면 된다.
		int nr = dr[dir] + r;
		int nc = dc[dir] + c;
		if (map[nr][nc] == 0 && !clean[nr][nc]) {
			// 왼쪽을 봤더니 아직 청소하지 않은 빈 공간이 존재해? 왼쪽 방향으로 회전하고 한칸을 전진해!
			robot.dir = dir;
			explore(nr, nc, 0);
		} else if (map[nr][nc] == 1 || (map[nr][nc] == 0 && clean[nr][nc])) {
			// 왼쪽을 봤더니 벽이이거나, 이미 청소된 공간이야? 왼쪽 방향으로 회전해!
			robot.dir = dir;
			explore(r, c, cnt + 1);
		}
	}
}
