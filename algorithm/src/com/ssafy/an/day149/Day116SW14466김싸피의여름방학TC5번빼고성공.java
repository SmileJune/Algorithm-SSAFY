package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day116SW14466김싸피의여름방학TC5번빼고성공 { // 14466 김싸피의 여름방학
	// tc5 138600 빼고 나머지는 구할 수 있는 문제..
	static int N, M, K, D, blk, ans;
	static String DD;
	static int[] car;
	static int[][] map;
	static List<int[]> blks;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			blk = 0;
			blks = new ArrayList<>();
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					char c = str.charAt(j);
					if (c == '*')
						map[i][j] = -2;
					else if (c == '_') {
						map[i][j] = -1;
						blk++;
						blks.add(new int[] { i, j });
					} else
						map[i][j] = c - '0';
				}
			}
			K = Integer.parseInt(br.readLine());
			car = new int[K];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++)
				car[i] = Integer.parseInt(st.nextToken());

			DD = "";
			D = Integer.parseInt(br.readLine());
			switch (D) {
			case 1:
				DD = "16";
				break;
			case 2:
				DD = "27";
				break;
			case 3:
				DD = "38";
				break;
			case 4:
				DD = "49";
				break;
			case 5:
				DD = "50";
				break;
			default:
				DD = "1234567890";
				break;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == -1) {
						map[i][j] = car[0];
						recur(1, 1, i, j, 0);
						map[i][j] = -1;
					}
				}
			}
			sb.append("#" + tc + " ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void recur(int d, int b, int idx, int jdx, int visit) {
		if (d == K) {
//			print(map);
			int tmp = cal();
			ans = Math.min(ans, tmp);
			return;
		}
		if (b == blk)
			return;

		for (int i = 0; i < blks.size(); i++) {
			int nr = blks.get(i)[0];
			int nc = blks.get(i)[1];
			if (map[nr][nc] != -1)
				continue;
			if ((visit & 1 << i) > 0)
				continue;
			recur(d, b + 1, nr, nc, visit | 1 << i);
			map[nr][nc] = car[d];
			recur(d + 1, b + 1, nr, nc, visit | 1 << i);
			map[nr][nc] = -1;
		}
	}
	// 맵 세팅 시마다

	private static int cal() {
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > -1) {
					int cost = 12000;
					if (DD.contains(map[i][j] + ""))
						cost = 10000;
					if (check(i, j))
						cost *= 0.9; // 0.9 곱해도 9000 or 10800
					res += cost;
				}
			}
		}
		return res;
	}

	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static boolean[][] visit;
	static Queue<int[]> q;

	private static boolean check(int idx, int jdx) {
		visit = new boolean[N][M];
		q = new LinkedList<>();

		int c = map[idx][jdx];
		int cnt = 0;

		visit[idx][jdx] = true;
		q.add(new int[] { idx, jdx });

		while (!q.isEmpty()) {
			int[] a = q.poll();
			if (cnt > 1)
				break;
			for (int i = 0; i < 4; i++) {
				int nr = a[0] + dr[i];
				int nc = a[1] + dc[i];
				if (index(nr, nc) || map[nr][nc] != c || visit[nr][nc])
					continue;
				visit[nr][nc] = true;
				q.add(new int[] { nr, nc });
				cnt++;
			}
		}
		return cnt > 1;
	}

	private static boolean index(int r, int c) {
		return r < 0 || c < 0 || r >= N || c >= M;
	}

//	private static void print(int[][] a) {
//		StringBuilder tt = new StringBuilder();
//		tt.append("********* ********\n");
//		for (int i = 0; i < a.length; i++) {
//			for (int j = 0; j < a[i].length; j++) {
//				tt.append(a[i][j]).append(" ");
//			}
//			tt.append("\n");
//		}
//		System.out.print(tt);
//	}
}
