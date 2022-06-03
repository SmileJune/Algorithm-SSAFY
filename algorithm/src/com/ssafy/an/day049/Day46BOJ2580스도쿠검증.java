package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day46BOJ2580스도쿠검증 { // 2580 스도쿠 검증
	static int[][] arr = new int[9][9];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sudoku(0, 0);

		br.close();
	}

	public static void sudoku(int row, int col) {
		if (col == 9) {
			sudoku(row + 1, 0);
			return;
		} // 다음줄부터 채우기
		
		if (row == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		} // 끝까지 다 채워진 경우에 출력 후 종료

		if (arr[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (isPossible(row, col, i)) {
					arr[row][col] = i;
					sudoku(row, col + 1);
				} // i를 넣을 수 있으면 넣고 재귀
			}
			arr[row][col] = 0; // 재귀 중에 종료되지 않으면 다시 값을 복구
			return;
		}

		sudoku(row, col + 1);
	}

	public static boolean isPossible(int row, int col, int value) {
		for (int i = 0; i < 9; i++) {
			if (arr[row][i] == value) {
				return false;
			} 
		}
		for (int i = 0; i < 9; i++) {
			if (arr[i][col] == value) {
				return false;
			}
		}
		int set_row = (row / 3) * 3;
		int set_col = (col / 3) * 3;
		for (int i = set_row; i < set_row + 3; i++) {
			for (int j = set_col; j < set_col + 3; j++) {
				if (arr[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}
}
