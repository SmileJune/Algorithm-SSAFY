package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day68BOJ14503로봇청소기구현 {
	static int N, M, ans;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;

		st = new StringTokenizer(br.readLine());
		int rdx = Integer.parseInt(st.nextToken());
		int cdx = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean(rdx, cdx, dir);
		
		System.out.println(ans);
		br.close();
	}

	private static void clean(int r, int c, int d) {
		if (map[r][c] == 0) {
			map[r][c] = 2;
			ans++;
		}
		boolean flag = false;
		int tmp = d;// 원본 임시 저장, 후진용
		for (int i = 0; i < 4; i++) {
			int nd = (d + 3) % 4;
			int nr = r + dr[nd];
			int nc = c + dc[nd];
			if (map[nr][nc] == 0) {
				clean(nr, nc, nd);
				flag = true;
				break;
			} // 왼쪽방향 우선 탐색 후 방향이 결정되면 해당방향으로 진행
			d = (d + 3) % 4; // 조건문에서 반복이 종료되지 않으면, 방향변경
		}

		// 다음 방향을 잡지 못하고, 4회 왼쪽으로 돌고 종료되었으면
		if (!flag) {
			int nd = (tmp + 2) % 4;
			int nr = r + dr[nd];
			int nc = c + dc[nd];
			if (map[nr][nc] != 1)
				clean(nr, nc, tmp);
		}
	}
}
