package com.ssafy.an;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Day17BOJ3190뱀SW역량기출 { // 3190 뱀(큐, 맵)
	static int[][] arr;
	static List<int[]> snake;
	static int idx, jdx;
	static int dir = 0;

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/an/input3190.txt")));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		snake = new LinkedList<>();
		arr = new int[N + 2][N + 2];
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				if (i == 0 || j == 0 || i == N + 1 || j == N + 1)
					arr[i][j] = 1;
			}
		}
		int K = Integer.parseInt(br.readLine());
		for (int n = 0; n < K; n++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
		}

		idx = 1;
		jdx = 1;

		snake.add(new int[] { idx, jdx });

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		int L = Integer.parseInt(br.readLine());
		String[][] cmd = new String[L][2];
		for (int l = 0; l < L; l++) {
			st = new StringTokenizer(br.readLine());
			cmd[l][0] = st.nextToken();
			cmd[l][1] = st.nextToken();
		}

		int ans = 0;
		int n = 0;
		arr[idx][jdx] = 1;
		while (true) {
			int time = Integer.parseInt(cmd[n][0]);
			String s = cmd[n][1];

			ans++;

			int nr = idx + dr[dir];
			int nc = jdx + dc[dir];

			if (arr[nr][nc] == 1)
				break;

			if (arr[nr][nc] == 2) {
				snake.add(new int[] { nr, nc });
				arr[nr][nc] = 1;
			} else if (arr[nr][nc] == 0) {
				snake.add(new int[] { nr, nc });
				arr[snake.get(0)[0]][snake.get(0)[1]] = 0;
				snake.remove(0);
			}

			idx = nr;
			jdx = nc;

			arr[idx][jdx] = 1;

			if (ans == time) {
				if (s.equals("D"))
					dir = (dir + 1) % 4;
				else if (s.equals("L"))
					dir = (dir + 3) % 4;
				if (n + 1 < L)
					n++; // 마지막 에러...
			}

		}
		for (int i = 0; i < N+2; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println(ans);
		br.close();
	}
}
