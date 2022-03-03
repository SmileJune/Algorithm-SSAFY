package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1220 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	static int solution() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		setMap(map);

		return countDeadlock(map);
	}

	static void setMap(int[][] map) {
		// 한줄씩 진행
		for (int i = 0; i < map.length; i++) {
			while (true) {
				// 하나씩 확인
				boolean move = false;
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == 0) {
						continue;
					}

					// 만약 N을 만났다. 1 => 다음 인덱스로 이동
					// 하지만 1회씩 확인해줘야하니까 j++를 먼저해줘서 넘어가게해야함.
					// 이동해야할 자리가 범위를 벗어난다면 해당자리 0으로 변경.
					// 이동하면 move true로 변함. 더이상 확인 안해줘도 되니 true
					if (map[i][j] == 1) {
						if (!isInRange(i, j + 1)) {
							map[i][j] = 0;
							continue;
						}

						if (map[i][j + 1] == 0) {
							map[i][j] = 0;
							map[i][j + 1] = 1;
							move = true;
							j++;
							continue;
						}
					}
					// 만약 S를 만났다. 2 => 그 전 인덱스로 이동
					if (map[i][j] == 2) {
						if (!isInRange(i, j - 1)) {
							map[i][j] = 0;
							continue;
						}

						if (map[i][j - 1] == 0) {
							map[i][j] = 0;
							map[i][j - 1] = 2;
							move = true;
							continue;
						}
					}

				}
				if (move == false) {
					break;
				}
			}
		}
	}

	static boolean isInRange(int r, int c) {
		if (0 <= r && r < N && 0 <= c && c < N) {
			return true;
		}
		return false;
	}

	static int countDeadlock(int[][] map) {
		// 한줄씩 확인
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			// 하나씩 돌다가 0이 아닌게 나오면 판단
			for (int j = 0; j < map[i].length; j++) {
				int swapCnt = 0;
				int pivot = map[i][j];
				while (map[i][j] != 0) {
					if (j == N - 1) {
						swapCnt++;
						break;
					}
					if (map[i][j + 1] != pivot) {
						swapCnt++;
						pivot = map[i][j + 1];
					}
					j++;
				}
				cnt += swapCnt / 2;
			}
		}
		return cnt;
	}

}
