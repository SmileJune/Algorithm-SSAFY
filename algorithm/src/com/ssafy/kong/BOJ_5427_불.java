package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427_불 {
	static Queue<Dot> fire, my;
//	static Dot myDot;
	static int W, H, ans;
	static boolean flag;
	static char[][] map;
	static int[][] cnt;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int fireCnt, tmpFire, myCnt, tmpMy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			fire = new LinkedList<Dot>();
			my = new LinkedList<Dot>();
			fireCnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			cnt = new int[H][W];
			for (int i = 0; i < H; ++i) {
				String str = br.readLine();
				for (int j = 0; j < W; ++j) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '*') {
						fire.add(new Dot(i, j));
						fireCnt++;
					}
					if (map[i][j] == '@') {
						my.add(new Dot(i, j));
						myCnt = 1;
					}
				}
			}
			ans = 0;
			flag = false;
			BFS();
			if (flag)
				System.out.println(ans + 1);
			else
				System.out.println("IMPOSSIBLE");
		}
	}

	static void BFS() {
		while (!my.isEmpty()) {
			
			if (!fire.isEmpty()) {
				tmpFire = 0;
				for (int idx = 0; idx < fireCnt; ++idx) {
					Dot Dot = fire.poll();
					for (int i = 0; i < 4; ++i) {
						int nr = Dot.r + dr[i];
						int nc = Dot.c + dc[i];
						if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
							if (map[nr][nc] != '#' && map[nr][nc] != '*') {
								fire.add(new Dot(nr, nc));
								tmpFire++;
								map[nr][nc] = '*';
							}
						}
					}
				}
			}
			tmpMy = 0;
			for (int idx = 0; idx < myCnt; ++idx) {
				Dot myDot = my.poll();
				for (int i = 0; i < 4; ++i) {
					int nr = myDot.r + dr[i];
					int nc = myDot.c + dc[i];
					if (!(nr >= 0 && nr < H && nc >= 0 && nc < W)) {
						flag = true;
						ans = cnt[myDot.r][myDot.c];
						return;
					}
					if (map[nr][nc] == '.' && map[nr][nc] != '@') {
						cnt[nr][nc] = cnt[myDot.r][myDot.c] + 1;
						map[nr][nc] = '@';
						tmpMy++;
						my.add(new Dot(nr, nc));
					}
				}
			}

			fireCnt = tmpFire;
			myCnt = tmpMy;

		}
	}
}
