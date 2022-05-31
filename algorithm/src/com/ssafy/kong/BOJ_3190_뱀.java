package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3190_뱀 {
	static int N, K, L;

	static int[][] direction, map;
	static int dir;

	static class Loc {
		int r, c;

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static Loc head, tail;
	static int time = 1;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<Integer> dirQ;

	public static void main(String[] args) throws IOException {
		input();
		// 입력완료
		solution();
		// 해결~
	}

	private static void solution() {

		dir = 1; // 처음이 오른쪽인데 내가 오른쪽을 1로 설정했으니 그냥 1로 설정하곘다.

		// 방향대로 가기
		goSnake();
		System.out.println(time);
	}

	private static void goSnake() {
		int idx = 0;
		outer: while (true) {

			for (int i = 0; i < 4; ++i) {
				if (dir == i) {
					int nr = head.r + dr[i];
					int nc = head.c + dc[i];
					head.r = nr;
					head.c = nc;
					if (nr <= 0 || nr > N || nc <= 0 || nc > N || map[nr][nc] == 1) {
						break outer;
					}
					dirQ.add(dir);
					if (map[nr][nc] == 2) {
						// 사과면
						map[nr][nc] = 0;
						// 그 칸에 있던 사과가 없어지고
					} else {
						// 사과가 아니면
						// 몸의 길이를 줄여서 꼬리가 위치한 칸을 지운다.
						int now = dirQ.poll();
						map[tail.r][tail.c] = 0;

						tail.r += dr[now];
						tail.c += dc[now];
					}
					map[nr][nc] = 1;
				}
			}
			if (idx < L && time == direction[idx][0]) {
				// 지금 시간이 방향을 꺾을 시간이 된다면 방향을 말그대로 꺾는거지 오른쪽왼쪽만 있는게 아니야!!
				dir += direction[idx][1];
				// 오른쪽을보다가 d가 나오면 오른쪽으로 회전하라.
				if (dir == -1) {
					dir = 3;
				}
				if (dir == 4) {
					dir = 0;
				}
				idx++;
//				System.out.println("방향안바꾸니? + dir : " + dir);
			}

//			for (int j = 1; j <= N; ++j) {
//				for (int k = 1; k <= N; ++k)
//					System.out.print(map[j][k]);
//				System.out.println();
//			}
//			System.out.println("--------------------------time : " + time);
			time++;
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		map[1][1] = 1;
		head = new Loc(1, 1);
		tail = new Loc(1, 1);
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
			// 2가 사과임~
		}
		dirQ = new LinkedList<Integer>();
		L = Integer.parseInt(br.readLine());
		direction = new int[L][2];
		for (int i = 0; i < L; ++i) {
			st = new StringTokenizer(br.readLine());
			direction[i][0] = Integer.parseInt(st.nextToken());
			String d = st.nextToken();
			if (d.equals("D")) {
				direction[i][1] = 1;
			} else if (d.equals("L")) {
				direction[i][1] = -1;
			}
		}

	}
}
