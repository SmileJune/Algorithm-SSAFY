package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static int[][] arr;
	public static int[] dr = { -1, 0, 0 };
	public static int[] dc = { 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		for (int tc = 1; tc <= 10; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}

	}

	public static int solution() throws IOException {
		br.readLine();

		arr = new int[100][100];
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int initRow = 99;
		int initColumn = 0;

		for (int i = 0; i < arr[99].length; i++) {
			if (arr[99][i] == 2) {
				initColumn = i;
			}
		}

		return getDestColumn(initRow, initColumn);
	}

	public static int getDestColumn(int initRow, int initColumn) {
		int row = initRow;
		int col = initColumn;
		outer: while (row != 0) {
			// 왼쪽
			int nextLeftRow = row + dr[1];
			int nextLeftColumn = col + dc[1];
			if (nextLeftColumn >= 0 && arr[nextLeftRow][nextLeftColumn] == 1) {
				while (true) {
					row = nextLeftRow;
					col = nextLeftColumn;
					nextLeftRow = row + dr[1];
					nextLeftColumn = col + dc[1];
					if (nextLeftColumn >= 0 && arr[nextLeftRow][nextLeftColumn] != 1) {
						row -= 1;
						continue outer;
					}
				}
			}
			// 오른쪽
			int nextRightRow = row + dr[2];
			int nextRightCol = col + dc[2];
			if (nextRightCol < arr[0].length & arr[nextRightRow][nextRightCol] == 1) {
				while (true) {
					row = nextRightRow;
					col = nextRightCol;
					nextRightRow = row + dr[2];
					nextRightCol = col + dc[2];
					if (nextRightCol < arr[0].length && arr[nextRightRow][nextRightCol] != 1) {
						row -= 1;
						continue outer;
					}
				}
			}

			row -= 1;

		}

		return col;
	}

}
