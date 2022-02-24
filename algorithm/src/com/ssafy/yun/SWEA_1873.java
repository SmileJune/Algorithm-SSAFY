package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1873 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d ", tc);
			solution();
		}
	}

	static void solution() throws IOException {
		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int x = -1;
		int y = -1;

		char[][] map = new char[H + 2][W + 2];
		for (int i = 1; i < 1 + H; i++) {
			String str = br.readLine();
			for (int j = 1; j < 1 + W; j++) {
				char ch = str.charAt(j - 1);
				map[i][j] = ch;
				if ("^v<>".contains(ch + "")) {
					x = i;
					y = j;
				}
			}
		}

		int N = Integer.parseInt(br.readLine());
		String order = br.readLine();

		int nr = -1;
		int nc = -1;
		for (int i = 0; i < N; i++) {
			switch (order.charAt(i)) {
			case 'U':
				map[x][y] = '^';
				nr = x + dr[0];
				nc = y + dc[0];
				if (map[nr][nc] == '.') {
					map[x][y] = '.';
					map[nr][nc] = '^';
					x = nr;
					y = nc;
				}
				break;
			case 'D':
				map[x][y] = 'v';
				nr = x + dr[1];
				nc = y + dc[1];
				if (map[nr][nc] == '.') {
					map[x][y] = '.';
					map[nr][nc] = 'v';
					x = nr;
					y = nc;
				}
				break;
			case 'L':
				map[x][y] = '<';
				nr = x + dr[2];
				nc = y + dc[2];
				if (map[nr][nc] == '.') {
					map[x][y] = '.';
					map[nr][nc] = '<';
					x = nr;
					y = nc;
				}
				break;
			case 'R':
				map[x][y] = '>';
				nr = x + dr[3];
				nc = y + dc[3];
				if (map[nr][nc] == '.') {
					map[x][y] = '.';
					map[nr][nc] = '>';
					x = nr;
					y = nc;
				}
				break;
			case 'S':
				char direction = map[x][y];
				int idxRow = "^v<>".indexOf(direction);
				int idxCol = "^v<>".indexOf(direction);

				int len = 1;
				while (true) {
					nr = x + len * dr[idxRow];
					nc = y + len * dc[idxCol];

					if (map[nr][nc] == '\u0000') {
						break;
					}
					if (map[nr][nc] == '#') {
						break;
					}
					if (map[nr][nc] == '*') {
						map[nr][nc] = '.';
						break;
					}
					len++;
				}
				break;
			}
		}

		for (int i = 1; i < 1 + H; i++) {
			for (int j = 1; j < 1 + W; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

}
