package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day151BOJ17070파이프옮기기DP {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int field[][] = new int[N + 1][N + 1];
		int D[][][] = new int[N + 1][N + 1][4]; // 행, 열, 상태(0: 없음, 1: 가로, 2: 세로, 3: 대각선)

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		D[1][2][1] = 1;

		for (int x = 1; x <= N; x++) {
			for (int y = 2; y <= N; y++) {
				if (field[x][y] == 1) {
					continue;
				} else {
					D[x][y][1] += D[x][y - 1][1] + D[x][y - 1][3];
					D[x][y][2] += D[x - 1][y][2] + D[x - 1][y][3];
					if (field[x][y - 1] == 1 || field[x - 1][y] == 1)
						continue;
					D[x][y][3] += D[x - 1][y - 1][1] + D[x - 1][y - 1][2] + D[x - 1][y - 1][3];
				}
			}
		}
		System.out.println(D[N][N][1] + D[N][N][2] + D[N][N][3]);
		br.close();
	}

}
