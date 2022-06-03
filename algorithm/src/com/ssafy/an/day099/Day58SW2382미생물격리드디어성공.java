package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day58SW2382미생물격리드디어성공 { // SW 2382 미생물격리
	static int num = 0;

	static class Mic {
		int r, c, t, d;

		public Mic(int r, int c, int t, int d) {
			this.r = r;
			this.c = c;
			this.t = t;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Mic [r=" + r + ", c=" + c + ", t=" + t + ", d=" + d + "]";
		}

	}

	static int N, M, K, cnt;
	static int[] dr = { 0, -1, 1, 0, 0 }, dc = { 0, 0, 0, -1, 1 };
	static int[][] map;
	static List<Mic> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cnt = 0;
			map = new int[N][N];
			list = new ArrayList<>();

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				Mic mic = new Mic(r, c, t, d);
				list.add(mic);
				map[r][c]++;
			}

			while (M-- > 0) {
				move();
				mapping();
//				print(map);
				if (needMerge()) { // 맵에 1보다 큰 값들 추출
					merge(); // 해당 좌표 값인 군집 통합
					mapping();
				}
			}
			for (Mic m : list) {
				cnt += m.t;
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void print(int[][] a) {
		System.out.println("print : " + M);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void mapping() {
		map = new int[N][N];
		for (Mic m : list) {
			if (m.t == 0)
				continue;
			map[m.r][m.c]++;
		}
	}

	private static void move() {
		for (Mic m : list) {
			if (m.t == 0)
				continue;
			int nr = m.r + dr[m.d];
			int nc = m.c + dc[m.d];
			if (nr == 0) {
				m.t /= 2;
				m.d++;
			} else if (nr == N - 1) {
				m.t /= 2;
				m.d--;
			} else if (nc == 0) {
				m.t /= 2;
				m.d++;
			} else if (nc == N - 1) {
				m.t /= 2;
				m.d--;
			}
			m.r = nr;
			m.c = nc;
		}
	}

	private static void merge() {
		for (int[] a : tmp) {

			int idx = a[0];
			int jdx = a[1];

			int sumT = 0; // 총합
			int maxT = 0; // 젤 큰 애 비교용
			int maxD = 0; // 젤 큰 거 방향

			for (Mic m : list) {
				if (m.t == 0)
					continue;
				if (m.r == idx && m.c == jdx) {
					m.toString();
					sumT += m.t;
					if (maxT < m.t) {
						maxT = m.t;
						maxD = m.d;
					}

				}
			}

			for (int i = list.size() - 1; i >= 0; i--) {
				Mic m = list.get(i);
				if (m.r == idx && m.c == jdx) {
					list.remove(i);
				}
			}

			list.add(new Mic(idx, jdx, sumT, maxD));
		}
		tmp.clear();
	}

	static List<int[]> tmp;

	private static boolean needMerge() {
		tmp = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 1) {
					tmp.add(new int[] { i, j });
				}
			}
		}
		return tmp.size() != 0;
	}
}
