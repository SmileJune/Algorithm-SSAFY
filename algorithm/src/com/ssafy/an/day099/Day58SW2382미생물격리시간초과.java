package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Day58SW2382미생물격리시간초과 { // SW 2382 미생물격리
	static int num = 0;

	static class Mic {
		int id;
		int r, c, t, d;
		boolean live;

		public Mic(int r, int c, int t, int d) {
			this.id = num++;
			this.r = r;
			this.c = c;
			this.t = t;
			this.d = d;
			this.live = false;
		}

		@Override
		public String toString() {
			return "Mic [id=" + id + ", r=" + r + ", c=" + c + ", m=" + t + ", d=" + d + "]";
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
			for (int i = 0; i < N; i++) {
				Arrays.fill(map[i], -1);
			}
			list = new ArrayList<>();

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				Mic mic = new Mic(r, c, t, d);
				list.add(mic);
				map[r][c] = mic.id;
			} // K개 군집 정보 저장, 현재 위치 체크

			while (M-- > 0) { // 진행, 반응, 현재 개수 저장
//				print(map);
				move();
				react();
			}
			count();
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	// 처음 가장자리에 놓아서 시작하는 경우 없음.
	// 후에 가장자리에 놓이더라도, react에서 진행방향 바꿈.
	// -> 따라서, 이동할 때는 범위체크 필요없음.
	private static void move() {
		for (Mic m : list) {
			if (m.live)
				continue;
//			if (map[m.r][m.c] == m.id)
//				map[m.r][m.c] = -1;

			m.r = m.r + dr[m.d]; // 위치 변경
			m.c = m.c + dc[m.d];

//			System.out.println(++eee + " : " + m.toString());
			if (map[m.r][m.c] == -1)
				map[m.r][m.c] = m.id;
			else
				map[m.r][m.c] -= 10000;
		} // 군집이 한장소에 겹쳐봤자 4개가 동시에 오는 것밖에 없음.
	}
	// 마주보고 있는 상태에서 움직일때 교차하면 정상이동됨.
	// 이동 후에 겹쳐져 있을 때 합쳐지고, 이동방향이 결정됨.

	private static void react() {
		for (Mic m : list) {
			if (m.live)
				continue;

			if (map[m.r][m.c] < -1) { // 내가 위치한 자리가 -10000이면 2개 겹침
				merge(m.r, m.c); // 합치기 처리
			}
			if (m.r == 0 || m.r == N - 1 || m.c == 0 || m.c == N - 1) {
				m.t /= 2; // 절반으로 감소
				if (m.d % 2 == 0)
					m.d--;
				else
					m.d++;
			} // 가장자리에 올 수 있는 방법은 1방향 밖에 없음.
		}
	}

	private static void merge(int idx, int jdx) {
		// 먼저 온 애 id가 999 이고, 1 ~ 3군집이 더 도착하면
		// -9001, -19001, -29001
		// 먼저 온 애 id가 0이고, 1~3군집이 더 도착하면
		// -10000, -20000, -30000
		// 즉, 양수로 바꾸고, 군집id의 최대값을 더하고,
		// 10000으로 나눈 값에 1을 더하면 현재 위치에 겹친 군집에 갯수
//		int c = ((map[idx][jdx] * -1) + 1000) / 10000 + 1;
//		int[] tmp = new int[c];// id기억용
		List<Integer> tmp = new ArrayList<>();
		int i = -1;
		int sum = 0;
		int mid = -1;
		int max = 0;

		for (Mic m : list) {
			if (m.live)
				continue;
			if (m.r == idx && m.c == jdx) {
				tmp.add(m.id); // id기억
				sum += m.t; // 최종 군집에 들어갈 값
				if (m.t > max) {
					max = m.t;
					mid = m.id;
				} // 최대값 기억
			}
		}

		// 최대값으로 바꾸고
		for (Mic mic : list) {
			if (mic.id == mid) {
				mic.t = sum;
				continue; // 최대값인 id는 살리고
			}
			for (int id : tmp) {
				if (mic.id == id) {
					mic.live = true;
					mic.t = 0;
				}
			} // 나머지는 list에서 제거, 오류나면 mic.m = 0으로..
		}
	}

	private static void count() {
		for (Mic m : list) {
			if (m.live)
				continue;
			cnt += m.t;
		}
	}

	private static void print(int[][] a) {
		System.out.println("print==");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}

	static int eee = 0;
}
